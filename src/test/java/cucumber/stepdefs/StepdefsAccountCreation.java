package cucumber.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.emilindadie.dto.AccountDto;
import com.emilindadie.dto.UserDto;
import com.emilindadie.model.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.config.SpringIntegrationTest;
import lombok.extern.java.Log;

@Log
public class StepdefsAccountCreation {
	
	@LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webClient;
    
    private StepDefsContext context = StepDefsContext.CONTEXT;
    
    @Given("a user of userId (.*) and of name (.*) and of email (.*) and of address (.*)")
    public void a_user_of_information(int userId, String name, String email, String address) {
    	UserDto user = UserDto.builder()
			.id(userId)
			.name(name)
	        .email(email)
	        .address(address)
	        .build();
        context.givenObject(user, UserDto.class);
    }
   
    @Given("an account of accountName (.*)")
    public void a_account_of_information(String name) {
    	AccountDto account = AccountDto.builder()
			.name(name)
	        .solde(0)
	        .user(context.givenObject(UserDto.class))
	        .build();
        context.givenObject(account, AccountDto.class);
    }

    @When("he want to create a new account")
    public void he_want_to_create_a_new_account() {
        WebTestClient.ResponseSpec response = webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/account")
                        .port(3001)
                        .build())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(context.givenObject(AccountDto.class)))
                .exchange();
        context.thenObject(response, WebTestClient.ResponseSpec.class);
    }

    @Then("the account is created")
    public void the_account_is_created() {
        WebTestClient.ResponseSpec response = context.thenObject(WebTestClient.ResponseSpec.class);
        response.expectStatus()
                .isCreated()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(User.class).value(u -> u.getName().equals("Compte A"));
    }
}
