package dev.khansergei.dishorderingrestapi.dao;

import dev.khansergei.dishorderingrestapi.dto.DishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public List<DishDto> findAllDishesByPlace(String name) {
        String sql = "select * from dishes where place = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DishDto.class), name);
    }

    public boolean isDishExist(String name) {
        String sql = "select count(*) from dishes where name = ?";
        var count = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return count == 1;
    }

    public boolean isDishExistInPlace(String dish_name, String place_name) {
        String sql = "select count(*) from dishes where name = ? and place = ?";
        var count = jdbcTemplate.queryForObject(sql, Integer.class, dish_name, place_name);
        return count == 1;
    }
}
