package org.example.models.users.users_id;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class GetUsersIDRequest {

    private int userID;
}
