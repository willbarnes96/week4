/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package q1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import q1.entity.Movie;

/**
 *
 * @author willbarnes
 */
@Service
@RestController
public interface MovieService {
    Movie saveMovie(Movie movie);
    List<Movie> fetchMovie();
    void updateMovie(Long movieId, Movie movie);
    Optional<Movie> getById(Long movieId);
    void delMovie(Long movieId);
    List<Movie> getByGenre(String genre);
}
