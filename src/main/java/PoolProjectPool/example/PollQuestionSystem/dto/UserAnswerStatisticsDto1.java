package PoolProjectPool.example.PollQuestionSystem.dto;

public class UserAnswerStatisticsDto1 {
    private Long pollId;
    private String questionTitle;
    private String pollAnswer;
    private Long totalUsers;


    public UserAnswerStatisticsDto1(Long pollId, String questionTitle, String pollAnswer, Long totalUsers) {
        this.pollId = pollId;
        this.questionTitle = questionTitle;
        this.pollAnswer = pollAnswer;
        this.totalUsers = totalUsers;
    }

    public Long getPollId() {
        return pollId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getPollAnswer() {
        return pollAnswer;
    }

    public Long getTotalUsers() {
        return totalUsers;
    }
    public String toString(){
        return "{pollId = " + pollId +
                ", questionTitle = " + questionTitle +
                ", pollAnswer = " + pollAnswer +
                ", totalUsers = " + totalUsers +
                "}";
    }
}
