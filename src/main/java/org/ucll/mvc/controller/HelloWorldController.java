package org.ucll.mvc.controller;

import db.VideoBeheerRelationalDatabase;
import domain.Movie;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

/**
 * Created by filip on 15/03/2016.
 */

@Controller
@RequestMapping(value = "/moviecontroller")
public class HelloWorldController {

//    private MovieDao movieDao = new MovieDao();


    private VideoBeheerRelationalDatabase movieDao = new VideoBeheerRelationalDatabase();
    /**
     *
     * Als je achter de "/" ==> hello.htm schrijft, wordt onderstaande /hello functie behandeld.
     *
     */

    @RequestMapping("/hello")
    public String welcome(ModelMap model){
        model.addAttribute("name","Hello World!");
        model.addAttribute("greetings", "Welcome to this course");
        return "hello";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Locale locale, Model model) {
        //logger.info("Welcome home! The client locale is {}.", locale);
        return "user";
    }
/*
    @RequestMapping(value = "/showmovies")
    public String showmovies(Model model){

        List<Movie> movies = movieDao.getAllMovies();

        /* standaard values not database values */

        /*
        Movie movie = new Movie();
        movie.setId(3);
        movie.setDirector("Steven Spielberg");
        movie.setEvaluation(MovieEvaluation.FOURSTARS);
        movie.setGenre(MovieGenre.COMEDY);
        movie.setJaar(2002);
        movie.setRating(MovieRating.PGTHIRTEEN);
        movie.setSeen(true);
        movie.setTitle("King Kong");
*/

    /*
        model.addAttribute("name","Hello Movies!");
        model.addAttribute("greetings", "Show all movies please!");
        model.addAttribute("movies",movies);

        return "crud/movies/showmovies";
    }
*/
    /**
     * Om te navigeren naar subpagina's, typ de namen van de subfolders voor de pagina.
     * vb. de methode showmovies,
     * is de url
     * http://localhost:8080/org.ucll.internetprogrammerenproject.springmvc/showmovies.htm
     *
     */

    /*
    @RequestMapping(value = "/addMovie")
    public String addMovie(Model model)
    {
        //Movie movie = new Movie();

        //model.addAttribute("movie",movie);

        return "/crud/movies/create";
    }
*/
    /*

@RequestMapping(value = "/addMovie",method = RequestMethod.POST)
    public String addMovie(@ModelAttribute("movie") Movie movie){

    movieDao.addMovie(movie);

    return "redirect:/showmovies";


}
    */

    /*
@RequestMapping(value = "/addMovie",method = RequestMethod.GET)
public ModelAndView addMovie(){

    ModelAndView modelAndView = new ModelAndView("crud/movies/create");
    modelAndView.addObject("movie",new Movie());
modelAndView.addObject("enumValuesGenre",MovieGenre.values());
    modelAndView.addObject("enumValuesRating",MovieRating.values());
    modelAndView.addObject("enumValuesEvaluation",MovieEvaluation.values());
    return modelAndView;



//werkt wel   return new ModelAndView("/crud/movies/create","movie",new Movie());

    /*
    /crud/movies/create ==> view name
movie ==> commandName for form tag
     */

/*
}

    */

    @RequestMapping(value = "/processMovie",method = RequestMethod.POST)
    public String addMovie(@ModelAttribute("movie") Movie movie, BindingResult result){

        System.out.println("title : " + movie.getTitle());

        return  "redirect:/showmovies.htm";


        //movieDao.addMovie(movie);
        //return "redirect:/showmovies.htm";

    }

    /*
    dit maakt het formulier
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String submit(@ModelAttribute("movie") Movie movie, BindingResult result, ModelMap modelMap, Model model){

        movieDao.addMovie(movie);

        modelMap.addAttribute("movie",movie);
        return "crud/movies/detailmovie";

    }

    //show update form for editing movie
    @RequestMapping(value = "/${id}/update", method = RequestMethod.GET)
    public String editMovie(@PathVariable("id") int id, Model model){

        Movie movie = movieDao.getMovieById(id);

        model.addAttribute("movie",movie);



        return "crud/movies/detailmovie";

    }

    //show update form for editing movie
    @RequestMapping(value = "/${id}", method = RequestMethod.GET)
    public String editMovie2(@PathVariable("id") int id, Model model){

        Movie movie = movieDao.getMovieById(id);

        model.addAttribute("movie",movie);



        return "crud/movies/detailmovie";

    }

    /*
    <spring:url value="/moviecontroller/${movie.id}/update.htm" var="movie1urlupdate"/>
    <spring:url value="/moviecontroller/${movie.id}/update" var="movie2urlupdate"/>
    <spring:url value="/moviecontroller/${movie.id}/delete.htm" var="movie1urldelete" />
    <spring:url value="/moviecontroller/${movie.id}/delete" var="movie2urldelete" />
*/

//delete movie
    @RequestMapping(value = "/${id}/delete", method = RequestMethod.POST)
    public String deleteMovie(@PathVariable("id") int id, final RedirectAttributes redirectAttributes){

        /*movieDao.deleteMovieById(id);*/

        redirectAttributes.addFlashAttribute("css","success");
        redirectAttributes.addFlashAttribute("msg","movie is deleted!");

        return "redirect:/showmovies.htm";
    }
/*
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editMovie(@ModelAttribute("movie") Movie movie, BindingResult result, ModelMap modelMap,Model model){

        movieDao.updateMovie(movie);

        return "";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editMovie3(@ModelAttribute("movie") Movie movie, BindingResult result, ModelMap modelMap,Model model){

        movieDao.updateMovie(movie);

        return "";
    }*/



}
