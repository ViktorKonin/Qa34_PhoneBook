package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("viktor@gmail.com").setPassword("Vviktor12345$"));
        }
        app.contact().providerContactData();
    }

    @Test
    public void removeOneContactSuccess() {
        //count before
        Assert.assertEquals(app.contact().removeOneContact(), 1);
        //count after
        //Assert before-after=1
    }

    @Test
    public void removeAllContactsSuccess() {
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isNoContactsHere());
    }

}
