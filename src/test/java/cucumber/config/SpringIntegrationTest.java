package cucumber.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.emilindadie.BankAccountKataApiApplication;


@SpringBootTest(classes = BankAccountKataApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {

    public SpringIntegrationTest() {
    }
    private static final Logger LOG = LoggerFactory.getLogger(SpringIntegrationTest.class);

    @PostConstruct
    public void setup() {
        //Awesome code here
    }
 
    @PreDestroy
    public void tearDown() {
        //Even more awesome code here
    }
}