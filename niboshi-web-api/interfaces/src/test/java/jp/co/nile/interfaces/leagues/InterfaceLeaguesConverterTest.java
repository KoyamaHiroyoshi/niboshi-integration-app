package jp.co.nile.interfaces.leagues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openapitools.model.League;
import jp.co.nile.domains.models.games.GameId;
import jp.co.nile.domains.models.games.Rule;
import jp.co.nile.domains.models.games.RuleId;
import jp.co.nile.domains.models.games.Uma;
import jp.co.nile.domains.models.games.UmaId;
import jp.co.nile.domains.models.leagues.LeagueEndAt;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.leagues.LeagueName;
import jp.co.nile.domains.models.leagues.LeagueStartAt;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayerName;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class InterfaceLeaguesConverterTest {

  private InterfaceLeaguesConverter converter;

  @BeforeEach
  void setUp() {
    converter = new InterfaceLeaguesConverter();
  }

  @Test
  void testToInterfaceGame() {
    // テストデータの準備
    UUID gameId = UUID.randomUUID();
    UUID playerId1 = UUID.randomUUID();
    UUID playerId2 = UUID.randomUUID();
    UUID playerId3 = UUID.randomUUID();
    UUID playerId4 = UUID.randomUUID();
    UUID leagueId = UUID.randomUUID();
    UUID ruleId = UUID.randomUUID();
    UUID umaId = UUID.randomUUID();
    Date eventDate = new Date();

    // プレイヤーの作成
    Player player1 = Player.builder()
        .id(new PlayerId(playerId1))
        .name(new PlayerName("Player 1"))
        .build();
    Player player2 = Player.builder()
        .id(new PlayerId(playerId2))
        .name(new PlayerName("Player 2"))
        .build();
    Player player3 = Player.builder()
        .id(new PlayerId(playerId3))
        .name(new PlayerName("Player 3"))
        .build();
    Player player4 = Player.builder()
        .id(new PlayerId(playerId4))
        .name(new PlayerName("Player 4"))
        .build();

    // プレイヤー結果の作成
    jp.co.nile.domains.models.games.PlayerResult playerResult1 =
        jp.co.nile.domains.models.games.PlayerResult.builder()
            .gameId(new GameId(gameId))
            .player(player1)
            .score(35000)
            .result(1)
            .build();
    jp.co.nile.domains.models.games.PlayerResult playerResult2 =
        jp.co.nile.domains.models.games.PlayerResult.builder()
            .gameId(new GameId(gameId))
            .player(player2)
            .score(25000)
            .result(2)
            .build();
    jp.co.nile.domains.models.games.PlayerResult playerResult3 =
        jp.co.nile.domains.models.games.PlayerResult.builder()
            .gameId(new GameId(gameId))
            .player(player3)
            .score(25000)
            .result(3)
            .build();
    jp.co.nile.domains.models.games.PlayerResult playerResult4 =
        jp.co.nile.domains.models.games.PlayerResult.builder()
            .gameId(new GameId(gameId))
            .player(player4)
            .score(15000)
            .result(4)
            .build();

    // ルールとウマの作成
    Rule rule = Rule.builder()
        .id(new RuleId(ruleId))
        .name("半荘")
        .build();
    Uma uma = Uma.builder()
        .id(new UmaId(umaId))
        .name("10-30")
        .firstPlaceRate(30)
        .secondPlaceRate(10)
        .build();

    // ドメインのGameオブジェクトの作成
    jp.co.nile.domains.models.games.Game domainGame = jp.co.nile.domains.models.games.Game.builder()
        .id(new GameId(gameId))
        .leagueId(new LeagueId(leagueId))
        .rule(rule)
        .uma(uma)
        .playerResults(List.of(playerResult1, playerResult2, playerResult3, playerResult4))
        .evenDate(eventDate)
        .build();

    // テスト対象メソッドの実行
    org.openapitools.model.Game result = converter.toInterfaceGame(domainGame);

    // 結果の検証
    assertEquals(gameId, result.getId());
    assertEquals("半荘", result.getRule().getName());
    assertEquals("10-30", result.getUma().getName());
    assertEquals(30, result.getUma().getFirstPlaceRate());
    assertEquals(10, result.getUma().getSecondPlaceRate());
    assertEquals(4, result.getPlayerResults().size());

    // プレイヤー結果の検証
    org.openapitools.model.PlayerResult result1 = result.getPlayerResults().get(0);
    assertEquals(playerId1.toString(), result1.getPlayer().getId());
    assertEquals("Player 1", result1.getPlayer().getName());
    assertEquals(55.0f, result1.getScore());
    assertEquals(1, result1.getResult());

    org.openapitools.model.PlayerResult result2 = result.getPlayerResults().get(1);
    assertEquals(playerId2.toString(), result2.getPlayer().getId());
    assertEquals("Player 2", result2.getPlayer().getName());
    assertEquals(5f, result2.getScore());
    assertEquals(2, result2.getResult());

    org.openapitools.model.PlayerResult result3 = result.getPlayerResults().get(2);
    assertEquals(playerId3.toString(), result3.getPlayer().getId());
    assertEquals("Player 3", result3.getPlayer().getName());
    assertEquals(-15f, result3.getScore());
    assertEquals(3, result3.getResult());

    org.openapitools.model.PlayerResult result4 = result.getPlayerResults().get(3);
    assertEquals(playerId4.toString(), result4.getPlayer().getId());
    assertEquals("Player 4", result4.getPlayer().getName());
    assertEquals(-45f, result4.getScore());
    assertEquals(4, result4.getResult());
  }

  @Test
  void testToInterfaceLeague_WithEndAt() {
    // テストデータの準備
    UUID leagueId = UUID.randomUUID();
    Date startDate = new Date();
    Date endDate = new Date(startDate.getTime() + 86400000); // 1日後

    // ドメインのLeagueオブジェクトの作成
    jp.co.nile.domains.models.leagues.League domainLeague =
        jp.co.nile.domains.models.leagues.League.builder()
            .id(new LeagueId(leagueId))
            .name(new LeagueName("Test League"))
            .startAt(new LeagueStartAt(startDate))
            .endAt(new LeagueEndAt(endDate))
            .build();

    // テスト対象メソッドの実行
    League result = converter.toInterfaceLeague(domainLeague);

    // 結果の検証
    assertEquals(leagueId.toString(), result.getId());
    assertEquals("Test League", result.getName());
    assertEquals(startDate.toInstant().atZone(java.time.ZoneId.of("Asia/Tokyo")).toLocalDate(),
        result.getStartAt());
    assertEquals(endDate.toInstant().atZone(java.time.ZoneId.of("Asia/Tokyo")).toLocalDate(),
        result.getEndAt());
  }

  @Test
  void testToInterfaceLeague_WithoutEndAt() {
    // テストデータの準備
    UUID leagueId = UUID.randomUUID();
    Date startDate = new Date();

    // ドメインのLeagueオブジェクトの作成（endAtなし）
    jp.co.nile.domains.models.leagues.League domainLeague =
        jp.co.nile.domains.models.leagues.League.builder()
            .id(new LeagueId(leagueId))
            .name(new LeagueName("Test League"))
            .startAt(new LeagueStartAt(startDate))
            .build();

    // テスト対象メソッドの実行
    League result = converter.toInterfaceLeague(domainLeague);

    // 結果の検証
    assertEquals(leagueId.toString(), result.getId());
    assertEquals("Test League", result.getName());
    assertEquals(startDate.toInstant().atZone(java.time.ZoneId.of("Asia/Tokyo")).toLocalDate(),
        result.getStartAt());
    assertNull(result.getEndAt());
  }
}
