package jp.co.niboshi.domains.models.shared.tests;

/**
 * テスト時の @Tag に指定するテスト対象文字列定数クラス
 */
public class TestTarget {
  private TestTarget() {
    // Do nothing
  }

  /**
   * 単体テスト向け
   */
  public static final String UNIT_TEST = "UnitTest";
  /**
   * 結合テスト向け
   */
  public static final String INTEGRATION_TEST = "IntegrationTest";
}
