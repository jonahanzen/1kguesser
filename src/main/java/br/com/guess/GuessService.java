package br.com.guess;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuessService {
	
	@Autowired
	private GuessRepository guessRepository;
	
	public void newGuessList(List<Guess> guesses) {
		guessRepository.saveAll(guesses);
	}

}
