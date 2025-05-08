package jp.co.niboshi.domains.models.exceptions;

import lombok.Getter;

/**
 * システムからモデルを作成した際に発生したエラー<br>
 * 例）DB値、対向IFなど
 */
@Getter
public class SystemDomainModelException extends DomainModelException {
  public SystemDomainModelException(String message, String reason, Exception e) {
    super(message, reason, e);
  }

  @Override
  public String getMessage() {
    return "システムドメインモデル作成エラー";
  }
}
