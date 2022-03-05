package br.com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.exception.ApiException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GameOrUserNotFoundException extends ApiException {

	private static final long serialVersionUID = 7796878425889372488L;
	
	public GameOrUserNotFoundException(Long userId) {
		super("User with Id: " + userId + " Or Game could not be found or does not exist.");
	}

}
