package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion14 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion14(String selfEvaluationQuestion14) {
    if (Objects.isNull(selfEvaluationQuestion14)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion14.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion14;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
