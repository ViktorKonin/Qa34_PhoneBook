package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{





    //success login
    @Test
    public void successLogin() {
        //3 open form
        openLoginRegistrationForm();
        //4 fill form + valid data
        //fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");
        //5 submit login
        submitLogin();
        //6 Assert(is login success?)

    }


    //login negative
    @Test
    public void loginNegativeTestWrongEmail() {
        //3 open form
        openLoginRegistrationForm();
        //4 fill form + invalid data
        fillLoginRegistrationForm("noagmail.com","Nnoa12345$");
        //5 submit login
        submitLogin();
        //6 Assert(is login unsuccessful?) login present? NOT

    }




}
