package dev.khansergei.dishorderingrestapi.service;

import dev.khansergei.dishorderingrestapi.dao.PlaceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceDao placeDao;
}
