package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
        int i = (int)System.currentTimeMillis()/1000;
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("viktor"+i+"@gmail.com", "Vviktor12345$");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void registrationSuccessUser(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().setEmail("roy"+i+"@gmail.com").setPassword("Vviktor12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void registrationNegativeTestWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("viktorgmail.com", "Vviktor12345$");
        app.getHelperUser().submitRegistration();
        //6 Assert(is login unsuccessful?) login present? NOT
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorFormatDisplayed());

    }


}
