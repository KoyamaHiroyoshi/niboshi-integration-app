package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion28 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion28(String selfEvaluationQuestion28) {
    if (Objects.isNull(selfEvaluationQuestion28)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion28.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion28;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
