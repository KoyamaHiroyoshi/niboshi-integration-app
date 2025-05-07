package jp.co.nile.infrastructures.repositories.leagues;

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
public class LeagueJoinGameEntity {
  private UUID leagueId;
  private UUID gameId;
  private UUID playerId;
  private String playerName;
}
