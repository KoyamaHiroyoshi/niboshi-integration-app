package jp.co.niboshi.errors;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;
import jp.co.niboshi.domains.models.exceptions.SystemDomainModelException;
import lombok.Builder;
import lombok.Getter;

/**
 * 400エラー時の設定項目
 */
@Builder
@Getter
public class Niboshi400Error {
  private String field;
  private String reason;

  public Niboshi400Error(String field, String reason) {
    this.field = field;
    this.reason = reason;
  }

  public Niboshi400Error(DomainModelException domainModelException) {
    this.field = domainModelException.getField();
    this.reason = domainModelException.getReason();
  }

  public Niboshi400Error(SystemDomainModelException systemModelException) {
    this.field = systemModelException.getField();
    this.reason = systemModelException.getReason();
  }
}
