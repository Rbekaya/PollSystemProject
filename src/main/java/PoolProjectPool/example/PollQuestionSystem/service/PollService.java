package PoolProjectPool.example.PollQuestionSystem.service;

import PoolProjectPool.example.PollQuestionSystem.model.Poll;

import java.util.List;

public interface PollService {
    void CreatePollQuestion(Poll poll);
    Poll getPollQuestionById(Long id);
    List<Poll> getAllPollQuestions();
    void updatePollQuestionByPollID(Poll poll);
    void deletePollQuestionById(Long id);
}
