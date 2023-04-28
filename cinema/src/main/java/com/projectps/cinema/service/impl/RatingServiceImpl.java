package com.projectps.cinema.service.impl;

import com.projectps.cinema.DTO.RatingDTO;
import com.projectps.cinema.entity.Rating;
import com.projectps.cinema.mapper.RatingMapper;
import com.projectps.cinema.repository.RatingRepository;
import com.projectps.cinema.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    RatingMapper ratingMapper;

    @Override
    public Rating saveRating(RatingDTO ratingDTO) {
        return ratingRepository.save(ratingMapper.toRating(ratingDTO));
    }

    @Override
    public List<Rating> saveRatings(List<RatingDTO> ratingsDTO) {
        return ratingRepository.saveAll(ratingMapper.toRatingList(ratingsDTO));
    }

    @Override
    public List<RatingDTO> getRatings() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratingMapper.toRatingDTOList(ratings);
    }

    @Override
    public List<RatingDTO> getRatingsByScore(double score) {
        List<Rating> ratings = ratingRepository.findByScoreGreaterThanEqual(score);
        return ratingMapper.toRatingDTOList(ratings);
    }

    @Override
    public Rating updateRating(RatingDTO ratingDTO) {
        Rating existingRating = ratingRepository.findById(ratingDTO.getId()).orElse(null);
        existingRating.setTitle(ratingDTO.getTitle());
        existingRating.setScore(ratingDTO.getScore());
        existingRating.setDescription(ratingDTO.getDescription());

        return ratingRepository.save(existingRating);
    }

    @Override
    public void deleteRating(int id) {
        ratingRepository.deleteById(id);
    }
}
