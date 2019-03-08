package com.mitrais.bootcamp.rms.integration.stepdefs;

import com.mitrais.bootcamp.rms.integration.SpringIntegrationTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PermissionControllerIntegrationTest extends SpringIntegrationTest{
    protected ResultActions actions;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void SetupCucumberSpringContext() {
        //dummy method so cucumber will recognize this class as glue
        //and use its context configuration
    }

    @When("^the client call /permissions$")
    public void the_client_call_permissions() throws Throwable {
        actions = mockMvc.perform(get("/permissions")
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("^the client receives status of 200$")
    public void the_client_receives_status_of_200() throws Throwable {
        actions.andExpect(status().isOk());
    }

}
