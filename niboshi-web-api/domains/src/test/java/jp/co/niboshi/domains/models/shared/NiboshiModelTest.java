package jp.co.niboshi.domains.models.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.shared.tests.TestTarget;

@Tag(TestTarget.UNIT_TEST)
class NiboshiModelTest {
  class TestNiboshiModel implements NiboshiModel {
    public TestNiboshiModel() {}
  }

  @Test
  void testGetModelName() {
    assertEquals("TestNiboshiModel", new TestNiboshiModel().getModelName());
  }

  @Test
  void testThrowDomainModelException() {
    NiboshiModel niboshiModel = new TestNiboshiModel();
    assertThrows(DomainModelException.class,
        () -> niboshiModel.throwDomainModelException("テストエラー"));
  }
}
