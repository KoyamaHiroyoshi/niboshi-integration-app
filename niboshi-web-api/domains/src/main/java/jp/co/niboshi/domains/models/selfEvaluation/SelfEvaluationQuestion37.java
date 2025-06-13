package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.Objects;

import jp.co.niboshi.domains.models.shared.NiboshiModel;
import jp.co.niboshi.domains.models.shared.errors.ErrorMessages;

public class SelfEvaluationQuestion37 implements NiboshiModel {
  private String inner;

  public SelfEvaluationQuestion37(String selfEvaluationQuestion37) {
    if (Objects.isNull(selfEvaluationQuestion37)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), this.getModelName()));
    } else if (selfEvaluationQuestion37.isEmpty()) {
      this.throwDomainModelException(
          String.format(ErrorMessages.EMPTY.getMessage(), this.getModelName()));
    }

    this.inner = selfEvaluationQuestion37;
  }

  @Override
  public String toString() {
    return this.inner;
  }
}
