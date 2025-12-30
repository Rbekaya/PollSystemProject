package PoolProjectPool.example.PollQuestionSystem.repository;

import PoolProjectPool.example.PollQuestionSystem.model.Poll;
import PoolProjectPool.example.PollQuestionSystem.repository.mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollRepositoryImpl implements PollRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final String POLL_TABLE_NAME = "poll";

    @Override
    public void CreatePollQuestion(Poll poll) {
        String sql =" INSERT INTO "+ POLL_TABLE_NAME+ " (question_title,first_answer,second_answer,third_answer,fourth_answer)" +
                    " VALUES( ?,?,?,?,?)";

         jdbcTemplate.update(
                 sql,
                 poll.getQuestionTitle(),
                 poll.getFirstAnswer(),
                 poll.getSecondAnswer(),
                 poll.getThirdAnswer(),
                 poll.getFourthAnswer()
         );
    }

    @Override
    public Poll getPollQuestionById(Long id) {
        String sql =" SELECT * FROM " + POLL_TABLE_NAME +
                    " WHERE poll_id = ?";

        try {
        return jdbcTemplate.queryForObject(sql,new PollMapper(),id);
        } catch (RuntimeException e){
            throw new RuntimeException("There is no poll question with the requested id.");
        }
    }

    @Override
    public List<Poll> getAllPollQuestions() {
        String sql =" SELECT * FROM " + POLL_TABLE_NAME;

        return jdbcTemplate.query(
                sql,
                new PollMapper()
        );
    }

    @Override
    public void updatePollQuestionByPollID (Poll poll) {
        String sql =" UPDATE " + POLL_TABLE_NAME +
                    " SET question_title =? ,first_answer =? ,second_answer =? ,third_answer =? ,fourth_answer =?" +
                    " WHERE poll_id = ?";

            jdbcTemplate.update(
                    sql,
                    poll.getQuestionTitle(),
                    poll.getFirstAnswer(),
                    poll.getSecondAnswer(),
                    poll.getThirdAnswer(),
                    poll.getFourthAnswer(),
                    poll.getId()
            );
    }

    @Override
    public void deletePollQuestionById(Long id) {
        String sql =" DELETE FROM " + POLL_TABLE_NAME +
                    " WHERE poll_id = ? ";

        jdbcTemplate.update(sql,id);
    }

}
