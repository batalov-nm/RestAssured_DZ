package org.example.models.users.users_id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PutUpdateUserResponse {

    private String name;

    private String job;

    private String updatedAt;
}
