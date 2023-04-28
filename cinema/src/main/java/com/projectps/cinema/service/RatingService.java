package com.projectps.cinema.service;

import com.projectps.cinema.DTO.RatingDTO;
import com.projectps.cinema.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    Rating saveRating(RatingDTO ratingDTO);

    List<Rating> saveRatings(List<RatingDTO> ratingsDTO);

    List<RatingDTO> getRatings();

    List<RatingDTO> getRatingsByScore(double score);

    Rating updateRating(RatingDTO ratingDTO);

    void deleteRating(int id);

}