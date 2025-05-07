package jp.co.nile.domains.models.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class NileModelTest {
  class TestNileModel implements NileModel {
    public TestNileModel() {}
  }

  @Test
  void testGetModelName() {
    assertEquals("TestNileModel", new TestNileModel().getModelName());
  }

  @Test
  void testThrowDomainModelException() {
    NileModel nileModel = new TestNileModel();
    assertThrows(DomainModelException.class, () -> nileModel.throwDomainModelException("テストエラー"));
  }
}
