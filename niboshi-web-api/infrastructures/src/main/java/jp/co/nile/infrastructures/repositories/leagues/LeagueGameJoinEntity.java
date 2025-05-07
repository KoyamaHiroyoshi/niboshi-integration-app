package jp.co.nile.infrastructures.repositories.leagues;

import java.util.Date;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LeagueGameJoinEntity {
  private UUID leagueId;
  private UUID gameId;
  private Date eventDate;
  private UUID ruleId;
  private String ruleName;
  private UUID umaId;
  private String umaName;
  private Integer secondPlaceRate;
  private Integer firstPlaceRate;
  private UUID playerId;
  private String playerName;
  private Integer score;
  private Integer result;
}
