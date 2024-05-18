package org.example.steps;

import io.restassured.response.Response;
import org.example.models.users.users_id.GetUsersIDRequest;
import org.example.models.users.users_id.PutUpdateUserResponse;
import org.example.steps.requests.UsersRequestSteps;

import static org.junit.jupiter.api.Assertions.*;

public class PutUsersIDSteps extends UsersRequestSteps {

    public void responseShouldBeWithStatusCode(GetUsersIDRequest request, int expectedStatusCode) {
        Response response = putUsersID(request);

        response.prettyPrint();

        assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public void isUserNull(PutUpdateUserResponse response) {
        assertNull(response.getJob());
        assertNull(response.getName());
        assertNotNull(response.getUpdatedAt());
    }
}
