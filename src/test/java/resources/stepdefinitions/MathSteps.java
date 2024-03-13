package resources.stepdefinitions;

import helpers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import services.MathService;
import tests.BaseTest;

import java.util.List;

public class MathSteps extends BaseTest {
    private TestContext context;
    private MathService mathService;

    public MathSteps(TestContext context) {
        this.context = context;
        this.mathService = new MathService();
    }

    @Given("I have the following expressions")
    public void iHaveTheFollowingExpressions(List<String> expressions) {
        if (expressions.size() == 1) {
            context.body = new JSONObject().put("expr", expressions.get(0)).toString();
        } else {
            context.body = new JSONObject().put("expr", expressions).toString();
        }
    }

    @Given("I have the following query parameters")
    public void iHaveTheFollowingQueryParameters(List<String> params) {
        for (String param : params) {
            context.specification.queryParam("expr", param);
        }
    }

    @When("I execute math request with body")
    public void iExecuteMathRequestWithBody() {
        context.response = mathService.postMath(context.specification, context.body);
    }

    @When("I execute math request with query parameters")
    public void iExecuteMathRequestWithQueryParameters() {
        context.response = mathService.getMath(context.specification);
    }


    /*
    This function could be improved just by splitting the steps
    I am just showing off my getBody.asString.contains knowledge :P

    The best way to improve this function, theoretically, is to ask Dev's to return response
    In same format for GET and POST requests, so that we QA won't suffer with extra processing in our tests
    */
    @Then("I should see this results")
    public void iShouldSeeThisResults(List<String> expectedResults) {
        List<String> actualResults;
        if (context.response.getBody().asString().contains("result")) {
            actualResults = extractArray(context.response, "result");
        } else {
            actualResults = convertBodyToList(context.response.getBody().asString());
        }
        Assert.assertEquals("Lists are not equal:\n", expectedResults, actualResults);
    }

    /*
    Overall suggestion for the Steps class is to also have a CommonSteps class,
    which will have steps that are realized and used in various amounts of Steps classes
    Like "Status code is {int}"
    Authorization processes
    Error validations, or for this situation, "I have query parameters"
    */
}
