package com.mitrais.bootcamp.rms.integration.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class DepartmentControllerIntegrationTest extends StepDefs{

    @Autowired
    private MockMvc mockMvc;

    @When("^the client call /department/all$")
    public void the_client_call_departmentall() throws Throwable {
        actions = mockMvc.perform(get("/department/all")
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("^the department receives status of 200$")
    public void the_department_receives_status_of_200() throws Throwable {
        actions.andExpect(status().isOk());
    }

    @And("^the response should be contain:$")
    public void the_response_should_be_contain(String sDept) throws Throwable {
        actions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name").value(sDept));
    }

}
