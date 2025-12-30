package PoolProjectPool.example.PollQuestionSystem.dto;

public class UserAnswerStatisticDto2 {
    public String questionTitle;
    public Long totalUsers;

    public UserAnswerStatisticDto2(String questionTitle, Long totalUsers) {
        this.questionTitle = questionTitle;
        this.totalUsers = totalUsers;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public Long getTotalUsers() {
        return totalUsers;
    }
}
