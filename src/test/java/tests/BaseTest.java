package tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseTest {
    protected List<String> extractArray(Response response, String arrayPath) {
        JsonArray jsonArray = JsonParser.parseString(response.getBody().asString())
                .getAsJsonObject()
                .getAsJsonArray(arrayPath);

        List<String> extractedList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            extractedList.add(jsonArray.get(i).getAsString());
        }
        return extractedList;
    }

    protected List<String> convertBodyToList(String body) {
        // Remove the surrounding brackets
        String bodyAsString = body.substring(1, body.length() - 1);
        // Split the string by comma
        String[] values = bodyAsString.split(",");
        List<String> resultList = new ArrayList<>();
        for (String value : values) {
            // Trim to remove leading and trailing whitespace, and remove quotation marks
            resultList.add(value.trim().replace("\"", ""));
        }
        return resultList;
    }
}

/*
    This class is used for following things (which can be expanded)
    - Basic assertion like key compare and status codes
    - Complex assertions like image compare (byte array or hashcode)
    - Extracting simple and complex values
    - Extracting headers for assertions or future request usage
*/