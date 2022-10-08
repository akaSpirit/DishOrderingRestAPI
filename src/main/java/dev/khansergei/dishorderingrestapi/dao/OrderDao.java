package dev.khansergei.dishorderingrestapi.dao;

import dev.khansergei.dishorderingrestapi.dto.DishDto;
import dev.khansergei.dishorderingrestapi.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDao {
    private final JdbcTemplate jdbcTemplate;
    public void dropTable() {
        String sql = "drop table if exists orders cascade";
        jdbcTemplate.execute(sql);
    }

    public void createTable() {
        String sql = "create table orders ( " +
                "id bigserial primary key not null, " +
                "user_email varchar references clients (email), " +
                "dish_name varchar references dishes (name), " +
                "time timestamp without time zone not null );";
        jdbcTemplate.update(sql);
    }

    public void addData(List<OrderDto> orders) {
        String sql = "insert into orders(user_email, dish_name, time) values(?, ?, ?)";
        for (OrderDto o : orders) {
            jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, o.getUserEmail());
                ps.setString(2, o.getDishName());
                ps.setTimestamp(3, Timestamp.valueOf(o.getTime()));
                return ps;
            });
        }
    }
}
