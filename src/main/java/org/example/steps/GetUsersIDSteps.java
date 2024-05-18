package org.example.steps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.example.models.users.users_id.GetUsersIDRequest;
import org.example.models.users.users_id.GetUsersIDResponse;
import org.example.steps.requests.UsersRequestSteps;
import org.hamcrest.Matchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUsersIDSteps extends UsersRequestSteps {

//    protected ValidatableResponse then() {
//        return (ValidatableResponse) this.then();
//    }

    // IDs Should Be Equals
    public void userIDsShouldBeEqual(GetUsersIDResponse response, Integer expectedUserID) {
//        ValidatableResponse vResponse = (ValidatableResponse) response;
//        vResponse.assertThat().body("id", Matchers.is(expectedUserID));
        assertEquals(response.getData().getUserID(), expectedUserID);
    }

    public void responseShouldBeWithStatusCode(GetUsersIDRequest request, int expectedStatusCode) {
        Response response = getUsersID(request);

        response.prettyPrint();

        assertEquals(response.statusCode(), expectedStatusCode);
    }

    // Status Code - 200
    public void responseShouldBeSuccess(GetUsersIDResponse response) {
        ValidatableResponse vResponse = (ValidatableResponse) response;
        vResponse.assertThat().statusCode(200);
    }

    // Status Code - 400
    public void responseShouldBeFail(GetUsersIDResponse response) {
        ValidatableResponse vResponse = (ValidatableResponse) response;
        vResponse.assertThat().statusCode(400);
    }

    // Response Body - empty
    public void responseBodyShouldBeEmpty(GetUsersIDResponse response) {
        ValidatableResponse vResponse = (ValidatableResponse) response;
        vResponse.assertThat().body("size()", Matchers.is(0));
    }
}
