package pages;

import basePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Full_Name_Field extends BaseClass {
    @FindBy(id="deftusername")
    WebElement txt_uname;
    @FindBy(id="deftuservalid")
    WebElement error;
    @FindBy(xpath="//p[text()='You must enter a Full Name']")
    WebElement username_err_msg1;
    @FindBy(xpath="//p[text()='First Name Min 3 character required']")
    WebElement username_err_msg2;
    @FindBy(xpath="//p[text()='Please enter first & last name (min. 3 letters each) separated by a space.']")
    WebElement username_err_msg3;
    @FindBy(xpath="//p[text()='Name must contain alphabetic only']")
    WebElement username_err_msg4;
    @FindBy(xpath="//p[text()='No space after fullname and character']")
    WebElement username_err_msg5;
    @FindBy(xpath="//p[text()='No space after first & last name']")
    WebElement username_err_msg6;

    public Full_Name_Field(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_fullname(String valid_name) throws InterruptedException {
        txt_uname.sendKeys(valid_name);
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=false;
        if (error_msg.equals("You must enter a Full Name")) {
            value= username_err_msg1.isDisplayed();
        } else if (error_msg.equals("First Name Min 3 character required")) {
            value= username_err_msg2.isDisplayed();
        } else if (error_msg.equals("Please enter first & last name (min. 3 letters each) separated by a space.")) {
            value= username_err_msg3.isDisplayed();
        } else if (error_msg.equals("Name must contain alphabetic only")) {
            value= username_err_msg4.isDisplayed();
        } else if (error_msg.equals("No space after fullname and character")) {
            value= username_err_msg5.isDisplayed();
        } else if (error_msg.equals("No space after first & last name")) {
            value= username_err_msg6.isDisplayed();
        }
        return value;
    }
    public boolean invalid_fullName(String invalid_name) throws InterruptedException {
        txt_uname.sendKeys(invalid_name);
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=false;
        if (error_msg.equals("First Name Min 3 character required")) {
            value= username_err_msg2.isDisplayed();
        } else if (error_msg.equals("Please enter first & last name (min. 3 letters each) separated by a space.")) {
            value= username_err_msg3.isDisplayed();
        } else if (error_msg.equals("Name must contain alphabetic only")) {
            value= username_err_msg4.isDisplayed();
        } else if (error_msg.equals("No space after fullname and character")) {
            value= username_err_msg5.isDisplayed();
        } else if (error_msg.equals("No space after first & last name")) {
            value= username_err_msg6.isDisplayed();
        }
        return value;
    }
    public boolean removing_value_from_fullNameField(String name) throws InterruptedException {
        txt_uname.sendKeys(name);
        Thread.sleep(3000);
        txt_uname.clear();
        String error_msg=error.getText();
        boolean  value= username_err_msg1.isDisplayed();
        return value;
    }


}
