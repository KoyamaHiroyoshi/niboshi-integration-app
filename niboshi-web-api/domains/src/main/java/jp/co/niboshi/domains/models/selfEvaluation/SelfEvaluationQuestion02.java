package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion02 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion02(String selfEvaluationQuestion02) {
    if (Objects.isNull(selfEvaluationQuestion02)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion02.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion02;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
