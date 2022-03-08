package br.com.ranking;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.user.User;
import br.com.user.UserService;
import br.com.game.Game;
import br.com.game.GameService;

@Service
public class RankingService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameService gameService;
	
	
	/**
	 * It will sort Games by the size of the Guess List and then
	 * It will sort by the Total duration of the game
	 * The service will retrieve all games and implement two comparators
	 * @return the list of games after comparing them
	 */
	public List<Game> getRanking() {
		
		
		List<Game> games = gameService.getAllGames();
		
		Comparator<Game> employeeByGuess = Comparator.comparingInt(x -> x.getGuess().size());
		Comparator<Game> employeeByTime = Comparator.comparing( x -> x.getTotalGameDuration());
		
		Collections.sort(games, employeeByGuess.thenComparing(employeeByTime.reversed()));
		
		return games;
	}

}
