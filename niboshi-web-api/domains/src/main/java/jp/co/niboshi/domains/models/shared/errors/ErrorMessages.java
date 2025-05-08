package jp.co.niboshi.domains.models.shared.errors;

public enum ErrorMessages {
  /**
   * NULL
   */
  NULL("%sはNULL非許容です。"),
  /**
   * 空文字
   */
  EMPTY("%sは空文字非許容です。"),
  /**
   * リストサイズ
   */
  LIST_SIZE("%sは%d〜%d個で指定してください。"),
  /**
   * 未定義
   */
  UNKNOWN_VALUE("%sが未定義の値です。"),

  ;

  ErrorMessages(String message) {
    this.message = message;
  }

  private String message;

  public String getMessage() {
    return message;
  }
}
