package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void saveContact() {
       click(By.xpath("//b[text()='Save']"));
       wd.findElement(By.xpath("//*[@placeholder='description']")).sendKeys(Keys.TAB);
       // wd.findElement(By.cssSelector(".add_form__2rsm button")).sendKeys(Keys.ENTER);
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



    public int removeOneContact() {
        //count before
        int countBefore = countOfContacts();
        logger.info("Count before remove is"+countBefore);
        if (!isContactListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//*[text()='Remove']"));
            pause(500);
        }
        //count after
        int countAfter = countOfContacts();
        return countBefore - countAfter;
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public boolean isContactListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void removeAllContacts() {
        while (countOfContacts()!=0){
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
    }

    public boolean isNoContactsHere() {
        return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement
                        (wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")), "No Contacts here!"));
    }

    public void providerContactData() {
        Random random = new Random();
        if (countOfContacts() < 4) {
            for (int i = 0; i < 3; i++) {
                int index = random.nextInt(100) + 100;
                openAddContactForm();
                pause(500);
                fillAddContactForm(Contact.builder()
                        .name("Haim"+index)
                        .lastName("Goldfeder")
                        .phone("111-22"+index)
                        .email("haim@gmail.com")
                        .address("Haifa, Israel")
                        .description("Friend")
                        .build());
                saveContact();
                pause(500);
            }
        }
    }
}
