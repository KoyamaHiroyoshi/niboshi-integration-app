package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion06 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion06(String selfEvaluationQuestion06) {
    if (Objects.isNull(selfEvaluationQuestion06)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion06.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion06;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
