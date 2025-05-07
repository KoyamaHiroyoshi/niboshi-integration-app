package jp.co.nile.domains.models.games;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayerName;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class GameTest {
  @Test
  void testGetCalculatedPlayerScore() {
    final GameId gameId = new GameId();
    final PlayerResult playerResult1 = PlayerResult.builder()
        .gameId(gameId)
        .player(Player
            .builder()
            .id(new PlayerId())
            .name(new PlayerName("p1"))
            .build())
        .score(44500)
        .result(1)
        .build();
    final PlayerResult playerResult2 = PlayerResult.builder()
        .gameId(gameId)
        .player(Player
            .builder()
            .id(new PlayerId())
            .name(new PlayerName("p2"))
            .build())
        .score(30600)
        .result(2)
        .build();
    final PlayerResult playerResult3 = PlayerResult.builder()
        .gameId(gameId)
        .player(Player
            .builder()
            .id(new PlayerId())
            .name(new PlayerName("p3"))
            .build())
        .score(19400)
        .result(3)
        .build();
    final PlayerResult playerResult4 = PlayerResult.builder()
        .gameId(gameId)
        .player(Player
            .builder()
            .id(new PlayerId())
            .name(new PlayerName("p4"))
            .build())
        .score(5500)
        .result(4)
        .build();

    Game game = Game.builder()
        .id(new GameId())
        .leagueId(new LeagueId())
        .rule(Rule
            .builder()
            .id(new RuleId())
            .name("半荘")
            .build())
        .uma(Uma.builder()
            .id(new UmaId())
            .name("10-30")
            .firstPlaceRate(30)
            .secondPlaceRate(10)
            .build())
        .playerResults(List.of(playerResult1, playerResult2, playerResult3, playerResult4))
        .evenDate(new Date())
        .build();

    Map<PlayerId, Float> calculatedPlayerScore = game.getCalculatedPlayerScore();
    assertEquals(64.5f, calculatedPlayerScore.get(playerResult1.getPlayer().getId()));
    assertEquals(10.6f, calculatedPlayerScore.get(playerResult2.getPlayer().getId()));
    assertEquals(-20.6f, calculatedPlayerScore.get(playerResult3.getPlayer().getId()));
    assertEquals(-54.5f, calculatedPlayerScore.get(playerResult4.getPlayer().getId()));
  }
}
