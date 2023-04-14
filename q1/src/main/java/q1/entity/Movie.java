/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author willbarnes
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;
    private String movieName;
    private String movieYear;
    private String movieGenre;
    private Boolean isFav;

    public Movie() {
    }

    public Movie(Long movieId, String movieName, String movieYear, String movieGenre, Boolean isFav) {
        super();
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieGenre = movieGenre;
        this.isFav = isFav;
    }
    
    
    
    public String getMovieName() {
        return movieName;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
