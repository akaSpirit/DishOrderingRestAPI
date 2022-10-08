package dev.khansergei.dishorderingrestapi.dao;

import dev.khansergei.dishorderingrestapi.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlaceDao {
    private final JdbcTemplate jdbcTemplate;

    public void dropTable() {
        String sql = "drop table if exists places cascade";
        jdbcTemplate.execute(sql);
    }

    public void createTable() {
        String sql = "create table places ( " +
                "id bigserial not null, " +
                "name varchar not null, " +
                "description varchar not null," +
                "primary key (name) );";
        jdbcTemplate.update(sql);
    }

    public void addData(List<PlaceDto> places) {
        String sql = "insert into places(name, description) values(?, ?)";
        for (PlaceDto p : places) {
            jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, p.getName());
                ps.setString(2, p.getDescription());
                return ps;
            });
        }
    }
    public List<PlaceDto> findAllPlaces() {
        String sql = "select * from places";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PlaceDto.class));
    }
}
