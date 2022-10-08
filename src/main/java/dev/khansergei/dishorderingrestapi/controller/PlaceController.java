package dev.khansergei.dishorderingrestapi.controller;

import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import dev.khansergei.dishorderingrestapi.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
}
