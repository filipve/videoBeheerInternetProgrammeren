package org.ucll.mvc.controller;

import db.VideoBeheerRelationalDatabase;
import domain.Movie;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by filip on 8/04/2016.
 */

@Controller
@RequestMapping("/movies/*")
public class MovieController {

    private VideoBeheerRelationalDatabase movieDao = new VideoBeheerRelationalDatabase();

    @RequestMapping(value = "/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/showmovies")
    public String showmovies(Model model) {

        List<Movie> movies = movieDao.getAllMovies();
        int jaarfilmgezien = 0;
        Map<Integer,Integer> aantalfilmsgezienperjaar = new TreeMap<Integer, Integer>();


        for(Movie m : movies){
            if(m.isSeen() == true){
                Integer temp = aantalfilmsgezienperjaar.get(m.getJaar());
                if(temp == null) temp = 1;
                aantalfilmsgezienperjaar.put(m.getJaar(),temp++);
            }
        }

        model.addAttribute("name", "Hello Movies!");
        model.addAttribute("greetings", "Show all movies please!");
        model.addAttribute("movies", movies);
        model.addAttribute("aantalfilmsgezienperjaar",aantalfilmsgezienperjaar);



        return "crud/movies/showmovies";
    }

    //Go to the addMovie form
    @RequestMapping(value = "/addMovie",method = RequestMethod.GET)
    public ModelAndView addMovie(){

        ModelAndView modelAndView = new ModelAndView("crud/movies/create");
        modelAndView.addObject("movie",new Movie());
        modelAndView.addObject("enumValuesGenre", MovieGenre.values());
        modelAndView.addObject("enumValuesRating", MovieRating.values());
        modelAndView.addObject("enumValuesEvaluation", MovieEvaluation.values());
        return modelAndView;
    }

    //add the new made movie to the database
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String saveMovieToDatabase(@ModelAttribute("movie") Movie movie, BindingResult result, ModelMap modelMap, Model model){
        movieDao.addMovie(movie);
        modelMap.addAttribute("movie",movie);
        return "crud/movies/detailmovie";
    }

    //show updateForm of chosen Movie By Id
    @RequestMapping(path = "/update/{id}",value ="/update/{id}" ,method = RequestMethod.GET)
    public String updateMovie(@PathVariable("id") int id, Model model){
        Movie movie = movieDao.getMovieById(id);
        model.addAttribute("movie",movie);
        return "crud/movies/update";
    }

    //update the movie to the database
    @RequestMapping(value = "/updatemovie", method = RequestMethod.POST)
    public String updateMovieToDatabase(@ModelAttribute("movie") Movie movie,BindingResult result,ModelMap modelMap,Model model){
        movieDao.updateMovie(movie,movie.getId());
        return "redirect:/movies/showmovies.htm";
    }

    @RequestMapping(path="/delete/{id}",value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") int id, Model model){
        movieDao.deleteMovieById(id);
        return "redirect:/movies/showmovies.htm";
    }

}
