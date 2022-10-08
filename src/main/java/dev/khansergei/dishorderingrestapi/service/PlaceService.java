package dev.khansergei.dishorderingrestapi.service;

import dev.khansergei.dishorderingrestapi.dao.DishDao;
import dev.khansergei.dishorderingrestapi.dao.PlaceDao;
import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceDao placeDao;
    private final DishDao dishDao;

    public List<PlaceDto> findAllPlaces() {
        return placeDao.findAllPlaces();
    }

    public Optional<?> findAllDishesByPlace(String name) {
        if (!placeDao.isPlaceExist(name))
            return Optional.of("No such place");
        return Optional.of(dishDao.findAllDishesByPlace(name));
    }
}
