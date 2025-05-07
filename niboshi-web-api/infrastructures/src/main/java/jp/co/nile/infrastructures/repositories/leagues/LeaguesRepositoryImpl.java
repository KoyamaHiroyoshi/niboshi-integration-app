package jp.co.nile.infrastructures.repositories.leagues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import jp.co.nile.domains.models.games.CreatePlayerResultParams;
import jp.co.nile.domains.models.games.Game;
import jp.co.nile.domains.models.games.GameId;
import jp.co.nile.domains.models.games.RuleId;
import jp.co.nile.domains.models.games.UmaId;
import jp.co.nile.domains.models.leagues.CreateLeagueParams;
import jp.co.nile.domains.models.leagues.League;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.leagues.LeaguesRepository;
import jp.co.nile.domains.models.leagues.UpdateLeagueParams;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayerName;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class LeaguesRepositoryImpl implements LeaguesRepository {
  private final LeaguesMapper leaguesMapper;
  private final InfraLeaguesConverter infraLeaguesConverter;

  @Override
  public void createLeagues(List<CreateLeagueParams> createLeagueParams) {
    leaguesMapper.createLeagues(createLeagueParams
        .stream()
        .map(LeagueEntity::new)
        .toList());
  }

  @Override
  public List<League> findAllLeagues() {
    return leaguesMapper
        .selectAllLeagues()
        .stream()
        .map(infraLeaguesConverter::toLeague)
        .toList();
  }

  @Override
  public void updateLeague(UpdateLeagueParams updateLeagueParams) {
    leaguesMapper.updateLeague(
        new LeagueEntity(updateLeagueParams));
  }

  @Override
  public void deleteLeague(LeagueId leagueId) {
    leaguesMapper.deleteLeagues(List.of(leagueId));
  }

  @Override
  public void addPlayersToLeague(LeagueId leagueId, List<PlayerId> playerIds) {
    leaguesMapper.addPlayersToLeague(leagueId, playerIds);
  }

  @Override
  public List<Player> findLeaguePlayers(LeagueId leagueId) {
    return leaguesMapper.selectLeaguePlayers(leagueId)
        .stream()
        .map(entity -> Player.builder()
            .id(new PlayerId(entity.getLeagueId()))
            .name(new PlayerName(entity.getPlayerName()))
            .build())
        .toList();
  }

  @Override
  public GameId createGame(RuleId ruleId, UmaId umaId, Date eventDate) {
    GameId gameId = new GameId();
    leaguesMapper.createGame(new GameEntity(
        gameId.getUuid(),
        ruleId.getUuid(),
        umaId.getUuid()));
    return gameId;
  }

  @Override
  public List<Game> getLeagueGames(LeagueId leagueId) {
    List<LeagueGameJoinEntity> leaguesPlayersJoinPlayersEntities =
        leaguesMapper.selectLeagueGames(leagueId, null);

    return infraLeaguesConverter.toGames(leaguesPlayersJoinPlayersEntities);
  }

  @Override
  public void createPlayerResults(GameId gameId, List<CreatePlayerResultParams> playerResults) {
    // スコア昇順にソートして4位から計算
    // 同点の場合は起家から数えて順位をつける
    int result = 4;
    List<CreatePlayerResultParams> results = playerResults
        .stream()
        .sorted(
            Comparator
                .comparing(CreatePlayerResultParams::getScore)
                .thenComparing(CreatePlayerResultParams::getGameStartWind))
        .toList();

    List<PlayerResultEntity> playerResultEntities = new ArrayList<>();
    for (CreatePlayerResultParams params : results) {
      playerResultEntities.add(
          new PlayerResultEntity(
              gameId.getUuid(),
              params.getPlayerId().getUuid(),
              params.getScore(),
              result--));
    }

    leaguesMapper.createPlayerResults(playerResultEntities);
  }

  @Override
  public void createLeagueGame(LeagueId leagueId, GameId gameId, Date eventDate) {
    leaguesMapper.createLeagueGame(
        leagueId,
        gameId,
        eventDate);
  }

  @Override
  public Optional<League> findLeague(LeagueId leagueId) {
    LeagueEntity leagueEntity = leaguesMapper.selectLeague(leagueId);
    if (Objects.nonNull(leagueEntity)) {
      return Optional.of(infraLeaguesConverter.toLeague(leagueEntity));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deleteLeaguesGames(LeagueId leagueId) {
    leaguesMapper.deleteLeaguesGames(leagueId);
  }

  @Override
  public void deleteLeaguesPlayers(LeagueId leagueId) {
    leaguesMapper.deleteLeaguesPlayers(leagueId);
  }

  @Override
  public void deletePlayerResults(List<GameId> gameIds) {
    if (Objects.isNull(gameIds) || gameIds.isEmpty()) {
      return;
    }
    leaguesMapper.deletePlayerResults(gameIds);
  }

  @Override
  public void deleteGames(List<GameId> gameIds) {
    if (Objects.isNull(gameIds) || gameIds.isEmpty()) {
      return;
    }
    leaguesMapper.deleteGames(gameIds);
  }
}
