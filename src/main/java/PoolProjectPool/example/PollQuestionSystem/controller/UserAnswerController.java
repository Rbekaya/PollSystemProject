package PoolProjectPool.example.PollQuestionSystem.controller;

import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto2;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticDto3;
import PoolProjectPool.example.PollQuestionSystem.dto.UserAnswerStatisticsDto1;
import PoolProjectPool.example.PollQuestionSystem.model.UserAnswer;
import PoolProjectPool.example.PollQuestionSystem.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userAnswer")
public class UserAnswerController {

    @Autowired
    UserAnswerService userAnswerService;

    @PostMapping("/create")
    public void createUserAnswer(@RequestBody UserAnswer userAnswer) {
        userAnswerService.createUserAnswer(userAnswer);
    }

    @GetMapping("/all")
    public List<UserAnswer> getAllUserAnswer() {
        return userAnswerService.getAllUserAnswer();
    }

    @GetMapping("/all/{id}")
    public List<UserAnswer> getAllAnswersByUserId(@PathVariable Long id) {
        return userAnswerService.getAllAnswersByUserId(id);
    }

    @PutMapping("/update")
    public void updateAnswerByUserId(@RequestBody UserAnswer userAnswer) throws Exception {
        userAnswerService.updateAnswerByUserIdAndPollId(userAnswer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserAnswerByUserId(@PathVariable Long id) {
        userAnswerService.deleteUserPollAnswersByUserId(id);
    }

    @GetMapping("/count/totalOptionAnsweredByPollId/{id}")
    public List<UserAnswerStatisticDto2> countTotalOptionAnsweredByPollId(@PathVariable Long id){
        return userAnswerService.countTotalOptionAnsweredByPollId(id);
    }

    @GetMapping("/count/{id}")
    public List<UserAnswerStatisticDto2> countTotalAnsweredUserByPollId(@PathVariable Long id) {
        return userAnswerService.countTotalAnsweredUserByPollId(id);
    }

    @GetMapping("/answer/{id}")
    public List<UserAnswerStatisticDto3> userAnswersByUserId(@PathVariable Long id){
        return userAnswerService.userAnswersByUserId(id);
    }

    @GetMapping("count/answer/{id}")
    public Long countTotalUserAnswerByUserId(@PathVariable Long id) {
        return userAnswerService.countTotalUserAnswerByUserId(id);
    }

    @GetMapping("/count/eachAnswerOptionsByPollId")
    public List<UserAnswerStatisticsDto1> countUserAnswerForEachPollQuestionOption() {
        return userAnswerService.countUserAnswerForEachPollQuestionOption();
    }

}