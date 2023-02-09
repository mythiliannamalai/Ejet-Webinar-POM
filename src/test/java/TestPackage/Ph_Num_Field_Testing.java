package TestPackage;

import basePackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Ph_Num_Field;

import java.awt.*;
import java.io.IOException;

public class Ph_Num_Field_Testing extends BaseClass {

    Ph_Num_Field ph;

    public Ph_Num_Field_Testing() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        ph = new Ph_Num_Field(driver);
    }
    @Test
    public void new_User_Enter_With_ValidData() throws InterruptedException, AWTException {
        boolean ph_tick_icon = ph.phNumber(prop.getProperty("PhoneNumber"));
        Assert.assertTrue(ph_tick_icon);
    }
    @Test
    public void new_User_Enter_EmptyString_PhField() throws InterruptedException {
        boolean msg=ph.inValidPhNumber(" ");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_Enter_SpecialChar_PhField() throws InterruptedException {
        boolean msg=ph.inValidPhNumber("$");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_Enter_Char_PhField() throws InterruptedException {
        boolean msg=ph.inValidPhNumber("abc");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_Enter_Space_between_PhNum() throws InterruptedException {
        boolean msg=ph.inValidPhNumber("97904 8650");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_Enter_plus_NinetyOne() throws InterruptedException {
        boolean msg=ph.inValidPhNumber("+919790486");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_Enter_plus_NinetyOne_And_Hyphen() throws InterruptedException {
        boolean msg=ph.inValidPhNumber("+91-979048");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test
    public void new_User_AfterEnterData_removeData_FormField_PhField() throws InterruptedException {
        boolean msg=ph.user_Remove_PhNum_From_PhField("97904865");
        System.out.println(msg);
        Assert.assertTrue(msg,"Phone Number Required");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
