package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion31 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion31(String selfEvaluationQuestion31) {
    if (Objects.isNull(selfEvaluationQuestion31)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion31.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion31;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
