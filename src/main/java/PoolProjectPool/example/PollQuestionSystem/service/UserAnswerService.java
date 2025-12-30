package PoolProjectPool.example.PollQuestionSystem.service;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto2;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto3;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticsDto1;
import PoolProjectPool.example.PollQuestionSystem.model.UserAnswer;

import java.util.List;

public interface UserAnswerService {
    void createUserAnswer(UserAnswer userAnswer);
    List<UserAnswer> getAllUserAnswer();
    List<UserAnswer> getAllAnswersByUserId(Long id);
    void updateAnswerByUserIdAndPollId(UserAnswer userAnswer) throws Exception;
    void deleteUserPollAnswersByUserId(Long id);
    List<UserAnswerStatisticDto2> countTotalOptionAnsweredByPollId(Long id);
    List<UserAnswerStatisticDto2> countTotalAnsweredUserByPollId(Long id);
    List<UserAnswerStatisticDto3> userAnswersByUserId(Long id);
    Long countTotalUserAnswerByUserId(Long id);
    List<UserAnswerStatisticsDto1> countUserAnswerForEachPollQuestionOption ();

}
