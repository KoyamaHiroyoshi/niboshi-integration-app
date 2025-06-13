package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion04 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion04(String selfEvaluationQuestion04) {
    if (Objects.isNull(selfEvaluationQuestion04)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion04.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion04;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
