package jp.co.nile.infrastructures.repositories.players;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import jp.co.nile.domains.models.exceptions.DomainModelException;
import jp.co.nile.domains.models.players.CreatePlayerParams;
import jp.co.nile.domains.models.players.Player;
import jp.co.nile.domains.models.players.PlayerId;
import jp.co.nile.domains.models.players.PlayersRepository;
import jp.co.nile.domains.models.players.UpdatePlayerParams;
import jp.co.nile.domains.models.shared.uuid.NileUuid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class PlayersRepositoryImpl implements PlayersRepository {
  private final PlayersMapper playersMapper;
  private final InfraPlayersConverter playersConverter;

  @Override
  public void createPlayers(List<CreatePlayerParams> createPlayersParams) {
    List<PlayerEntity> newPlayers = createPlayersParams.stream()
        .map(createPlayerParams -> new PlayerEntity(new PlayerId().getUuid(),
            createPlayerParams.getPlayerName().toString()))
        .collect(Collectors.toList());
    playersMapper.createPlayers(newPlayers);
  }

  @Override
  public List<Player> findAllPlayers() throws DomainModelException {
    return playersMapper.selectAllPlayers().stream().map(
        playersConverter::toPlayer)
        .collect(Collectors.toList());
  }

  @Override
  public Player findPlayerById(PlayerId playerId) throws DomainModelException {
    return playersConverter.toPlayer(playersMapper.selectPlayerById(playerId.getUuid()));
  }

  @Override
  public void updatePlayer(UpdatePlayerParams updatePlayerParams) {
    playersMapper.updatePlayer(updatePlayerParams.getId().getUuid(),
        updatePlayerParams.getName().toString());
  }

  @Override
  public void deletePlayers(List<PlayerId> deletePlayerIds) {
    playersMapper.deletePlayers(
        deletePlayerIds.stream().map(NileUuid::getUuid).collect(Collectors.toList()));
  }

  @Override
  public List<Player> findPlayersById(List<PlayerId> playerIds) throws DomainModelException {
    return playersMapper
        .selectPlayersById(playerIds
            .stream()
            .map(PlayerId::getUuid)
            .toList())
        .stream()
        .map(playersConverter::toPlayer)
        .toList();
  }
}
