package org.example.steps.requests;

import io.restassured.response.Response;
import org.example.models.users.register.PostRegisterRequest;
import org.example.models.users.register.PostRegisterResponse;
import org.example.steps.CommonSteps;

import static io.restassured.RestAssured.given;

public class RegisterRequestSteps extends CommonSteps {

    // POST api/register
    public Response postRegisterResponse(PostRegisterRequest request) {
        return given()
                .spec(commonRequestSpec())
                .body(request)
                .post("/register");
    }
}
