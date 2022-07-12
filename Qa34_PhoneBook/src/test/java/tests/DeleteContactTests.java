package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("viktor@gmail.com").setPassword("Vviktor12345$"));
        }
    }


    @Test
    public void deleteAllContacts() {
        app.contact().click(By.xpath("//*[@href='/contacts']"));
        while (app.contact().elementIsFound(By.cssSelector("h3"))) {
            app.contact().click(By.cssSelector("h3"));
            app.contact().pause(500);
            app.contact().click(By.xpath("//*[text()='Remove']"));
            app.contact().pause(500);
            System.out.println("1 is deleted");
        }
        Assert.assertFalse(app.contact().elementIsFound(By.cssSelector("h3")));

    }
}
