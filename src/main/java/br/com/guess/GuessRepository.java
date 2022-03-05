package br.com.guess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuessRepository extends JpaRepository<Long, Guess> {

}
