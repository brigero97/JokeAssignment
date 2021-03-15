package io.neuraljam.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import io.neuraljam.entities.Joke;
import io.neuraljam.services.JokeService;

@Controller
public class JokeController {

	@Autowired
	private JokeService jokeService;

	@RequestMapping(value = { "/home/addJoke" }, method = RequestMethod.GET)
	public ModelAndView addJoke() {
		ModelAndView model = new ModelAndView();

		model.addObject("joke", new Joke());
		model.setViewName("addJoke");

		return model;
	}

	@RequestMapping(value = { "/home/addJoke" }, method = RequestMethod.POST)
	public ModelAndView addJoke(@ModelAttribute("joke") Joke joke) {
		ModelAndView model = new ModelAndView();

		joke.setDate_time(new Date());
		jokeService.saveJoke(joke);

		model.addObject("joke", new Joke());

		model.setViewName("addJoke");

		return model;
	}

	@RequestMapping(value = { "/home/viewJokes" }, method = RequestMethod.GET)
	public ModelAndView viewJokes(@RequestParam(defaultValue = "") String body) {
		ModelAndView model = new ModelAndView();

		ArrayList<Joke> jokes = jokeService.findByBody(body);

		model.addObject("jokes", jokes);
		model.setViewName("viewJokes");

		return model;
	}

	@GetMapping("/home/modifyJoke/{id}")
	public ModelAndView modifyJoke(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView();
		Joke joke = jokeService.findById(id);

		model.addObject("joke", joke);
		model.setViewName("modifyJoke");

		return model;
	}

	@PostMapping("/home/modifyJoke")
	public ModelAndView updateStock(@RequestParam("id") int id, @RequestParam("body") String body) {
		ModelAndView model = new ModelAndView();

		Joke joke = jokeService.findById(id);
		joke.setBody(body);
		joke.setDate_time(new Date());
		jokeService.saveJoke(joke);

//        String successMessage = "";
//        model.addObject("successMessage", successMessage);
		model.setViewName("home");

		return model;
	}

	@PostMapping("/home/deleteJoke/{id}")
	public ModelAndView deleteJoke(@PathVariable("id") int id, @RequestParam(defaultValue = "") String body) {
		ModelAndView model = new ModelAndView();
		Joke joke = jokeService.findById(id);

		jokeService.deleteJoke(id);

		ArrayList<Joke> jokes = jokeService.findByBody(body);

		model.addObject("jokes", jokes);

		model.setViewName("viewJokes");

		return model;
	}

	@GetMapping("/home/random")
	public ModelAndView randomJoke(@RequestParam(defaultValue = "") String body) {

		ModelAndView model = new ModelAndView();
		ArrayList<Joke> jokes = jokeService.findByBody(body);
		Random rand = new Random();
		int randomIndex = rand.nextInt(jokes.size());
		Joke joke = jokes.get(randomIndex);
		model.addObject(joke);
		model.setViewName("random");
		
		return model;
		
	}

}
