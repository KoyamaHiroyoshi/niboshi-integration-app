package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion13 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion13(String selfEvaluationQuestion13) {
    if (Objects.isNull(selfEvaluationQuestion13)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion13.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion13;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
