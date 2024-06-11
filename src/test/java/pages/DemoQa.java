package pages;

public class DemoQa extends BasePage{

    private String fullNameField = "//input[@id='userName']";
    private String emailField= "//input[@id='userEmail']";
    private String cAddressField= "//textarea[@id='currentAddress']";
    private String pAddressField= "//textarea[@id='permanentAddress']";

    private String submitButton="//button[@id='submit']";

    public DemoQa(){
        super(driver);
    }

    public void navigateToDemoQa(){
        navigateTo("https://demoqa.com/text-box");
    }

    public void enterName(String name){
        write(fullNameField,name);
    }

    public void enterEmail(String email){
        write(emailField,email);
    }

    public void enterCAddressField(String cAddress){
        write(cAddressField,cAddress);
    }

    public void enterPAddressField(String pAddress){
        write(pAddressField,pAddress);
    }

    public void clickOnSubmitButton (){
        clickElement(submitButton);
    }

    public void dismissAlertMsg1(){
        dismissAlert();
    }
}
