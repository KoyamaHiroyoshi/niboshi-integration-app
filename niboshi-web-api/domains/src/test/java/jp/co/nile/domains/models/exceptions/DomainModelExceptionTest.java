package jp.co.nile.domains.models.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class DomainModelExceptionTest {
  @Test
  void testGetField() {
    DomainModelException e = new DomainModelException("field", "reason", new Exception());
    assertEquals("field", e.getField());
  }

  @Test
  void testGetMessage() {
    DomainModelException e = new DomainModelException("field", "reason", new Exception());
    assertEquals("ドメインモデル作成エラー", e.getMessage());
  }

  @Test
  void testGetReason() {
    DomainModelException e = new DomainModelException("field", "reason", new Exception());
    assertEquals("reason", e.getReason());
  }
}
