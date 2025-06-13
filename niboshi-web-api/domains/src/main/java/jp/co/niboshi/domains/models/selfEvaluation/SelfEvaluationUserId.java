package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationUserId implements NiboshiModel {
  private String inner;

  public SelfEvaluationUserId(String selfEvaluationUserId) {
    if (Objects.isNull(selfEvaluationUserId)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationUserId.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationUserId;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}

