package jp.co.niboshi.applications.usecases.selfEvaluations.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.niboshi.applications.usecases.selfEvaluations.SelfEvaluationsUsecases;
import jp.co.niboshi.domains.models.selfEvaluation.CreateSelfEvaluationParams;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluation;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationUserId;
import jp.co.niboshi.domains.models.selfEvaluation.SelfEvaluationRepository;
import jp.co.niboshi.domains.models.selfEvaluation.UpdateSelfEvaluationParams;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class selfEvaluationsUseCasesImpl implements SelfEvaluationsUsecases {
  private final SelfEvaluationRepository selfEvaluationsRepository;

  @Override
  public void createSelfEvaluations(List<CreateSelfEvaluationParams> createSelfEvaluationsParams) {
    selfEvaluationsRepository.createSelfEvaluations(createSelfEvaluationsParams);
  }

  @Override
  public List<SelfEvaluation> findAllSelfEvaluations() {
    return selfEvaluationsRepository.findAllSelfEvaluations();
  }

  @Override
  public SelfEvaluation findSelfEvaluation(SelfEvaluationUserId selfEvaluationUserId) {
    return selfEvaluationsRepository.findSelfEvaluationById(selfEvaluationUserId);
  }

  @Override
  public void updateSelfEvaluation(UpdateSelfEvaluationParams updateSelfEvaluationParams) {
    selfEvaluationsRepository.updateSelfEvaluation(updateSelfEvaluationParams);
  }

  @Override
  public void deleteSelfEvaluations(List<SelfEvaluationUserId> deleteSelfEvaluationUserIds) {
    selfEvaluationsRepository.deleteSelfEvaluations(deleteSelfEvaluationUserIds);
  }

}
