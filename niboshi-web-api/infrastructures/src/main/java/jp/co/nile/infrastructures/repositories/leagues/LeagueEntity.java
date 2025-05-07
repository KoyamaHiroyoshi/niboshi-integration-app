package jp.co.nile.infrastructures.repositories.leagues;

import java.util.Date;
import java.util.UUID;
import jp.co.nile.domains.models.leagues.CreateLeagueParams;
import jp.co.nile.domains.models.leagues.League;
import jp.co.nile.domains.models.leagues.UpdateLeagueParams;
import jp.co.nile.infrastructures.repositories.NileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LeagueEntity implements NileEntity<League> {
  public LeagueEntity(CreateLeagueParams createLeagueParams) {
    this.id = UUID.randomUUID();
    this.name = createLeagueParams.getName().toString();
    this.startAt = createLeagueParams.getStartAt().toDate();
    createLeagueParams.getEndAt()
        .ifPresent(leagueEndAt -> {
          this.endAt = leagueEndAt.toDate();
        });
  }

  public LeagueEntity(UpdateLeagueParams updateLeagueParams) {
    this.id = updateLeagueParams.getId().getUuid();
    this.name = updateLeagueParams.getName().toString();
    this.startAt = updateLeagueParams.getStartAt().toDate();
    updateLeagueParams.getEndAt()
        .ifPresent(leagueEndAt -> {
          this.endAt = leagueEndAt.toDate();
        });
  }

  private UUID id;
  private String name;
  private Date startAt;
  private Date endAt;
}
