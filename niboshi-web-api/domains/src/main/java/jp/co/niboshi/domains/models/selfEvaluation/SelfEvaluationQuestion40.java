package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion40 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion40(String selfEvaluationQuestion40) {
    if (Objects.isNull(selfEvaluationQuestion40)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion40.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion40;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
