package br.com.game;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.game.exception.GameNotFoundException;
import br.com.guess.Guess;
import br.com.guess.GuessService;
import br.com.user.User;
import br.com.user.UserRepository;
import br.com.user.UserService;
import br.com.user.exception.GameOrUserNotFoundException;
import br.com.user.exception.UserNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GuessService guessService;

	/**
	 * Method to create a new Game
	 * It will insert a new Game in the database
	 * The game must have a User Id
	 * 
	 * @param userId of the Game
	 * @return the created Game
	 * @throws UserNotFoundException 
	 */
	public Game newGame(Long userId) throws UserNotFoundException {
		User user = userService.getUserById(userId);
		Game game = new Game();
		game.setUser(user);
		return gameRepository.save(game);
	}

	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	public Game getGameById(Long id) throws GameNotFoundException {
		return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
	}

	public Game getGameByUserId(Long userId) throws GameOrUserNotFoundException {
		return gameRepository.findByUserId(userId).orElseThrow(() -> new GameOrUserNotFoundException(userId));
	}

	//TODO this method is to be used to mark the game as finished
	public void updateGame(Long gameId, List<Guess> guess) throws GameNotFoundException {
		if (!gameRepository.existsById(gameId)) {
			throw new GameNotFoundException(gameId);
		}
		Game game = gameRepository.findById(gameId).get();
		guess.forEach( guessGameId -> guessGameId.setGame(game));
		guessService.newGuessList(guess);
		
		game.setGuess(guess);
		gameRepository.save(game);
	}

	public void deleteGameById(Long id) {
		gameRepository.deleteById(id);
	}
}
