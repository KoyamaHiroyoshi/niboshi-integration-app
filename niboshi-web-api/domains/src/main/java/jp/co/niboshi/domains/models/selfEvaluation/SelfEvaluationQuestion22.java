package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion22 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion22(String selfEvaluationQuestion22) {
    if (Objects.isNull(selfEvaluationQuestion22)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion22.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion22;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
