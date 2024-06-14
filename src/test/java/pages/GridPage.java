package pages;

public class GridPage extends BasePage {

    private String cell= "//*[@id='root']/div/";
    private String mainTable="//body/div[@id='root']/div[1]";

    public GridPage(){
        super (driver);
    }

    public void navigateToGrid(){
        navigateTo("https://1v2njkypo4.csb.app/");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell,row, column);
    }

    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }
}
