package br.com.game;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.guess.Guess;
import br.com.user.User;
import lombok.Data;

@Entity
@Data
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "game")
	private List<Guess> guess = new ArrayList<>();

	@JsonIgnore
	@CreationTimestamp
	private LocalDateTime createdDate;

	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime modifiedDate;

	private Long totalGameDuration;
	
	
}
