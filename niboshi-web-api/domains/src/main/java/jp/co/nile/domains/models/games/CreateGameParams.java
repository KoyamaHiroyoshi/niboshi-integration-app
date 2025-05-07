package jp.co.nile.domains.models.games;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import jp.co.nile.domains.models.leagues.LeagueId;
import jp.co.nile.domains.models.shared.NileModel;
import jp.co.nile.domains.models.shared.errors.ErrorMessages;
import lombok.Getter;

@Getter
public class CreateGameParams implements NileModel {
  private final LeagueId leagueId;
  private final Date eventDate;
  private final RuleId ruleId;
  private final UmaId umaId;
  private final List<CreatePlayerResultParams> playerResults;

  public CreateGameParams(LeagueId leagueId, Date eventDate, RuleId ruleId, UmaId umaId,
      List<CreatePlayerResultParams> playerResults) {
    if (Objects.isNull(leagueId)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), "leagueId"));
    }
    if (Objects.isNull(eventDate)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), "evenDate"));
    }
    if (Objects.isNull(ruleId)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), "ruleId"));
    }
    if (Objects.isNull(umaId)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), "umaId"));
    }
    if (Objects.isNull(playerResults)) {
      this.throwDomainModelException(
          String.format(ErrorMessages.NULL.getMessage(), "playerResults"));
    }
    if (Objects.nonNull(playerResults) && playerResults.size() != 4) {
      this.throwDomainModelException(
          String.format(ErrorMessages.LIST_SIZE.getMessage(), "playerResults", 4, 4));
    }

    this.leagueId = leagueId;
    this.eventDate = eventDate;
    this.ruleId = ruleId;
    this.umaId = umaId;
    this.playerResults = playerResults;
  }
}
