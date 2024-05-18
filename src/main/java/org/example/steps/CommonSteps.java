package org.example.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonSteps {
    public RequestSpecification commonRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}
