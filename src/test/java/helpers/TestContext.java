package helpers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {

    public Response response;
    public RequestSpecification specification;
    public String body;

    public TestContext() {
        specification = HeadersBuilder.getBasicHeaders();
    }
}
