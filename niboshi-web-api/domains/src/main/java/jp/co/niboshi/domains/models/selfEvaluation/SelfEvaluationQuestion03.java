package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion03 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion03(String selfEvaluationQuestion03) {
    if (Objects.isNull(selfEvaluationQuestion03)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion03.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion03;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
