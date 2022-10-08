package dev.khansergei.dishorderingrestapi.service;

import dev.khansergei.dishorderingrestapi.dao.PlaceDao;
import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceDao placeDao;

    public List<PlaceDto> findAllPlaces() {
        return placeDao.findAllPlaces();
    }
}
