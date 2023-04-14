/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import q1.entity.Movie;
import q1.repository.MovieRepository;

/**
 *
 * @author willbarnes
 */
@Service
public class MovieServiceImpl implements MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Override
    public List<Movie> fetchMovie() {
        return (List<Movie>)movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getById(Long movieId) {
        return movieRepository.findById(movieId);
    }
    
    @Override
    public List<Movie> getByGenre(String genre) {
        List<Movie> l = fetchMovie();
        for (int i = 0; i < l.size(); i++){
            if (!l.get(i).getMovieGenre().equals(genre)) {
                l.remove(i);
            }
        }
        return l;
    }
    

    
    @Override
    public void delMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
    
    
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);    
    }
    
    
    @Override
    public void updateMovie(Long movieId, Movie movie) {
        Movie temp = new Movie();
        temp = movieRepository.findById(movieId).get();
        temp.setMovieName(movie.getMovieName());
        //temp.setMovieYear(movie.getMovieYear());
        //temp.setMovieGenre(movie.getMovieGenre());
        //temp.setIsFav(movie.getIsFav());
        movieRepository.save(temp);
    }
    

    

    
}
