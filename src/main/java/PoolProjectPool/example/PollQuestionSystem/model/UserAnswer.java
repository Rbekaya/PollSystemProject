package PoolProjectPool.example.PollQuestionSystem.model;

public class UserAnswer {
    private Long userId;
    private Long pollId;
    private String pollAnswer;

    public UserAnswer() {
    }

    public UserAnswer( Long userId, Long pollId, String pollAnswer) {
        this.userId = userId;
        this.pollId = pollId;
        this.pollAnswer = pollAnswer;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPollId() {
        return pollId;
    }

    public String getPollAnswer() {
        return pollAnswer;
    }

    public void setPollAnswer(String pollAnswer) {
        this.pollAnswer = pollAnswer;
    }

    public String toString (){
        return "{userId= " + userId +
                ", pollId= " + pollId +
                ", pollAnswer=" + pollAnswer +
                "}";
    }
}

