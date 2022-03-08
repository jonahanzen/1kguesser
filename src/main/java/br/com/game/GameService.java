package br.com.game;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
	 * The game must have a User
	 * 
	 * @param userName of the Game
	 * @return the created Game
	 * @throws UserNotFoundException 
	 */
	public Game newGame(String userName) throws UserNotFoundException {
		User user = userService.getUserByName(userName);
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
	//TODO this method could use a modelMapper and a better JSON polishing
	public void updateGame(Long gameId, List<Integer> guesses) throws GameNotFoundException {
		if (!gameRepository.existsById(gameId)) {
			throw new GameNotFoundException(gameId);
		}
		List<Guess> guessList = new ArrayList<>();
		Game game = gameRepository.findById(gameId).get();
		for (int guessNumber : guesses) {
			Guess guess = new Guess();
			guess.setGame(game);
			guess.setGuess(guessNumber);
			guessService.newGuess(guess);
			guessList.add(guess);
		}
		game.setGuess(guessList);
		Long gameDuration = ChronoUnit.SECONDS.between(game.getCreatedDate(), LocalDateTime.now());
		game.setTotalGameDuration(gameDuration);
//		gameRepository.updateGameDurationByGameId(gameId, gameDuration);
		gameRepository.save(game);
	}

	public void deleteGameById(Long id) {
		gameRepository.deleteById(id);
	}
}
