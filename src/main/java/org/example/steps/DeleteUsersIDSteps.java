package org.example.steps;

import io.restassured.response.Response;
import org.example.models.users.users_id.GetUsersIDRequest;
import org.example.steps.requests.UsersRequestSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUsersIDSteps extends UsersRequestSteps {

    public void responseShouldBeWithStatusCode(GetUsersIDRequest request, int expectedStatusCode) {
        Response response = deleteUsersID(request);

        response.prettyPrint();

        assertEquals(response.statusCode(), expectedStatusCode);
    }
}
