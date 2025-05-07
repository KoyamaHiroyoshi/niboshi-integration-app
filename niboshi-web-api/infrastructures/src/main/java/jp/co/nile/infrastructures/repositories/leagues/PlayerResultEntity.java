package jp.co.nile.infrastructures.repositories.leagues;

import java.util.UUID;
import jp.co.nile.domains.models.games.PlayerResult;
import jp.co.nile.infrastructures.repositories.NileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerResultEntity implements NileEntity<PlayerResult> {
  private UUID gameId;
  private UUID playerId;
  private Integer score;
  private Integer result;
}
