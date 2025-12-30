package PoolProjectPool.example.PollQuestionSystem.service;

import PoolProjectPool.example.PollQuestionSystem.model.Poll;
import PoolProjectPool.example.PollQuestionSystem.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    @Autowired
    PollRepository pollRepository;

    @Override
    public void CreatePollQuestion(Poll poll) {
        pollRepository.CreatePollQuestion(poll);
    }

    @Override
    public Poll getPollQuestionById(Long id) {
        return pollRepository.getPollQuestionById(id);
    }

    @Override
    public List<Poll> getAllPollQuestions() {
        return pollRepository.getAllPollQuestions();
    }

    @Override
    public void updatePollQuestionByPollID(Poll poll) {
         pollRepository.updatePollQuestionByPollID(poll);
    }

    @Override
    public void deletePollQuestionById(Long id) {
        pollRepository.deletePollQuestionById(id);
    }
}
