package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion08 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion08(String selfEvaluationQuestion08) {
    if (Objects.isNull(selfEvaluationQuestion08)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion08.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion08;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
