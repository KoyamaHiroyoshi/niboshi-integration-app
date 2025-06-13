package jp.co.niboshi.domains.models.selfEvaluation;

import java.util.List;

import jp.co.niboshi.domains.models.exceptions.DomainModelException;

public interface SelfEvaluationRepository {
  public void createSelfEvaluations(List<CreateSelfEvaluationParams> createSelfEvaluationParams);

  public List<SelfEvaluation> findAllSelfEvaluations() throws DomainModelException;

  public SelfEvaluation findSelfEvaluationById(SelfEvaluationUserId selfEvaluationUserId)
      throws DomainModelException;

  public List<SelfEvaluation> findSelfEvaluationsById(
      List<SelfEvaluationUserId> selfEvaluationUserIds)
      throws DomainModelException;

  public void updateSelfEvaluation(UpdateSelfEvaluationParams updateSelfEvaluationParams);

  public void deleteSelfEvaluations(List<SelfEvaluationUserId> deleteSelfEvaluationUserId);
}
