package jp.co.nile.interfaces.leagues;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.openapitools.api.LeaguesApi;
import org.openapitools.model.CreateGameRequest;
import org.openapitools.model.CreateLeagueParams;
import org.openapitools.model.CreateLeaguePlayersRequest;
import org.openapitools.model.CreateLeaguesRequest;
import org.openapitools.model.Game;
import org.openapitools.model.League;
import org.openapitools.model.Leagues;
import org.openapitools.model.Players;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import jp.co.nile.applications.usecases.leagues.LeagueUsecases;
import jp.co.nile.domains.models.games.CreateGameParams;
import jp.co.nile.domains.models.games.CreatePlayerResultParams;
import jp.co.nile.domains.models.games.GameStartWind;
import jp.co.nile.domains.models.games.RuleId;
import jp.co.nile.domains.models.games.UmaId;
import jp.co.nile.domains.models.leagues.LeagueEndAt;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.leagues.LeagueName;
import jp.co.nile.domains.models.leagues.LeagueStartAt;
import jp.co.nile.domains.models.leagues.UpdateLeagueParams;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.shared.NileDateUtils;
import jp.co.nile.interfaces.players.InterfacePlayersConverter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LeaguesController implements LeaguesApi {
  private final LeagueUsecases leagueUsecases;
  private final InterfaceLeaguesConverter interfaceLeaguesConverter;
  private final InterfacePlayersConverter interfacePlayersConverter;

  @Override
  public ResponseEntity<Void> createGames(String leagueId,
      @Valid CreateGameRequest createGameRequest) {
    // TODO: Springのバリデーションをやめて、ドメインに変換するときのエラーをバリデーションエラーにした方が処理統一できる？要検討
    CreateGameParams createGameParams = new CreateGameParams(
        new LeagueId(leagueId),
        NileDateUtils.toDate(createGameRequest.getEventDate()),
        new RuleId(createGameRequest.getRuleId()),
        new UmaId(createGameRequest.getUmaId()),
        createGameRequest.getPlayerResults()
            .stream()
            .map(playerResult -> CreatePlayerResultParams.builder()
                .playerId(new PlayerId(playerResult.getPlayerId()))
                .score(playerResult.getScore())
                .gameStartWind(GameStartWind.from(playerResult
                    .getGameStartWind()
                    .getValue()))
                .build())
            .toList());

    leagueUsecases.createGame(createGameParams);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> createLeaguePlayers(String leagueId,
      @Valid CreateLeaguePlayersRequest createLeaguePlayersRequest) {
    leagueUsecases.addPlayersToLeague(
        new LeagueId(leagueId),
        createLeaguePlayersRequest
            .getPlayerIds()
            .stream()
            .map(PlayerId::new)
            .toList());
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> createLeagues(@Valid CreateLeaguesRequest createLeaguesRequest) {
    List<jp.co.nile.domains.models.leagues.CreateLeagueParams> createLeagueParams =
        createLeaguesRequest
            .getLeagues()
            .stream()
            .map(league -> {
              LeagueEndAt endAt = null;
              if (Objects.nonNull(league.getEndAt())) {
                endAt = new LeagueEndAt(NileDateUtils.toDate(league.getEndAt()));
              }

              return jp.co.nile.domains.models.leagues.CreateLeagueParams
                  .builder()
                  .name(new LeagueName(league.getName()))
                  .startAt(
                      new LeagueStartAt(NileDateUtils.toDate(league.getStartAt())))
                  .endAt(endAt)
                  .build();
            })
            .toList();
    leagueUsecases.createLeagues(createLeagueParams);

    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> deleteLeague(String leagueId) {
    leagueUsecases.deleteLeague(new LeagueId(leagueId));
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Leagues> findAllLeagues() {
    return ResponseEntity.ok()
        .body(new Leagues()
            .leagues(leagueUsecases.findAllLeagues()
                .stream()
                .map(interfaceLeaguesConverter::toInterfaceLeague)
                .toList()));
  }

  @Override
  public ResponseEntity<List<Game>> findLeagueGames(String leagueId) {
    return ResponseEntity.ok()
        .body(leagueUsecases
            .getLeagueGames(new LeagueId(leagueId))
            .stream()
            .map(interfaceLeaguesConverter::toInterfaceGame)
            .toList());
  }

  @Override
  public ResponseEntity<Players> findLeaguePlayers(String leagueId) {
    return ResponseEntity.ok().body(
        interfacePlayersConverter
            .toInterfaceFindAllPlayersResponse(
                leagueUsecases.findLeaguePlayers(new LeagueId(leagueId))));
  }

  @Override
  public ResponseEntity<Void> updateLeague(String leagueId, @Valid CreateLeagueParams body) {
    leagueUsecases.updateLeague(UpdateLeagueParams
        .builder()
        .id(new LeagueId(leagueId))
        .name(new LeagueName(body.getName()))
        .startAt(new LeagueStartAt(NileDateUtils.toDate(body.getStartAt())))
        .endAt(Objects.nonNull(
            body.getEndAt())
                ? new LeagueEndAt(NileDateUtils.toDate(body.getEndAt()))
                : null)
        .build());
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<League> findLeague(String leagueId) {
    Optional<League> leagueOpt = leagueUsecases
        .findLeague(new LeagueId(leagueId))
        .map(interfaceLeaguesConverter::toInterfaceLeague);
    return ResponseEntity.ok()
        .body(leagueOpt.orElse(null));
  }
}
