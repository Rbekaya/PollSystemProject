package com.PoolProject.UserSystem.repository.mapper;
import com.PoolProject.UserSystem.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getDouble("age"),
                rs.getString("address"),
                rs.getDate("joining_date").toLocalDate()
        );
    }
}
