package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion36 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion36(String selfEvaluationQuestion36) {
    if (Objects.isNull(selfEvaluationQuestion36)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion36.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion36;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
