package dev.khansergei.dishorderingrestapi.dao;

import dev.khansergei.dishorderingrestapi.dto.DishDto;
import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DishDao {
    private final JdbcTemplate jdbcTemplate;
    public void dropTable() {
        String sql = "drop table if exists dishes cascade";
        jdbcTemplate.execute(sql);
    }

    public void createTable() {
        String sql = "create table dishes ( " +
                "id bigserial not null, " +
                "name varchar primary key not null, " +
                "type varchar not null, " +
                "price int not null, " +
                "place varchar references places (name) );";
        jdbcTemplate.update(sql);
    }

    public void addData(List<DishDto> dishes) {
        String sql = "insert into dishes(name, type, price, place) values(?, ?, ?, ?)";
        for (DishDto d : dishes) {
            jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, d.getName());
                ps.setString(2, d.getType());
                ps.setInt(3, d.getPrice());
                ps.setString(4, d.getPlace());
                return ps;
            });
        }
    }
}
