package br.com.game;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	Optional<Game> findByUserId(Long userId);
	
	@Modifying
	@Query(value = "Update game g set g.totalGameDuration = ? where g.Id = ?", nativeQuery = true)
	Long updateGameDurationByGameId(@Param("totalGameDuration") Long totalGameDuration, @Param("Id") Long id);

	
}
