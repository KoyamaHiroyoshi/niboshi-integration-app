package jp.co.nile.applications.usecases.players.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.nile.applications.usecases.players.PlayerUsecases;
import jp.co.nile.domains.models.players.CreatePlayerParams;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayersRepository;
import jp.co.nile.domains.models.players.UpdatePlayerParams;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class PlayersUseCasesImpl implements PlayerUsecases {
  private final PlayersRepository playersRepository;

  @Override
  public void createPlayers(List<CreatePlayerParams> createPlayersParams) {
    playersRepository.createPlayers(createPlayersParams);
  }

  @Override
  public List<Player> findAllPlayers() {
    return playersRepository.findAllPlayers();
  }

  @Override
  public Player findPlayer(PlayerId playerId) {
    return playersRepository.findPlayerById(playerId);
  }

  @Override
  public void updatePlayer(UpdatePlayerParams updatePlayerParams) {
    playersRepository.updatePlayer(updatePlayerParams);
  }

  @Override
  public void deletePlayers(List<PlayerId> deletePlayerIds) {
    playersRepository.deletePlayers(deletePlayerIds);
  }
}
