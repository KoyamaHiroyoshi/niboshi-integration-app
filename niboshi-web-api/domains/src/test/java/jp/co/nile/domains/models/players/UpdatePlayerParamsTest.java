package jp.co.nile.domains.models.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class UpdatePlayerParamsTest {
  private PlayerId userId;
  private PlayerName userName;
  private UpdatePlayerParams updateUserParams;

  @BeforeEach
  void setUp() {
    this.userId = new PlayerId();
    this.userName = new PlayerName("テスト名");
    updateUserParams = UpdatePlayerParams.builder().id(userId).name(userName).build();
  }

  @Test
  void testGetId() {
    assertEquals(userId.getUuid(), updateUserParams.getId().getUuid());
  }

  @Test
  void testGetName() {
    assertEquals(userName.toString(), updateUserParams.getName().toString());
  }
}
