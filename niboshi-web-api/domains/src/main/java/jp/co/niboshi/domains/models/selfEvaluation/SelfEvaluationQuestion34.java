package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion34 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion34(String selfEvaluationQuestion34) {
    if (Objects.isNull(selfEvaluationQuestion34)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion34.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion34;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
