package dev.khansergei.dishorderingrestapi.controller;

import dev.khansergei.dishorderingrestapi.dto.OrderDto;
import dev.khansergei.dishorderingrestapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

//    @PostMapping("/add")
//    public ResponseEntity<OrderDto> addOrder(@RequestParam String dish_name) {
//        return new ResponseEntity<>(orderService.addOrder(dish_name), HttpStatus.OK);
//    }

}
