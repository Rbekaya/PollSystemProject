package PoolProjectPool.example.PollQuestionSystem.dto;

public class UserAnswerStatisticDto3 {
    private String questionTitle;
    private String pollAnswer;

    public UserAnswerStatisticDto3(String questionTitle, String pollAnswer) {
        this.questionTitle = questionTitle;
        this.pollAnswer = pollAnswer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getPollAnswer() {
        return pollAnswer;
    }
}
