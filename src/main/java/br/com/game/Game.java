package br.com.game;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.guess.Guess;
import lombok.Data;

@Entity
@Data
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "game")
	private Set<Guess> guess;

	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIME)
	private LocalDate modifiedDate;

	@Transient
	private Long gameDuration;

	private Calendar teste;

	public long getGameDuration() {
		return Duration.between(modifiedDate, createdDate).getSeconds();
	}

}
