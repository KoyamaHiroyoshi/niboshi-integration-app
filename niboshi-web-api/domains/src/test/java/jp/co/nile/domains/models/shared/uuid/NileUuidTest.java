package jp.co.nile.domains.models.shared.uuid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class NileUuidTest {
  @Test
  void 成功_UUIDからの生成() {
    UUID testUuid = UUID.randomUUID();
    NileUuid nileUuid = new NileUuid(testUuid);

    assertEquals(testUuid, nileUuid.getUuid());
    assertEquals(testUuid.toString(), nileUuid.toString());
  }

  @Test
  void 成功_ランダムUUIDからの生成() {
    NileUuid nileUuid = new NileUuid();
    assertNotNull(nileUuid.getUuid());
  }

  @Test
  void 成功_UUID文字列からの生成() {
    NileUuid nileUuid = new NileUuid("a1aa6010-87ab-48ed-9872-a7352117f9db");
    assertNotNull(nileUuid.getUuid());
  }

  @Test
  void 失敗_フォーマット不正() {
    assertThrows(DomainModelException.class, () -> new NileUuid("dummy"));
  }
}
