package org.example.users;

import io.restassured.response.Response;
import org.example.models.users.users_id.GetUsersIDRequest;
import org.example.models.users.users_id.GetUsersIDResponse;
import org.example.models.users.users_id.PutUpdateUserResponse;
import org.example.steps.DeleteUsersIDSteps;
import org.example.steps.GetUsersIDSteps;
import org.example.steps.PutUsersIDSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestGetUsersID {
    private final GetUsersIDSteps getUsersIDSteps = new GetUsersIDSteps();
    private final DeleteUsersIDSteps deleteUsersIDSteps = new DeleteUsersIDSteps();
    private final PutUsersIDSteps putUsersIDSteps = new PutUsersIDSteps();

    @ParameterizedTest(name = "[{index}] - {displayName} ID: {0}")
    @ValueSource(ints = {1, 2, 3})
    public void successGetUsersID(Integer userID) {
        GetUsersIDRequest request = GetUsersIDRequest.builder()
                .setUserID(userID)
                .build();

        GetUsersIDResponse response = getUsersIDSteps.getUsersID(request).as(GetUsersIDResponse.class);

        getUsersIDSteps.responseShouldBeWithStatusCode(request, 200);
        getUsersIDSteps.userIDsShouldBeEqual(response, userID);
    }

    @Test
    public void failureGetUsersIdWithoutRequiredFields() {
        GetUsersIDRequest request = GetUsersIDRequest.builder()
                .build();

        GetUsersIDResponse response = getUsersIDSteps.getUsersID(request).as(GetUsersIDResponse.class);

        getUsersIDSteps.responseShouldBeWithStatusCode(request, 404);
    }

    @Test
    public void successDeleteUsersId() {
        GetUsersIDRequest request = GetUsersIDRequest.builder()
                .setUserID(11)
                .build();
        GetUsersIDResponse response = getUsersIDSteps.getUsersID(request).as(GetUsersIDResponse.class);
        getUsersIDSteps.responseShouldBeWithStatusCode(request, 200);

        Response deleteResponse = getUsersIDSteps.deleteUsersID(request);
        deleteUsersIDSteps.responseShouldBeWithStatusCode(request, 204);
    }

    @Test
    public void failureDeleteUsersIdWithNonExistentUserId() {
        GetUsersIDRequest request = GetUsersIDRequest.builder()
                .setUserID(313515443)
                .build();

        Response deleteResponse = getUsersIDSteps.deleteUsersID(request);
        deleteUsersIDSteps.responseShouldBeWithStatusCode(request, 204);
    }

    @Test
    public void successPutUsersId() {
        GetUsersIDRequest request = GetUsersIDRequest.builder()
                .setUserID(1)
                .build();

        PutUpdateUserResponse response = putUsersIDSteps.putUsersID(request).as(PutUpdateUserResponse.class);
        putUsersIDSteps.responseShouldBeWithStatusCode(request, 200);
    }

    @Test
    public void failurePutUsersIdWithoutRequiredFields() {
        GetUsersIDRequest request = GetUsersIDRequest.builder()
//                .setUserID(87)
                .build();

        PutUpdateUserResponse response = putUsersIDSteps.putUsersID(request).as(PutUpdateUserResponse.class);
        putUsersIDSteps.responseShouldBeWithStatusCode(request, 200);
        putUsersIDSteps.isUserNull(response);
    }
}
