package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion09 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion09(String selfEvaluationQuestion09) {
    if (Objects.isNull(selfEvaluationQuestion09)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion09.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion09;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
