package dev.khansergei.dishorderingrestapi.controller;

import dev.khansergei.dishorderingrestapi.dto.DishDto;
import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import dev.khansergei.dishorderingrestapi.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    public List<PlaceDto> findAllPlaces() {
        return placeService.findAllPlaces();
    }

    @GetMapping("/{place_name}")  //get all place's dishes
    public ResponseEntity<?> findAllDishesByPlace(@PathVariable String place_name) {
        return new ResponseEntity<>(placeService.findAllDishesByPlace(place_name), HttpStatus.OK);
    }
}
