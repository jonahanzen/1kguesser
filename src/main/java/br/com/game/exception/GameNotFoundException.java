package br.com.game.exception;

import br.com.exception.ApiException;

public class GameNotFoundException extends ApiException {

	
	private static final long serialVersionUID = 2507682141580008282L;

	public GameNotFoundException(Long gameId) {
		super("The Game with Id: " + gameId + " does not exist.");
	}
	
}
