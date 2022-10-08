package dev.khansergei.dishorderingrestapi.dao;

import dev.khansergei.dishorderingrestapi.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientDao {
    private final JdbcTemplate jdbcTemplate;

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    public void dropTable() {
        String sql = "drop table if exists clients cascade";
        jdbcTemplate.execute(sql);
    }

    public void dropTableAuth() {
        String sql = "drop table if exists authorities cascade";
        jdbcTemplate.execute(sql);
    }

    public void createTable() {
        String sql = "create table clients ( " +
                "id bigserial not null, " +
                "name varchar not null, " +
                "email varchar not null, " +
                "password varchar not null, " +
                "enabled boolean not null, " +
                "primary key (email) );";
        jdbcTemplate.update(sql);
    }

    public void createTableAuth() {
        String sql = "create table authorities ( " +
                "id bigserial primary key not null, " +
                "username varchar not null references clients(email), " +
                "authority text not null );";
        jdbcTemplate.update(sql);
    }

    public void addData(List<ClientDto> clients) {
        String sql = "insert into clients(name, email, password, enabled) values(?, ?, ?, ?)";
        String sqlAuth = "insert into authorities(username, authority) values(?, ?)";
        for (int i = 0; i < clients.size(); i++) {
            int finalI = i;
            jdbcTemplate.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, clients.get(finalI).getName());
                ps.setString(2, clients.get(finalI).getEmail());
                ps.setString(3, encoder.encode(clients.get(finalI).getPassword()));
                ps.setBoolean(4, clients.get(finalI).isEnabled());
                return ps;
            });
            jdbcTemplate.update(sqlAuth, clients.get(i).getEmail(), "USER");
        }
    }

    public boolean isClientExist(String name) {
        String sql = "select count(*) from clients where email = ?";
        var count = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return count == 1;
    }
}
