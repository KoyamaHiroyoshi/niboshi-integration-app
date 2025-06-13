package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion42 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion42(String selfEvaluationQuestion42) {
    if (Objects.isNull(selfEvaluationQuestion42)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion42.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion42;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
