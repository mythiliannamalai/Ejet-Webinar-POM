package TestPackage;

import basePackage.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Webinar_Reg;
import utility.UtilityClass;

import java.awt.*;
import java.io.IOException;

public class Test_Webinar extends BaseClass {
    Webinar_Reg reg;
    UtilityClass util;
    public String sheetName = "UserDetails";

    public Test_Webinar() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        reg = new Webinar_Reg(driver);
        util = new UtilityClass();
    }

    @Test
    public void new_User_Regester_ValidData() throws InterruptedException, AWTException {
        reg.phNumber(prop.getProperty("PhoneNumber"));
        reg.email(prop.getProperty("email_Id"));
        reg.fullname(prop.getProperty("full_Name"));
        reg.passout(prop.getProperty("Year_Of_Passout"));
        reg.eduction_qua(prop.getProperty("Education_Qualification"));
        reg.clickEnter();
    }
    @Test
    public void new_User_Regester_InValidData() throws InterruptedException, AWTException {
        reg.phNumber(prop.getProperty("invalid_ph"));
        reg.email(prop.getProperty("invalid_email_Id"));
        reg.fullname(prop.getProperty("invalid_full_Name"));
        reg.passout(prop.getProperty("Year_Of_Passout"));
        reg.eduction_qua(prop.getProperty("Education_Qualification"));
        reg.clickEnter();
    }

    @Test
    public void new_User_Regester_WithoutData() throws InterruptedException, AWTException {
        reg.phNumber(" ");
        reg.email(" ");
        reg.fullname(" ");
        reg.passout(" ");
        reg.eduction_qua(" ");
        reg.clickEnter();
    }

    @Test
    public void regestered_User_Landing_WebinarPage() throws InterruptedException, AWTException {
        reg.phNumber(prop.getProperty("regNum"));
        reg.clickEnter();
    }
    @DataProvider
    public Object[][] getUserData() throws IOException {
        Object data[][] = util.dataReader(sheetName);
       return data;
    }
    @Test(dataProvider = "getUserData")
    public void new_User_reg_Multi_User(String ph,String emailid,String name,String passout, String edu) throws InterruptedException, AWTException {
        reg.phNumber(ph);
        reg.email(emailid);
        reg.fullname(name);
        reg.passout(passout);
        reg.eduction_qua(edu);
        reg.clickEnter();
    }


    @AfterMethod
    public void tearDown(){
       reg.browserClose();
    }

}
