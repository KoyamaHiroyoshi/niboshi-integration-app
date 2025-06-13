package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion10 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion10(String selfEvaluationQuestion10) {
    if (Objects.isNull(selfEvaluationQuestion10)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion10.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion10;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
