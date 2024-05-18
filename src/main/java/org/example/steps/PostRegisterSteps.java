package org.example.steps;

import io.restassured.response.Response;
import org.example.models.users.register.PostRegisterRequest;
import org.example.steps.requests.RegisterRequestSteps;
import org.example.steps.requests.UsersRequestSteps;

import static junit.framework.Assert.assertEquals;

public class PostRegisterSteps extends RegisterRequestSteps {

    public void responseShouldBeWIthStatusCode(PostRegisterRequest request, int expectedStatusCode) {
        Response response = postRegisterResponse(request);

        response.prettyPrint();

        assertEquals(response.statusCode(), expectedStatusCode);
    }
}
