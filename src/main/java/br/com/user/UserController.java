package br.com.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.user.exception.UserNotFoundException;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("{userId")
	public User getUserById(@PathVariable Long userId) throws UserNotFoundException {
		return userService.getUserById(userId);
	}

	@PostMapping
	public User newUser(@RequestBody @Valid User user) {
		return userService.newUser(user);
	}

	@PutMapping
	public void updateUser(@RequestBody @Valid User user) throws UserNotFoundException {
		userService.updateUser(user);
	}

	@DeleteMapping("{userId}")
	public void deleteUserById(@PathVariable Long userId) {
		userService.deleteUserById(userId);
	}

}
