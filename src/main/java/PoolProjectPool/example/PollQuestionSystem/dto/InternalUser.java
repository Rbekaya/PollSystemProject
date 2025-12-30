package PoolProjectPool.example.PollQuestionSystem.dto;

public class InternalUser {
    private Long userId;
    private String firstName;
    private String lastName;

    public InternalUser(Long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return "{userID= " + userId +
                ", firstName= " + firstName +
                ", lastName=" + lastName +
                "}";
    }
}
