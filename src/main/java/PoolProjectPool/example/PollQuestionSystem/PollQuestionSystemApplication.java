package PoolProjectPool.example.PollQuestionSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PollQuestionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollQuestionSystemApplication.class, args);
	}
}
