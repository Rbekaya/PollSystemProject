package PoolProjectPool.example.PollQuestionSystem.repository.mapper;

import PoolProjectPool.example.PollQuestionSystem.model.UserAnswer;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAnswerMapper implements RowMapper<UserAnswer> {

    @Override
    public UserAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserAnswer(
                rs.getLong("user_id"),
                rs.getLong("poll_id"),
                rs.getString("poll_answer")
        );
    }
}
