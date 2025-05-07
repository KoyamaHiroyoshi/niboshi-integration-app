package jp.co.nile.domains.models.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * モデル引数エラー
 */
@AllArgsConstructor
@Getter
public class DomainModelException extends RuntimeException {
  private final String field;
  private final String reason;

  public DomainModelException(String field, String reason, Exception e) {
    super(e);
    this.field = field;
    this.reason = reason;
  }

  public String getField() {
    return this.field;
  }

  public String getReason() {
    return this.reason;
  }

  @Override
  public String getMessage() {
    return "ドメインモデル作成エラー";
  }
}
