package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MathService {
    public Response getMath(RequestSpecification specification) {
        Response response = RestAssured.given(specification)
                .log().all()
                .get("http://api.mathjs.org/v4/");
        System.out.println("Response: ");
        response.getBody().prettyPrint();

        return response;
    }

    public Response postMath(RequestSpecification specification, String body) {
        Response response = RestAssured.given(specification)
                .body(body)
                .log().all()
                .post("http://api.mathjs.org/v4/");
        System.out.println("Response: ");
        response.getBody().prettyPrint();

        return response;
    }

    /*
        Ways to improve:
        1. Load the URL from the baseURI.properties file
        2. If API could be more complex, we could do one function that determines what to send
            Like using switch case for get/post/put/path/delete method
        3. Implementing BaseService class should be considered when having multiple
            Services. this class also will handle logging (with log4j) and make code cleaner
            Example:
            public Func myFunc() {
                return executePostRequest(specification, endpoint);
            }
        4. Content-type would be also manipulated with BaseService depending on request type
    */
}
