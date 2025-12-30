package com.PoolProject.UserSystem.repository;

import com.PoolProject.UserSystem.model.User;
import com.PoolProject.UserSystem.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final String USER_TABLE_NAME = "users";

    @Override
    public User getUserByID(Long id) {
        String sql =" SELECT * FROM " + USER_TABLE_NAME +
                    " WHERE user_id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
        }catch (EmptyResultDataAccessException e){
            throw new RuntimeException("There is no user with the requested id.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE_NAME ;

        try {
            return jdbcTemplate.query(sql,new UserMapper());
        }catch (EmptyResultDataAccessException e){
            System.out.println("No users");
            return null;
        }
    }

    @Override
    public void createUser(User user) {
        String sql =" INSERT INTO "+ USER_TABLE_NAME + " (first_name, last_name, email, age, address, joining_date)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

         jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getJoiningDate()
         );
    }

    @Override
    public User updateUserById(User user) {
        String sql =" UPDATE " + USER_TABLE_NAME +
                    " SET first_name =? , last_name =? , email =? , age =? , address =? , joining_date =?" +
                    " WHERE user_id =?";
        try {
            jdbcTemplate.update(
                    sql,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getAge(),
                    user.getAddress(),
                    user.getJoiningDate(),
                    user.getUserId()
            );
            return user;

        } catch (Exception e) {
            throw new RuntimeException("There is no user with the given id");
        }

    }

    @Override
    public void deleteUserById(Long id) {
        String sql =" DELETE FROM " + USER_TABLE_NAME +
                    " WHERE user_id = ?";

        jdbcTemplate.update(
                sql,
                id
        );
    }
}
