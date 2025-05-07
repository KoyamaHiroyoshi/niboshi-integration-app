package jp.co.nile.infrastructures.repositories.leagues;

import java.util.UUID;
import jp.co.nile.domains.models.games.Game;
import jp.co.nile.infrastructures.repositories.NileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameEntity implements NileEntity<Game> {
  private UUID id;
  private UUID ruleId;
  private UUID umaId;
}
