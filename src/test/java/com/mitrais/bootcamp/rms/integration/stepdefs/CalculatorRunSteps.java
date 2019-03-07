package com.mitrais.bootcamp.rms.integration.stepdefs;

import com.mitrais.bootcamp.rms.Calculator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;

public class CalculatorRunSteps {
    int total;

    private Calculator calculator;

    @Before
    private void init(){
        total=-999;
    }

    @Given("^I have a calculator$")
    public void i_have_a_calculator() throws Throwable {
        calculator = new Calculator();
    }

    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void i_add_something_and_something(int a, int b) throws Throwable {
        total=calculator.add(a, b);
    }

    @Then("^the result should be (-?\\d+)$")
    public void the_result_should_be_something(int result) throws Throwable {
        Assert.assertThat(total, Matchers.equalTo(result));
    }
}
