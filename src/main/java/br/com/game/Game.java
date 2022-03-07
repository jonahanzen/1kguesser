package br.com.game;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.guess.Guess;
import br.com.user.User;
import lombok.Data;

@Entity
@Data
public class Game {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "game")
	private List<Guess> guess;

	@JsonIgnore
	@CreationTimestamp
	private LocalDateTime createdDate;

	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime modifiedDate;
	
	//TODO implement a status to control the last modified date of the game
	// And to be able to query only finished games
	// 'in progress' , 'finished'

	

}
