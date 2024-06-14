package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GridPage;

public class GridTestStep {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(3,2);
        Assert.assertEquals("r: 2, c: 1", value); //Si se coloca algo diferente de "r: 2, c: 1" deberia fallar ya que es lo que devuelve el xpath


        //System.out.println(value); Eliminamos esto para ver los assert (Inicialmente esto solo era para valdiar que se busca en la grilla)
    }

    /*@Then("I can validate the table is displayed")
    public void iCanValidateTheTableIsDisplayed() {
        Assert.assertTrue("Explotó todo", grid.cellStatus());
    }*/

    @Then("I can validate the table is displayed")
    public void iCanValidateTheTableIsDisplayed() {
        Assert.assertFalse("Explotó todo", grid.cellStatus());
    }

}
