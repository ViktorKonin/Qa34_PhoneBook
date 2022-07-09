package tests;

import models.Contact;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            LoginTests.successLogin();
        }
    }

    @Test
    public void addNewContactSuccess() {
        Contact contact = Contact.builder()
                .name("Haim")
                .lastName("Goldfeder")
                .phone("111-222-333")
                .email("haim@gmail.com")
                .address("Haifa, Israel")
                .description("Friend")
                .build();

        app.contact().openAddContactForm();
        app.contact().fillAddContactForm(contact);
        app.contact().SaveContact();
    }

    @AfterMethod
    public void postCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }
}
