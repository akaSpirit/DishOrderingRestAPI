package dev.khansergei.dishorderingrestapi.controller;

import dev.khansergei.dishorderingrestapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestParam String dish_name,
                                      @RequestParam String place_name,
                                      Authentication auth) {
        return new ResponseEntity<>(orderService.addOrder(dish_name, place_name, auth), HttpStatus.OK);
    }

    @GetMapping  //find all user's orders
    public ResponseEntity<?> findAllOrdersByEmail(Authentication auth) {
        return new ResponseEntity<>(orderService.findAllOrdersByEmail(auth), HttpStatus.OK);
    }

}
