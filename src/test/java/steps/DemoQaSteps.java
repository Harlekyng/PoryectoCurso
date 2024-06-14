package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DemoQa;

public class DemoQaSteps {

    DemoQa demoQa = new DemoQa();

    @Given("I am on the ToolsQA page")
    public void navigateToDemoQa(){
        demoQa.navigateToDemoQa();
    }

    @When("I enter a name {string} in the text box")
    public void iEnterANameInTheTextBox(String arg0) {
        demoQa.enterName(arg0);
    }

    @And("I enter an email")
    public void enterAnEmail(){
        demoQa.enterEmail("abcd@gmail.com");
    }

    @And("I enter a current address")
    public void enterACurrentAddress(){
        demoQa.enterCAddressField("San Miguel");
    }

    @And("I enter a permanent address")
    public void enterAPermanentAddress(){
        demoQa.enterPAddressField("Curnianca");
    }

    @And("I click on the submit button")
    public void clickOnTheSubmitButton(){
        demoQa.clickOnSubmitButton();
    }

    @Then("the form should be submitted successfully")
    public void theFormShouldBeSubmittedSuccessfully() {
    }

}
