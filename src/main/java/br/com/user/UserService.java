package br.com.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.user.exception.GameOrUserNotFoundException;
import br.com.user.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User newUser(@Valid User user) {
		return userRepository.save(user);
	}
	
	public User newUserByName(String userName) {
		User user = new User();
		user.setName(userName);
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	public User getUserByGameId(Long gameId) throws GameOrUserNotFoundException {
		return userRepository.findByGameId(gameId).orElseThrow(() -> new GameOrUserNotFoundException(gameId));
	}
	
	public User getUserByName(String name) throws UserNotFoundException {
		return userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException(name));
	}

	public void updateUser(User user) throws UserNotFoundException {
		if (!userRepository.existsById(user.getId())) {
			throw new UserNotFoundException(user.getId());
		}

		userRepository.save(user);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

}
