package pages;

import basePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class PassOut_Field extends BaseClass {

    @FindBy(name="passoutYear")
    WebElement drop_passout;
    @FindBy(xpath="//p[text()='Year Required']")
    WebElement error;
    @FindBy(xpath="//div[@value='2023']")
    WebElement d_2023;
    @FindBy(xpath="//div[@value='2022']")
    WebElement d_2022;
    @FindBy(xpath="//div[@value='2021']")
    WebElement d_2021;
    @FindBy(xpath="//div[@value='2020']")
    WebElement d_2020;
    @FindBy(xpath="//div[@value='2024']")
    WebElement d_2024;
    @FindBy(xpath="//div[@value='Before 2020']")
    WebElement d_B_2020;
    @FindBy(xpath="//div[@value='After 2024']")
    WebElement d_A_2024;

    public PassOut_Field(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String passout(String pass) throws InterruptedException, AWTException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        drop_passout.click();
        Thread.sleep(3000);
        String value = null;
        if (pass.equals("2023")) {
            value=d_2023.getText();
           d_2023.click();
        } else if (pass.equals("2022")) {
            value=d_2022.getText();
            d_2022.click();
        } else if (pass.equals("2021")) {
            value=d_2021.getText();
            d_2021.click();
        } else if (pass.equals("2024")) {
            value=d_2024.getText();
            d_2024.click();
        } else if (pass.equals("2020")) {
            value=d_2020.getText();
            d_2020.click();
        } else if (pass.equals("After 2024")) {
            value=d_A_2024.getText();
            d_A_2024.click();
        } else if (pass.equals("Before 2020")) {
            value=d_B_2020.getText();
            d_B_2020.click();
        }
        return value;
    }
    public String empty_Value() throws AWTException, InterruptedException {
            Robot robot=new Robot();
            robot.mouseWheel(5);
            Thread.sleep(3000);
            drop_passout.click();
            Thread.sleep(3000);
            String value =error.getText();
            return value;
        }
}
