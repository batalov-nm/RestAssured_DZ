package org.example.users;

import org.example.models.users.register.PostRegisterRequest;
import org.example.models.users.register.PostRegisterResponse;
import org.example.steps.PostRegisterSteps;
import org.junit.jupiter.api.Test;

public class TestPostRegister {

    private final PostRegisterSteps postRegisterSteps = new PostRegisterSteps();

    @Test
    public void successPostRegister() {
        PostRegisterRequest request = PostRegisterRequest.builder()
//                .setUsername("jamal229_gamer")
                .setEmail("sabikam551@bsomek.com")
                .setPassword("test123")
                .build();

        PostRegisterResponse response = postRegisterSteps.postRegisterResponse(request).as(PostRegisterResponse.class);
        postRegisterSteps.responseShouldBeWIthStatusCode(request, 200);
    }

    @Test
    public void failurePostRegister() {
        PostRegisterRequest request = PostRegisterRequest.builder()
                .setEmail("1234")
                .setPassword("test123")
                .build();

        PostRegisterResponse response = postRegisterSteps.postRegisterResponse(request).as(PostRegisterResponse.class);
        postRegisterSteps.responseShouldBeWIthStatusCode(request, 400);
    }
}
