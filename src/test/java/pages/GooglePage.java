package pages;

public class GooglePage extends BasePage {
    private String searchButton="//input[@value='Buscar con Google']";
    private String searchTextField ="//textarea[@title='Buscar']";

    private String firstResult="";

    public GooglePage(){
       super (driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com/");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField,criteria);
    }

/*  Esto es el llamado assertion que podria hacerse pero no es la mejro practica hacerlo directo sino conseguir un texto y comparar
    Por esto crearemos un metodo firstResult
    public void validateSearch(){
        validateText("","");
    }
*/
    public String firstResult(){
        return textFromElement(firstResult());
    }
}
