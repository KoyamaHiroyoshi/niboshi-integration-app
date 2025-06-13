package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion46 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion46(String selfEvaluationQuestion46) {
    if (Objects.isNull(selfEvaluationQuestion46)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion46.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion46;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
