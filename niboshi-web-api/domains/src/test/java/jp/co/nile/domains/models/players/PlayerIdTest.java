package jp.co.nile.domains.models.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class PlayerIdTest {
  private String playerIdStr;
  private PlayerId playerId;

  @BeforeEach
  void setUp() {
    playerIdStr = "f07e8324-0e14-4e4e-bbf3-0a901d2cfb78";
    playerId = new PlayerId(playerIdStr);
  }

  @Test
  void testGetUuid() {
    assertEquals(playerIdStr, playerId.getUuid().toString());
  }

  @Test
  void testCreateFromUuid() {
    UUID uuid = UUID.randomUUID();
    assertEquals(uuid, new PlayerId(uuid).getUuid());
  }
}
