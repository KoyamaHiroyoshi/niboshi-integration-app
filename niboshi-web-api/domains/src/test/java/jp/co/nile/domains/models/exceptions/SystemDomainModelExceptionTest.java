package jp.co.nile.domains.models.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class SystemDomainModelExceptionTest {
  @Test
  void testGetField() {
    SystemDomainModelException e =
        new SystemDomainModelException("field", "reason", new Exception());
    assertEquals("field", e.getField());
  }

  @Test
  void testGetMessage() {
    SystemDomainModelException e =
        new SystemDomainModelException("field", "reason", new Exception());
    assertEquals("システムドメインモデル作成エラー", e.getMessage());
  }

  @Test
  void testGetReason() {
    SystemDomainModelException e =
        new SystemDomainModelException("field", "reason", new Exception());
    assertEquals("reason", e.getReason());
  }
}
