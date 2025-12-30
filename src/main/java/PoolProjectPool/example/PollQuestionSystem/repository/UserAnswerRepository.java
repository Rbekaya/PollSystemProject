package PoolProjectPool.example.PollQuestionSystem.repository;

import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto2;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto3;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticsDto1;
import PoolProjectPool.example.PollQuestionSystem.model.UserAnswer;

import java.util.List;

public interface UserAnswerRepository {
     void createUserAnswer(UserAnswer userAnswer);
     List<UserAnswer> getAllUsersAnswer();
     List<UserAnswer> getAllAnswersByUserId(Long id);
     void updateAnswerByUserIdAndPollId(UserAnswer userAnswer);
     void deleteUserPollAnswersByUserId(Long id);
     List<UserAnswerStatisticDto2> countTotalOptionAnsweredByPollId(Long id);
     List<UserAnswerStatisticDto2> countTotalAnsweredUserByPollId(Long id);
     List<UserAnswerStatisticDto3> userAnswersByUserId(Long id);
     Long countTotalUserAnswerByUserId(Long id);
     List<UserAnswerStatisticsDto1> countUserAnswerForEachPollQuestionOption();
}
