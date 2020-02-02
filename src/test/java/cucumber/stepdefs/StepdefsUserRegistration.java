package cucumber.stepdefs;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import com.emilindadie.dto.UserDto;
import com.emilindadie.model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.config.SpringIntegrationTest;


@Log
public class StepdefsUserRegistration extends SpringIntegrationTest{

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webClient;

    private StepDefsContext context = StepDefsContext.CONTEXT;
    
    @Given("a user of name (.*) and of email (.*) and of address (.*) and of password (.*)")
    public void a_user_of_information(String name, String email, String address, String password) {
    	UserDto user = UserDto.builder()
			.name(name)
	        .email(email)
	        .address(address)
	        .password(password)
	        .build();
        context.givenObject(user, UserDto.class);
    }

    @When("he want to register himself")
    public void he_want_to_register_himself() {
        WebTestClient.ResponseSpec response = webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/user")
                        .port(3001)
                        .build())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(context.givenObject(User.class)))
                .exchange();
        context.thenObject(response, WebTestClient.ResponseSpec.class);
    }

    @Then("the user is registered")
    public void the_user_is_registered() {
        WebTestClient.ResponseSpec response = context.thenObject(WebTestClient.ResponseSpec.class);
        response.expectStatus()
                .isCreated()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(User.class).value(u -> u.getName().equals("Emilin"));

    }
}