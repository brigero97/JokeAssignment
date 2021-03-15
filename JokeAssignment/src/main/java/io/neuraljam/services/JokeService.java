package io.neuraljam.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.neuraljam.entities.Joke;
import io.neuraljam.repositories.JokeRepository;

@Service("jokeService")
public class JokeService {

@Autowired
   private JokeRepository jokeRepository;

   public Joke findById(int id) {
       return jokeRepository.findById(id);
   }
   
   public void saveJoke(Joke joke) {
       jokeRepository.save(joke);
   }
   
   public ArrayList<Joke> findByBody(String body) {
	   return  jokeRepository.findByBodyLike("%"+body+"%");
	   
   }
   
   public void deleteJoke(int id) {
	   jokeRepository.deleteById(id);
   }

}
