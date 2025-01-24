package liveProject;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    
	Map<String,String> headers= new HashMap<>();
	
	
	@Pact(consumer= "UserConsumer",provider="UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		   headers.put("Content-Type", "application/json");
		   DslPart reqResBody = new PactDslJsonBody()
				   .numberType("id", 2607)
				   .stringType("firstName","Vinitha")
				   .stringType("lastName","Ollala")
				   .stringType("email","vinni26@mail.com");
		  
		   return builder.given("POST Request")
				   .uponReceiving("A Request to create a user")
				   .method("POST")
				   .path("/api/users")
				   .headers(headers)
				   .body(reqResBody)
				   .willRespondWith()
				   .status(201)
				   .body(reqResBody)
				   .toPact();
	}
	
	
	@Test
	@PactTestFor(providerName="UserProvider",port="8282")
	public void postRequestTest() {
		
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 2607);
		reqBody.put("firstName", "Vinitha");
		reqBody.put("lastName", "Ollala");
		reqBody.put("email", "vinni26@mail.com");
		
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody)
		.when().post()
		.then().statusCode(201).log().all();
		//.body("email",equalTo("vinni26@mail.com")).

		
	}
	}
	

