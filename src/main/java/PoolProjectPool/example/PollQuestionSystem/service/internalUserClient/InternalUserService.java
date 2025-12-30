package PoolProjectPool.example.PollQuestionSystem.service.internalUserClient;
import PoolProjectPool.example.PollQuestionSystem.dto.InternalUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
    name = "InternalUserService",
    url = "${externalApi.UserService.url}"
)
public interface InternalUserService {

    @GetMapping("/user/{id}")
    InternalUser getInternalUserById (@PathVariable Long id);

    @GetMapping("/user/all")
    List<InternalUser> getAllInternalUser ();

}
