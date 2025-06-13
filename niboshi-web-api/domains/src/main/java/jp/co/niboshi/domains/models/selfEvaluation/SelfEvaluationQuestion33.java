package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion33 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion33(String selfEvaluationQuestion33) {
    if (Objects.isNull(selfEvaluationQuestion33)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion33.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion33;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
