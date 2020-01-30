package cucumber.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.emilindadie.dto.SignInDto;
import com.emilindadie.model.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.java.Log;


@Log
@AutoConfigureWebTestClient(timeout = "10000")//10 seconds
public class StepdefsUserSignIn{

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webClient;

    private StepDefsContext context = StepDefsContext.CONTEXT;

    @Given("a user of email (.*) and of password (.*)")
    public void a_user_of_information(String email, String password) {
    	SignInDto data = new SignInDto();
    	data.setEmail("dadie.emilin@gmail.com");
    	data.setPassword("azerty");
        context.givenObject(data, SignInDto.class);
    }

    @When("he want to signin to the system")
    public void he_want_to_sign_in_to_the_system() {
        WebTestClient.ResponseSpec response = webClient
                .post()
                .uri("localhost:3001/user/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(context.givenObject(SignInDto.class)))
                .exchange();
        context.thenObject(response, WebTestClient.ResponseSpec.class);
    }

    @Then("the user is signin")
    public void the_user_is_sign_in() {
        WebTestClient.ResponseSpec response = context.thenObject(WebTestClient.ResponseSpec.class);
        response.expectStatus()
                .isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(User.class).value(u -> u.getName().equals("Emilin"));

    }
}