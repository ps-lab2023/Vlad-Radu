package com.projectps.cinema.controller;

import com.projectps.cinema.DTO.ActorDTO;
import com.projectps.cinema.entity.Actor;
import com.projectps.cinema.entity.Gender;
import com.projectps.cinema.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/addActor")
    public Actor addActor(@RequestBody ActorDTO actorDTO) {
        return actorService.saveActor(actorDTO);
    }

    @PostMapping("/addActors")
    public List<Actor> addActors(@RequestBody List<ActorDTO> actorsDTO) {
        return actorService.saveActors(actorsDTO);
    }

    @GetMapping("/allActors")
    public List<ActorDTO> findAllActors() {
        return actorService.getActors();
    }

    @GetMapping("/byId/{id}")
    public ActorDTO findActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }

    @PutMapping("/updateActor")
    public Actor updateActor(@RequestBody ActorDTO actorDTO) {
        return actorService.updateActor(actorDTO);
    }

    @DeleteMapping("/deleteActor/{id}")
    public void deleteActor(@PathVariable int id) {
        actorService.deleteActor(id);
    }
}
