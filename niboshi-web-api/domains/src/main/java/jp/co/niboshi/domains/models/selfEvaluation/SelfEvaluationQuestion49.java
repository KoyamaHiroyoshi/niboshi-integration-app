package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion49 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion49(String selfEvaluationQuestion49) {
    if (Objects.isNull(selfEvaluationQuestion49)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion49.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion49;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
