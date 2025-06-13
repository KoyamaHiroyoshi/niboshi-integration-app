package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion17 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion17(String selfEvaluationQuestion17) {
    if (Objects.isNull(selfEvaluationQuestion17)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion17.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion17;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
