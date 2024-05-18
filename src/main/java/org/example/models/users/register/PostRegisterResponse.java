package org.example.models.users.register;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRegisterResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("token")
    private String token;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("error")
    private String error;
}
