package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.Locator;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void SaveContact() {
        click(By.xpath("//b[text()='Save']"));
        //wd.findElement(By.xpath("//*[@placeholder='description']")).sendKeys(Keys.TAB);
        //wd.findElement(By.cssSelector(".add_form__2rsm button")).sendKeys(Keys.ENTER);
    }

    public void openAddContactForm() {
        click(By.xpath("//*[@href='/add']"));
        pause(500);

    }

    public void fillAddContactForm(Contact contact) {
        type(By.xpath("//*[@placeholder='Name']"), contact.getName());
        type(By.xpath("//*[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//*[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//*[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//*[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//*[@placeholder='description']"), contact.getDescription());
        pause(500);

    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> names = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : names) {
            if (el.getText().equals(name)) {
                System.out.println("The name is found:" + el.getText());
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> phones = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : phones) {
            if (el.getText().equals(phone)) {
                System.out.println("The phone number is found:" + el.getText());
                return true;
            }
        }
        return false;
    }

    public boolean elementIsFound(By locator) {
        List<WebElement> elements = wd.findElements(locator);
        if (elements.size() > 0) {
            System.out.println("The number of contacts is: "+elements.size());
            return true;
        } else return false;
    }
}
