package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion29 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion29(String selfEvaluationQuestion29) {
    if (Objects.isNull(selfEvaluationQuestion29)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion29.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion29;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
