package jp.co.nile.domains.models.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class CreatePlayerParamsTest {
  @Test
  void testGetPlayerName() {
    PlayerName playerName = new PlayerName("テスト名");

    CreatePlayerParams createPlayerParams = new CreatePlayerParams(playerName);
    assertEquals(playerName.toString(), createPlayerParams.getPlayerName().toString());
  }
}
