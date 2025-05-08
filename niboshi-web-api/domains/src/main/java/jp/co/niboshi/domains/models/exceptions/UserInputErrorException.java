package jp.co.niboshi.domains.models.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー入力値エラー<br>
 * バリデーションエラーにならない正常値で、存在しないIDの指定など
 */
@AllArgsConstructor
@Getter
public class UserInputErrorException extends RuntimeException {
  private final String reason;

  public UserInputErrorException(String reason, Exception e) {
    super(e);
    this.reason = reason;
  }
}
