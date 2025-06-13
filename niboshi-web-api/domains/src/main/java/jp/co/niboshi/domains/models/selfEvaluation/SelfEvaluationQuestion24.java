package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion24 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion24(String selfEvaluationQuestion24) {
    if (Objects.isNull(selfEvaluationQuestion24)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion24.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion24;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
