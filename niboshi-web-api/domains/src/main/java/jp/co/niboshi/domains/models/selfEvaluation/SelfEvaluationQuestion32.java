package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion32 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion32(String selfEvaluationQuestion32) {
    if (Objects.isNull(selfEvaluationQuestion32)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion32.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion32;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
