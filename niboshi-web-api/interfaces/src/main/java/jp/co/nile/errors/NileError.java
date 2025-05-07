package jp.co.nile.errors;

import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.exceptions.SystemDomainModelException;
import lombok.Builder;
import lombok.Getter;

/**
 * 400エラー時の設定項目
 */
@Builder
@Getter
public class NileError {
  private String field;
  private String reason;

  public NileError(String field, String reason) {
    this.field = field;
    this.reason = reason;
  }

  public NileError(DomainModelException domainModelException) {
    this.field = domainModelException.getField();
    this.reason = domainModelException.getReason();
  }

  public NileError(SystemDomainModelException systemModelException) {
    this.field = systemModelException.getField();
    this.reason = systemModelException.getReason();
  }
}
