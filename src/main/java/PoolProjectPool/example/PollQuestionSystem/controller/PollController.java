package PoolProjectPool.example.PollQuestionSystem.controller;

import PoolProjectPool.example.PollQuestionSystem.model.Poll;
import PoolProjectPool.example.PollQuestionSystem.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poll")
public class PollController {

    @Autowired
    PollService pollService;

    @PostMapping("/create")
    public void createPollQuestion (@RequestBody Poll poll){
        pollService.CreatePollQuestion(poll);
    };

    @GetMapping("/{id}")
    public Poll getPollQuestionById(@PathVariable Long id){
       return pollService.getPollQuestionById(id);
    }

    @GetMapping("/all")
    public List<Poll> getAllPollQuestions(){
        return pollService.getAllPollQuestions();
    }

    @PutMapping("/update")
    public void updatePollQuestionByID(@RequestBody Poll poll) {
         pollService.updatePollQuestionByPollID(poll);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePollQuestionById(@PathVariable Long id){
        pollService.deletePollQuestionById(id);
    }

}
