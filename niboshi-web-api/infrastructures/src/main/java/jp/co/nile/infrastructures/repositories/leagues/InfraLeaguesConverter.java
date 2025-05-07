package jp.co.nile.infrastructures.repositories.leagues;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import jp.co.nile.domains.models.games.Game;
import jp.co.nile.domains.models.games.GameId;
import jp.co.nile.domains.models.games.PlayerResult;
import jp.co.nile.domains.models.games.Rule;
import jp.co.nile.domains.models.games.RuleId;
import jp.co.nile.domains.models.games.Uma;
import jp.co.nile.domains.models.games.UmaId;
import jp.co.nile.domains.models.leagues.League;
import jp.co.nile.domains.models.leagues.LeagueEndAt;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.leagues.LeagueName;
import jp.co.nile.domains.models.leagues.LeagueStartAt;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayerName;

@Component
public class InfraLeaguesConverter {
  public League toLeague(@NonNull LeagueEntity leagueEntity) {
    LeagueEndAt endAt = null;
    if (Objects.nonNull(leagueEntity.getEndAt())) {
      endAt = new LeagueEndAt(leagueEntity.getEndAt());
    }

    return League.builder()
        .id(new LeagueId(leagueEntity.getId()))
        .name(new LeagueName(
            leagueEntity.getName()))
        .startAt(
            new LeagueStartAt(leagueEntity
                .getStartAt()))
        .endAt(endAt)
        .build();
  }

  public PlayerResult toPlayerResult(PlayerResultJoinPlayersEntity playerResultJoinEntity) {
    return PlayerResult.builder()
        .gameId(new GameId(playerResultJoinEntity.getGameId()))
        .player(
            Player.builder()
                .id(new PlayerId(playerResultJoinEntity.getPlayerId()))
                .name(new PlayerName(playerResultJoinEntity.getPlayerName()))
                .build())
        .score(playerResultJoinEntity.getScore())
        .result(playerResultJoinEntity.getResult())
        .build();
  }

  public List<Game> toGames(List<LeagueGameJoinEntity> joinEntities) {
    if (Objects.isNull(joinEntities) || joinEntities.isEmpty()) {
      return List.of();
    }

    return joinEntities
        .stream()
        // ゲームIDごとにグルーピングして1ゲームオブジェクトを生成
        .collect(Collectors.groupingBy(LeagueGameJoinEntity::getGameId))
        .entrySet()
        .stream()
        .map(entry -> {
          // GameId, LeagueId, Rule, UmaはゲームID毎にグルーピングされたListの中では同じになる
          final LeagueGameJoinEntity oneOfGameResult = entry.getValue().get(0);
          final GameId gameId = new GameId(oneOfGameResult.getGameId());
          final LeagueId leagueId = new LeagueId(oneOfGameResult.getLeagueId());
          final Rule rule = Rule.builder()
              .id(new RuleId(oneOfGameResult.getRuleId()))
              .name(oneOfGameResult.getRuleName())
              .build();
          final Uma uma = Uma.builder()
              .id(new UmaId(oneOfGameResult.getUmaId()))
              .name(oneOfGameResult.getUmaName())
              .secondPlaceRate(oneOfGameResult.getSecondPlaceRate())
              .firstPlaceRate(oneOfGameResult.getFirstPlaceRate())
              .build();

          return Game
              .builder()
              .id(gameId)
              .leagueId(leagueId)
              .rule(rule)
              .uma(uma)
              .playerResults(entry
                  .getValue()
                  .stream()
                  .map(entity -> {
                    return PlayerResult
                        .builder()
                        .gameId(gameId)
                        .player(Player.builder()
                            .id(new PlayerId(entity.getPlayerId()))
                            .name(new PlayerName(
                                entity.getPlayerName()))
                            .build())
                        .score(entity.getScore())
                        .result(entity.getResult())
                        .build();
                  })
                  .toList())
              .evenDate(oneOfGameResult.getEventDate())
              .build();
        })
        .toList();
  }
}
