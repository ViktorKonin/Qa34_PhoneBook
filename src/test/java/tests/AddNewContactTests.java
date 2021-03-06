package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("viktor@gmail.com").setPassword("Vviktor12345$"));
        }
    }

    @Test(invocationCount = 1)
    public void addNewContactSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Haim"+i)
                .lastName("Goldfeder")
                .phone("111-22"+i)
                .email("haim@gmail.com")
                .address("Haifa, Israel")
                .description("Friend")
                .build();
        System.out.println(contact);

        app.contact().openAddContactForm();
        app.contact().fillAddContactForm(contact);
        app.contact().saveContact();

        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactAddedByPhone(contact.getPhone()));
    }


}
