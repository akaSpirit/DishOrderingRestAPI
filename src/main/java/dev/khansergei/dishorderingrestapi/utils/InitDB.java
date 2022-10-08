package dev.khansergei.dishorderingrestapi.utils;

import dev.khansergei.dishorderingrestapi.dao.ClientDao;
import dev.khansergei.dishorderingrestapi.dao.DishDao;
import dev.khansergei.dishorderingrestapi.dao.OrderDao;
import dev.khansergei.dishorderingrestapi.dao.PlaceDao;
import dev.khansergei.dishorderingrestapi.dto.ClientDto;
import dev.khansergei.dishorderingrestapi.dto.DishDto;
import dev.khansergei.dishorderingrestapi.dto.OrderDto;
import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDB {
    @Bean
    public String init(PlaceDao placeDao, DishDao dishDao, ClientDao clientDao, OrderDao orderDao) {
        clientDao.dropTable();
        clientDao.dropTableAuth();
        placeDao.dropTable();
        dishDao.dropTable();
        orderDao.dropTable();

        clientDao.createTable();
        clientDao.createTableAuth();
        placeDao.createTable();
        dishDao.createTable();
        orderDao.createTable();

        clientDao.addData(addClients());
        placeDao.addData(addPlaces());
        dishDao.addData(addDishes());
        orderDao.addData(addOrders());
        return "init...";
    }

    private List<ClientDto> addClients() {
        List<ClientDto> clients = new ArrayList<>();
        clients.add(new ClientDto("Homer Skoog", "homer@gmail.com", "qwe", true));
        clients.add(new ClientDto("Exie Flegle", "exie@gmail.com", "qwe", true));
        clients.add(new ClientDto("Zane Foland", "zane@gmail.com", "qwe", true));
        clients.add(new ClientDto("Gaston Pascal", "gaston@gmail.com", "qwe", true));
        clients.add(new ClientDto("Valrie Lajoie", "valrie@gmail.com", "qwe", true));
        return clients;
    }

    private List<PlaceDto> addPlaces() {
        List<PlaceDto> places = new ArrayList<>();
        places.add(new PlaceDto("Italian Pizzeria", "Wood oven baked pizzas and pastas"));
        places.add(new PlaceDto("That Bar", "Little bit of everything"));
        places.add(new PlaceDto("The Broken Glass", "Cocktails with a bits of extra glass"));
        places.add(new PlaceDto("The Salty Sailor", "For weathered folks!"));
        places.add(new PlaceDto("The Rocinante","Family business only!"));
        return places;
    }

    private List<DishDto> addDishes() {
        List<DishDto> dishes = new ArrayList<>();
        dishes.add(new DishDto("Margherita", "Pizza", 10, "Italian Pizzeria"));
        dishes.add(new DishDto("Marinara", "Pizza", 12, "Italian Pizzeria"));
        dishes.add(new DishDto("Quattro Stagioni", "Pizza", 15, "Italian Pizzeria"));
        dishes.add(new DishDto("Quattro Formaggi", "Pizza", 13, "Italian Pizzeria"));
        dishes.add(new DishDto("Gelato", "Dessert", 2, "That Bar"));
        dishes.add(new DishDto("Macaroon", "Dessert", 4, "That Bar"));
        dishes.add(new DishDto("Pumpkin pie", "Dessert", 8, "That Bar"));
        dishes.add(new DishDto("Sweet roll", "Dessert", 5, "That Bar"));
        dishes.add(new DishDto("Espresso", "Hot Beverage", 3, "The Salty Sailor"));
        dishes.add(new DishDto("Herbal tea", "Hot Beverage", 3, "The Salty Sailor"));
        dishes.add(new DishDto("Apple cider", "Hot Beverage", 6, "The Salty Sailor"));
        dishes.add(new DishDto("Masala Chai", "Hot Beverage", 4, "The Salty Sailor"));
        dishes.add(new DishDto("Ancient Mariner", "Cocktail", 7, "The Broken Glass"));
        dishes.add(new DishDto("Three Wise Men", "Cocktail", 8, "The Broken Glass"));
        dishes.add(new DishDto("Brass Monkey", "Cocktail", 8, "The Broken Glass"));
        dishes.add(new DishDto("Cooperstown Cocktail", "Cocktail", 6, "The Broken Glass"));
        dishes.add(new DishDto("Vat grown steak", "Belter food", 20, "The Rocinante"));
        dishes.add(new DishDto("Red kibble", "Belter food", 11, "The Rocinante"));
        dishes.add(new DishDto("White kibble", "Belter food", 10, "The Rocinante"));
        dishes.add(new DishDto("Yeast based booze", "Belter food", 14, "The Rocinante"));
        return dishes;
    }

    private List<OrderDto> addOrders() {
        List<OrderDto> orders = new ArrayList<>();
        orders.add(new OrderDto("homer@gmail.com", "Margherita", LocalDateTime.now()));
        orders.add(new OrderDto("homer@gmail.com", "Herbal tea", LocalDateTime.now()));
        orders.add(new OrderDto("homer@gmail.com", "Macaroon", LocalDateTime.now()));
        orders.add(new OrderDto("homer@gmail.com", "Quattro Formaggi", LocalDateTime.now()));
        orders.add(new OrderDto("homer@gmail.com", "Brass Monkey", LocalDateTime.now()));
        orders.add(new OrderDto("exie@gmail.com", "Marinara", LocalDateTime.now()));
        orders.add(new OrderDto("exie@gmail.com", "Gelato", LocalDateTime.now()));
        orders.add(new OrderDto("exie@gmail.com", "Yeast based booze", LocalDateTime.now()));
        orders.add(new OrderDto("zane@gmail.com", "Espresso", LocalDateTime.now()));
        orders.add(new OrderDto("zane@gmail.com", "Vat grown steak", LocalDateTime.now()));
        orders.add(new OrderDto("gaston@gmail.com", "Red kibble", LocalDateTime.now()));
        orders.add(new OrderDto("gaston@gmail.com", "Macaroon", LocalDateTime.now()));
        orders.add(new OrderDto("valrie@gmail.com", "Ancient Mariner", LocalDateTime.now()));
        orders.add(new OrderDto("valrie@gmail.com", "Three Wise Men", LocalDateTime.now()));
        return orders;
    }
}
