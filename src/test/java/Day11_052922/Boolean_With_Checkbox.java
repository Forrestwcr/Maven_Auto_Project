package Day11_052922;

import ReusableLibrary.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Boolean_With_Checkbox {

    //declare the local driver outside so it that it can be reusable with other annotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite annotation

    @Test()
    public void Yahoo_Stay_Signed_In_Checkbox_Verification(){
        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver,10);
        //click on sign in
        Reusable_Actions.clickAction(driver,"//*[text()='Sign in']","Sign In");
        //verify the stay signed in checkbox is selected or not
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("Is element check? " + elementState);
    }//end of test

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }

}
