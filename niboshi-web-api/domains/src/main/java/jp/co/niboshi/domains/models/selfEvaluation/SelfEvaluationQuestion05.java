package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion05 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion05(String selfEvaluationQuestion05) {
    if (Objects.isNull(selfEvaluationQuestion05)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion05.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion05;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
