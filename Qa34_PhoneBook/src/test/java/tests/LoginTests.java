package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
    if(app.getHelperUser().isLogged()){
        app.getHelperUser().logout();
    }
    }

    @Test
    public void successLogin() {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("viktor@gmail.com", "Vviktor12345$");
        app.getHelperUser().submitLogin();
        //6 Assert(is login success?)
        Assert.assertTrue(app.getHelperUser().isLogged());

    }


    @Test
    public void loginNegativeTestWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noagmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        //6 Assert(is login unsuccessful?) login present? NOT
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorFormatDisplayed());
        //sdsdsds
    }


}
