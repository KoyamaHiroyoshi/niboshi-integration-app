package jp.co.nile.domains.models.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class PlayerTest {
  private PlayerId playerId;
  private PlayerName playerName;
  private Player player;

  @BeforeEach
  void setUp() {
    playerId = new PlayerId("f07e8324-0e14-4e4e-bbf3-0a901d2cfb78");
    playerName = new PlayerName("テスト名");
    player = Player.builder().id(playerId).name(playerName).build();
  }

  @Test
  void testGetPlayerId() {
    assertEquals(playerId.getUuid(), player.getId().getUuid());
  }

  @Test
  void testGetPlayerName() {
    assertEquals(playerName.toString(), player.getName().toString());
  }
}
