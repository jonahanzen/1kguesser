package br.com.ranking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.game.Game;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {

	@Autowired
	private RankingService rankingService;
	
	@GetMapping
	public List<Game> gamesRanking() {
		return rankingService.getRanking();
	}
}
