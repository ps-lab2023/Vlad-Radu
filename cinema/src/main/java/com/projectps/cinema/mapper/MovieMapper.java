package com.projectps.cinema.mapper;

import com.projectps.cinema.DTO.MovieDTO;
import com.projectps.cinema.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    public static MovieDTO toMovieDTO(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getGenres(),
                movie.getYear(),
                movie.getRatings(),
                movie.getScore(),
                movie.getActors()
        );
    }

    public static Movie toMovie(MovieDTO movieDTO) {
        return new Movie(
                movieDTO.getId(),
                movieDTO.getTitle(),
                movieDTO.getGenres(),
                movieDTO.getYear(),
                movieDTO.getRatings(),
                movieDTO.getScore(),
                movieDTO.getActors()
        );
    }

    public static List<MovieDTO> toMovieDTOList(List<Movie> movies) {
        return movies.stream()
                     .map(MovieMapper::toMovieDTO)
                     .toList();
    }

    public static List<Movie> toMovieList(List<MovieDTO> moviesDTO) {
        return moviesDTO.stream()
                        .map(MovieMapper::toMovie)
                        .toList();
    }
}
