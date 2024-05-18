package org.example.steps.requests;

import io.restassured.response.Response;
import org.example.models.users.users_id.GetUsersIDRequest;
import org.example.steps.CommonSteps;

import static io.restassured.RestAssured.given;

public class UsersRequestSteps extends CommonSteps {

    // GET https://reqres.in/api/users/id
    public Response getUsersID(GetUsersIDRequest request) {
        return given()
                .spec(commonRequestSpec())
                .get("users/" + String.valueOf(request.getUserID()));
    }

    public Response putUsersID(GetUsersIDRequest request) {
        return given()
                .spec(commonRequestSpec())
                .put("users/" + String.valueOf(request.getUserID()));
    }

    public Response deleteUsersID(GetUsersIDRequest request) {
        return given()
                .spec(commonRequestSpec())
                .delete("users/" + String.valueOf(request.getUserID()));
    }
}
