package PoolProjectPool.example.PollQuestionSystem.service;

import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto2;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto3;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticsDto1;
import PoolProjectPool.example.PollQuestionSystem.service.internalUserClient.InternalUserService;
import PoolProjectPool.example.PollQuestionSystem.model.UserAnswer;
import PoolProjectPool.example.PollQuestionSystem.repository.UserAnswerRepository;
import PoolProjectPool.example.PollQuestionSystem.dto.InternalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    UserAnswerRepository userAnswerRepository;

    @Autowired
    InternalUserService internalUserService;


    @Override
    public void createUserAnswer(UserAnswer userAnswer) {
        List<InternalUser> allInternalUsers = internalUserService.getAllInternalUser();
        Map<Long, String> registeredUsers = new HashMap<>();

            for (InternalUser internalUser :allInternalUsers) {
                String fullName = internalUser.getFirstName() + " " + internalUser.getLastName();
                registeredUsers.putIfAbsent(internalUser.getUserId(), fullName);
            }
                if (registeredUsers.containsKey(userAnswer.getUserId())) {
                    userAnswerRepository.createUserAnswer(userAnswer);
                } else {
                    System.out.println("user not registered");
                }
    }

    @Override
    public List<UserAnswer> getAllUserAnswer() {
        return userAnswerRepository.getAllUsersAnswer();
    }

    @Override
    public List<UserAnswer> getAllAnswersByUserId(Long id) {
        return userAnswerRepository.getAllAnswersByUserId(id);
    }

    @Override
    public void updateAnswerByUserIdAndPollId(UserAnswer userAnswer) {
        if (userAnswer == null) {
            return;
        }

        List<UserAnswer> repoAllUserAnswers = userAnswerRepository.getAllAnswersByUserId(userAnswer.getUserId());

        if (repoAllUserAnswers.isEmpty()){
            System.out.println("User did`t answer the requested question( " + userAnswer.getPollId() + " userID = " + userAnswer.getUserId() + ")!");
            return;
        }

        for (UserAnswer curUserAnswer : repoAllUserAnswers) {
            if (curUserAnswer.getPollId().equals(userAnswer.getPollId())) {
                if (curUserAnswer.getPollAnswer().equals(userAnswer.getPollAnswer())) {
                    System.out.println("No changes(same string)!");
                    return;
                }
                userAnswerRepository.updateAnswerByUserIdAndPollId(userAnswer);
                return;
            }
        }
        System.out.println("User did`t answer the requested question( " + userAnswer.getPollId() + " userID = " + userAnswer.getUserId() + ")!");

    }

    @Override
    public void deleteUserPollAnswersByUserId(Long id) {
        try {
            InternalUser internalUserUserAnswer = internalUserService.getInternalUserById(id);

            if (internalUserUserAnswer == null) {
                userAnswerRepository.deleteUserPollAnswersByUserId(id);
            } else {
                System.out.println("You must unregister from the system before trying to delete answers");
            }
        } catch (Exception e) {
            userAnswerRepository.deleteUserPollAnswersByUserId(id);
        }
    }

    @Override
    public List<UserAnswerStatisticDto2> countTotalOptionAnsweredByPollId(Long id) {
        return userAnswerRepository.countTotalOptionAnsweredByPollId(id);
    }

    @Override
    public List<UserAnswerStatisticDto2> countTotalAnsweredUserByPollId(Long id) {
        return userAnswerRepository.countTotalAnsweredUserByPollId(id);
    }

    @Override
    public List<UserAnswerStatisticDto3> userAnswersByUserId(Long id){
        return userAnswerRepository.userAnswersByUserId(id);
    }

    @Override
    public Long countTotalUserAnswerByUserId(Long id) {
        return userAnswerRepository.countTotalUserAnswerByUserId(id);
    }

    @Override
    public List<UserAnswerStatisticsDto1> countUserAnswerForEachPollQuestionOption() {
        return userAnswerRepository.countUserAnswerForEachPollQuestionOption();
    }

}


