package PoolProjectPool.example.PollQuestionSystem.model;

public class Poll {
    private Long id;
    private String  questionTitle;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String fourthAnswer;

    public Poll() {
    }

    public Poll(Long id, String questionTitle, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    public String toString (){
        return "{id = " + id +
                ", questionTitle = " + questionTitle +
                ", firstAnswer = " + firstAnswer +
                ", secondAnswer = " + secondAnswer +
                ", thirdAnswer = " + thirdAnswer +
                ", fourthAnswer = " + fourthAnswer +
                "}";
    }
}
