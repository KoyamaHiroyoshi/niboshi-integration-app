package jp.co.niboshi.domains.models.shared.uuid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class NiboshiUuidTest {
  @Test
  void 成功_UUIDからの生成() {
    UUID testUuid = UUID.randomUUID();
    NiboshiUuid niboshiUuid = new NiboshiUuid(testUuid);

    assertEquals(testUuid, niboshiUuid.getUuid());
    assertEquals(testUuid.toString(), niboshiUuid.toString());
  }

  @Test
  void 成功_ランダムUUIDからの生成() {
    NiboshiUuid niboshiUuid = new NiboshiUuid();
    assertNotNull(niboshiUuid.getUuid());
  }

  @Test
  void 成功_UUID文字列からの生成() {
    NiboshiUuid niboshiUuid = new NiboshiUuid("a1aa6010-87ab-48ed-9872-a7352117f9db");
    assertNotNull(niboshiUuid.getUuid());
  }

  @Test
  void 失敗_フォーマット不正() {
    assertThrows(DomainModelException.class, () -> new NiboshiUuid("dummy"));
  }
}
