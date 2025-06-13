package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion12 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion12(String selfEvaluationQuestion12) {
    if (Objects.isNull(selfEvaluationQuestion12)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion12.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion12;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
