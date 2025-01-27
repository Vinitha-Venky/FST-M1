package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GitHub_RestAssured_Project {
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKnNiZJwNcmRaWWpaPo6Xe8b++0Wzdqk3Z7Z0Of9su/M";
    String sshKeyId;

    // Request specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").
            build();
    // Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).
            expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();

    @Test(priority = 1)
    public void postRequestTest() {
        // Path: https://api.github.com/user/keys
        // Request body
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        // Generate response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        // Extract the id
        sshKeyId = response.then().extract().path("id");

        // Assertions
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().get("/{keyId}").
        then().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        // Path: https://api.github.com/user/keys/{keyId}
        // Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
        when().delete("/{keyId}").
        then().statusCode(204).time(lessThan(3000L));
    }
}
