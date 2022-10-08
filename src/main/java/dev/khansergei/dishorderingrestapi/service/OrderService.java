package dev.khansergei.dishorderingrestapi.service;

import dev.khansergei.dishorderingrestapi.dao.ClientDao;
import dev.khansergei.dishorderingrestapi.dao.DishDao;
import dev.khansergei.dishorderingrestapi.dao.OrderDao;
import dev.khansergei.dishorderingrestapi.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    private final DishDao dishDao;
    private final ClientDao clientDao;

    public Optional<?> addOrder(String dish_name, String place_name, Authentication auth) {
        var email = auth.getName();
        if(auth.getName().isEmpty())
            return Optional.of("You must be logged in to order");
        if (!dishDao.isDishExist(dish_name))
            return Optional.of("No such dish");
        if (!dishDao.isDishExistInPlace(dish_name, place_name))
            return Optional.of("No such dish in the selected place");
        return Optional.of(orderDao.addOrder(OrderDto.builder()
                .userEmail(auth.getName())
                .dishName(dish_name)
                .time(LocalDateTime.now())
                .build()));
    }

    public Optional<?> findAllOrdersByEmail(Authentication auth) {
        if(auth.getName().isEmpty())
            return Optional.of("You must be logged in to see orders");
        if (!clientDao.isClientExist(auth.getName()))
            return Optional.of("No such client");
        return Optional.of(orderDao.findAllOrdersByEmail(auth.getName()));
    }
}
