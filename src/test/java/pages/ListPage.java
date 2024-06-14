package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListPage extends BasePage {

    private String searchField = "//input[@id='myInput']";
    //private String  btnBuscar = "//input[@id='submit-button']";
    private String  btnBuscar = "//*[@id='myInputautocomplete-list']/div";

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("http://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
    }

    public void enterSearchCriteria() throws InterruptedException{
        try {
            Thread.sleep(600); //Recuerda que es mala practica usar un sleep
            write(searchField, "W");
        }catch(NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found");
            e.printStackTrace();
        }
    }


    public List<String> getAllSearchResults(){ //Transformaremos la lista que se tiene en la BasePage que son web element, en una lista de texto "String"
        List<WebElement> list = bringMeAllElement(btnBuscar);
        List<String> stringsFromList = new ArrayList<String>();
        for (WebElement e: list){
            stringsFromList.add(e.getText());      //Agregaremos cada web element en la lista String ocmo texto cada iteracion
        }
        return stringsFromList;
    }
}