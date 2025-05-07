package jp.co.nile.domains.models.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class PlayerNameTest {
  @Test
  void 成功_生成() {
    PlayerName playerName = new PlayerName("playerName");
    assertEquals("playerName", playerName.toString());
  }

  @Test
  void 失敗_nullからの生成() {
    DomainModelException domainModelException =
        assertThrows(DomainModelException.class, () -> new PlayerName(null));

    assertEquals("PlayerName", domainModelException.getField());
    assertEquals("PlayerNameはNULL非許容です。", domainModelException.getReason());
  }

  @Test
  void 失敗_空文字からの生成() {
    DomainModelException domainModelException =
        assertThrows(DomainModelException.class, () -> new PlayerName(""));

    assertEquals("PlayerName", domainModelException.getField());
    assertEquals("PlayerNameは空文字非許容です。", domainModelException.getReason());
  }

  @Test
  void 成功_文字列化() {
    assertEquals("テストプレイヤー名", new PlayerName("テストプレイヤー名").toString());
  }
}
