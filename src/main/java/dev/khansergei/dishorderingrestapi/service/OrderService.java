package dev.khansergei.dishorderingrestapi.service;

import dev.khansergei.dishorderingrestapi.dao.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
}
