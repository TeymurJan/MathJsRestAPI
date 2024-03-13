package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class HeadersBuilder {
    public static RequestSpecification getBasicHeaders() {
        return new RequestSpecBuilder()
                .addHeader("User-Agent", "Mobile")
                .addHeader("Accept", "*/*")
                .addHeader("content-type", "application/json")
                .build();
    }
}

