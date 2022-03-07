package br.com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.exception.ApiException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends ApiException {

	
	private static final long serialVersionUID = -1157903925621804928L;

	public UserNotFoundException(Long userId) {
		super("The User with Id: " + userId + " does not exist.");
	}
	
	public UserNotFoundException(String name) {
		super("The User with Name: " + name + " does not exist.");
	}
	
	

}
