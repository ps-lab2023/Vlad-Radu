package com.projectps.cinema.controller;

import com.projectps.cinema.DTO.RatingDTO;
import com.projectps.cinema.entity.Rating;
import com.projectps.cinema.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingContoller {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public void addRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.saveRating(ratingDTO);
    }

    @PostMapping("/addRatings")
    public void addRatings(@RequestBody List<RatingDTO> ratingsDTO) {
        ratingService.saveRatings(ratingsDTO);
    }

    @GetMapping("/allRatings")
    public List<RatingDTO> findAllRatings() {
        return ratingService.getRatings();
    }

    @GetMapping("/byScore/{score}")
    public List<RatingDTO> findRatingsByScore(@PathVariable double score) {
        return ratingService.getRatingsByScore(score);
    }

    @PutMapping("/updateRating")
    public Rating updateRating(@RequestBody RatingDTO ratingDTO) {
        return ratingService.updateRating(ratingDTO);
    }

    @DeleteMapping("/deleteRating/{id}")
    public void deleteRating(@PathVariable int id) {
        ratingService.deleteRating(id);
    }


}
