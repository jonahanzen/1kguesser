package br.com.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByGameId(Long gameId);
	
	Optional<User> findByName(String name);

}
