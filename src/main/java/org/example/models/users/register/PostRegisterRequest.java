package org.example.models.users.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class PostRegisterRequest {

//    @JsonProperty("username")
//    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}
