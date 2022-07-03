package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //find+click+clear+sendKeys
        type(By.xpath("//input[1]"), email);
        //find+click+clear+sendKeys
        type(By.xpath("//input[2]"), password);
    }

    public boolean isLogged() {
        //sign out present? --> logged
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return (list.size() > 0);
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isAlertDisplayed() {
        //wait
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
        //is alert present
    }

    public boolean isErrorFormatDisplayed() {
        Alert alert = wd.switchTo().alert();

//        alert.getText();// get
//        alert.sendKeys("Hello World"); // type text
//        alert.accept();//click OK button
//        alert.dismiss();//click Cancel button
        String errorText = alert.getText();
        System.out.println(errorText);
        alert.accept();


        return errorText.contains("Wromg email or password format");
    }
}