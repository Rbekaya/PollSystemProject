package PoolProjectPool.example.PollQuestionSystem.repository;

import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto2;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto3;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticsDto1;
import PoolProjectPool.example.PollQuestionSystem.model.UserAnswer;
import PoolProjectPool.example.PollQuestionSystem.repository.mapper.UserAnswerMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAnswerRepositoryImpl implements UserAnswerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final String USERANSWER_TABLE_NAME = "userAnswer";

    static final String POLL_TABLE_NAME = "poll";

    @Override
    public void createUserAnswer(UserAnswer userAnswer) {
        String sql = " INSERT INTO " + USERANSWER_TABLE_NAME + " (user_id, poll_id, poll_answer)" +
                " VALUES ( ?,?,?) ";
        try{
            jdbcTemplate.update(
                    sql,
                    userAnswer.getUserId(),
                    userAnswer.getPollId(),
                    userAnswer.getPollAnswer()
            );
        }catch (FeignException.FeignClientException e){
           throw new RuntimeException("Connection refused");
        }

    }

    @Override
    public List<UserAnswer> getAllUsersAnswer() {
        String sql = " SELECT * FROM " + USERANSWER_TABLE_NAME;

        return jdbcTemplate.query(sql, new UserAnswerMapper());
    }

    @Override
    public List<UserAnswer> getAllAnswersByUserId(Long id) {
        String sql =" SELECT * FROM " + USERANSWER_TABLE_NAME +
                    " WHERE user_id = ? ";

        return jdbcTemplate.query(sql, new UserAnswerMapper(), id);
    }

    @Override
    public void updateAnswerByUserIdAndPollId(UserAnswer userAnswer) {
        String sql =" UPDATE " + USERANSWER_TABLE_NAME +
                    " SET poll_answer = ? " +
                    " WHERE poll_id = ? AND user_id = ?";

        jdbcTemplate.update(
                sql,
                userAnswer.getPollAnswer(),
                userAnswer.getPollId(),
                userAnswer.getUserId()
        );
    }

    @Override
    public void deleteUserPollAnswersByUserId(Long id) {
        String sql =" DELETE FROM " + USERANSWER_TABLE_NAME +
                    " WHERE user_id = ?";

        jdbcTemplate.update(
                sql,
                id
        );
    }

    @Override
    public List<UserAnswerStatisticDto2> countTotalOptionAnsweredByPollId(Long id) {
        String sql = " SELECT ua.poll_answer AS question_option, " +
                    " COUNT(*) AS total_users " +
                    " FROM " + USERANSWER_TABLE_NAME + " ua " +
                    " WHERE ua.poll_id = ? " +
                    " GROUP BY ua.poll_answer";

        return jdbcTemplate.query(
                sql,
                ((rs, rowNum) -> new UserAnswerStatisticDto2(
                        rs.getString("question_option"),
                        rs.getLong("total_users"))),
                id
        );
    }

    @Override
    public List<UserAnswerStatisticDto2> countTotalAnsweredUserByPollId(Long id) {
        String sql =" SELECT p.question_title," +
                    " COUNT(ua.poll_answer) AS total_users" +
                    " FROM " + POLL_TABLE_NAME + " AS p" +
                    " LEFT JOIN " + USERANSWER_TABLE_NAME + " AS ua" +
                    " ON p.poll_id = ua.poll_id" +
                    " WHERE p.poll_id = ?" +
                    " GROUP BY p.poll_id";

        return jdbcTemplate.query(
                sql,
                ((rs, rowNum) -> new UserAnswerStatisticDto2(
                        rs.getString("question_title"),
                        rs.getLong("total_users"))),
                id
        );
    }

    @Override
    public List<UserAnswerStatisticDto3> userAnswersByUserId(Long id) {
        String sql =" SELECT p.poll_id, p.question_title, ua.poll_answer " +
                    " FROM " + POLL_TABLE_NAME + " AS p" +
                    " INNER JOIN " + USERANSWER_TABLE_NAME + " AS ua" +
                    " ON p.poll_id = ua.poll_id" +
                    " WHERE ua.user_id = ?";

        return jdbcTemplate.query(
                sql,
                ((rs, rowNum) ->

                        new UserAnswerStatisticDto3(
                                rs.getString("question_title"),
                                rs.getString("poll_answer")
                        )),
                id
                );

    }

    @Override
    public Long countTotalUserAnswerByUserId(Long id) {
        String sql =" SELECT COUNT(*) AS total_questions_answered" +
                    " FROM " + USERANSWER_TABLE_NAME + " AS ua" +
                    " WHERE ua.user_id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                Long.class
        );
    }

    @Override
    public List<UserAnswerStatisticsDto1> countUserAnswerForEachPollQuestionOption() {
        String sql =" SELECT pq.poll_id, pq.question_title, ua.poll_answer," +
                    " COUNT(*) AS total_users" +
                    " FROM " + POLL_TABLE_NAME + " AS pq" +
                    " LEFT JOIN " + USERANSWER_TABLE_NAME + " AS ua" +
                    " ON pq.poll_id = ua.poll_id" +
                    " GROUP BY pq.poll_id , pq.question_title, ua.poll_answer" +
                    " ORDER BY pq.poll_id ";

        return jdbcTemplate.query(sql, ((rs, rowNum) ->
                new UserAnswerStatisticsDto1(
                        rs.getLong("poll_id"),
                        rs.getString("question_title"),
                        rs.getString("poll_answer"),
                        rs.getLong("total_users")
                )));
    }

}



