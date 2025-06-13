package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion23 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion23(String selfEvaluationQuestion23) {
    if (Objects.isNull(selfEvaluationQuestion23)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion23.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion23;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
