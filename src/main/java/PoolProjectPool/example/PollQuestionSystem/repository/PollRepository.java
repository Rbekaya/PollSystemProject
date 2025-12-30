package PoolProjectPool.example.PollQuestionSystem.repository;

import PoolProjectPool.example.PollQuestionSystem.model.Poll;

import java.util.List;

public interface PollRepository {
    void CreatePollQuestion(Poll poll);
    Poll getPollQuestionById (Long id);
    List<Poll> getAllPollQuestions ();
    void updatePollQuestionByPollID (Poll Poll);
    void deletePollQuestionById(Long id);
}
