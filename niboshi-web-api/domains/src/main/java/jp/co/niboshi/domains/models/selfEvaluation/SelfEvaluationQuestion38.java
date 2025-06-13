package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion38 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion38(String selfEvaluationQuestion38) {
    if (Objects.isNull(selfEvaluationQuestion38)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion38.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion38;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
