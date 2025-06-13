package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion15 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion15(String selfEvaluationQuestion15) {
    if (Objects.isNull(selfEvaluationQuestion15)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion15.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion15;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
