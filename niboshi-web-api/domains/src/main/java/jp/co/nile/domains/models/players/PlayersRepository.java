package jp.co.nile.domains.models.players;

import java.util.List;
import jp.co.nile.domains.models.exceptions.DomainModelException;

public interface PlayersRepository {
  public void createPlayers(List<CreatePlayerParams> createPlayersParams);

  public List<Player> findAllPlayers() throws DomainModelException;

  public Player findPlayerById(PlayerId playerId) throws DomainModelException;

  public List<Player> findPlayersById(List<PlayerId> playerIds) throws DomainModelException;

  public void updatePlayer(UpdatePlayerParams updatePlayerParams);

  public void deletePlayers(List<PlayerId> deletePlayerIds);
}
