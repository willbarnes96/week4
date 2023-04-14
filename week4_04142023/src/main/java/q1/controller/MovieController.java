/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import q1.entity.Movie;
import q1.service.MovieService;
/**
 *
 * @author willbarnes
 */
@RestController
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    @PostMapping("/movies/")
    public Movie saveMovie(@Validated @RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }
  
    @DeleteMapping("/movies/{Id}")
    public void delMovie(@PathVariable(value = "Id") Long movieId) {
        movieService.delMovie(movieId);
    }
    
    @RequestMapping(value="/movies/", method=RequestMethod.GET)
    public List<Movie> fetchMovieList() {
        return movieService.fetchMovie();
    }

    
    @RequestMapping(value="/id/{Id}", method=RequestMethod.GET)
    public Optional<Movie> getById(@PathVariable(value="Id") Long movieId) {
        return movieService.getById(movieId);
    }
    
    @RequestMapping(value="/genre/{Genre}", method=RequestMethod.GET)
    public List<Movie> getByGenre(@PathVariable(value="Genre") String genre) {
        return movieService.getByGenre(genre);
    }
    
    @PatchMapping("/movies/{Id}")
    public void updateMovie(@PathVariable(value = "Id") Long movieId, @Validated @RequestBody Movie movie) {
        movieService.updateMovie(movieId, movie);
        
    }
    
    
    
    
}


