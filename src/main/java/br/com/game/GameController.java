package br.com.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.game.exception.GameNotFoundException;
import br.com.guess.Guess;
import br.com.user.exception.UserNotFoundException;

@RestController
@RequestMapping(path = "api/game")
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping
	public List<Game> getAllGames() {
		return gameService.getAllGames();
	}

	@GetMapping("{gameId}")
	public Game getGameById(@PathVariable Long gameId) throws GameNotFoundException {
		return gameService.getGameById(gameId);
	}

	// TODO use this mapping to update game status (?)
	// TODO Post a list of guesses after the game is finished
	@PostMapping("{userName}")
	public Game newGame(@PathVariable String userName) throws UserNotFoundException {
		return gameService.newGame(userName);
	}

	@PostMapping("{gameId}/guess")
	public void updateGame(@PathVariable Long gameId, @RequestBody List<Integer> guess) throws GameNotFoundException {
		gameService.updateGame(gameId, guess);
		
	}

	@DeleteMapping("{gameId}")
	public void deleteGameById(@PathVariable Long gameId) {
		gameService.deleteGameById(gameId);
	}
}
