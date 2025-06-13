package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion21 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion21(String selfEvaluationQuestion21) {
    if (Objects.isNull(selfEvaluationQuestion21)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion21.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion21;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
