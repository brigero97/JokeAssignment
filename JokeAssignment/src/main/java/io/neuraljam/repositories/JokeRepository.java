package io.neuraljam.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import io.neuraljam.entities.Joke;

public interface JokeRepository extends JpaRepository<Joke, Integer> {

	Joke findById(int id);
	ArrayList<Joke> findAll();
	ArrayList<Joke> findByBodyLike(String body);
}
