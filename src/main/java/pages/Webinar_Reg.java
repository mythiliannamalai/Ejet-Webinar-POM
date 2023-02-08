package pages;

import basePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Webinar_Reg extends BaseClass {

    @FindBy(id="deftphnumber")
    WebElement txt_ph;
    @FindBy(id="deftemail")
    WebElement txt_email;
    @FindBy(id="deftusername")
    WebElement txt_uname;
    @FindBy(name="passoutYear")
    WebElement drop_passout;
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

    @FindBy(name="gradStream")
    WebElement dr_stream;
    @FindBy(xpath="//div[text()=' Engineering (CS/IT) ']")
    WebElement dr_Ecs;
    @FindBy(xpath="//div[text()=' Engineering (Non IT) ']")
    WebElement dr_Enon;
    @FindBy(xpath="//div[text()=' Masters (CS/IT) ']")
    WebElement dr_Mcs;
    @FindBy(xpath="//div[text()=' Masters (Non IT) ']")
    WebElement dr_Mnon;
    @FindBy(xpath="//div[text()=' Others (Non Engineering and Non MSc/MCA) ']")
    WebElement dr_other;
    @FindBy(xpath="//span[contains(text(),'ENTER ROOM')]")
    WebElement btn_room;

    public Webinar_Reg(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void phNumber(String ph) throws InterruptedException {
        txt_ph.sendKeys(ph);
        Thread.sleep(3000);
    }
    public void email(String emailid) throws InterruptedException {
        txt_email.sendKeys(emailid);
        Thread.sleep(3000);
    }
    public void fullname(String name) throws InterruptedException {
        txt_uname.sendKeys(name);
        Thread.sleep(3000);
    }
    public void passout(String pass) throws InterruptedException, AWTException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        drop_passout.click();
        Thread.sleep(3000);
        if (pass.equals("2023")) {
            d_2023.click();
        } else if (pass.equals("2022")) {
            d_2022.click();
        } else if (pass.equals("2021")) {
            d_2021.click();
        } else if (pass.equals("2024")) {
            d_2024.click();
        } else if (pass.equals("2020")) {
            d_2020.click();
        } else if (pass.equals("After 2024")) {
            d_A_2024.click();
        } else if (pass.equals("Before 2020")) {
            d_B_2020.click();
        } else if(pass.equals(" ")){

        }
    }
    public void eduction_qua(String education) throws InterruptedException {
        dr_stream.click();

        Thread.sleep(3000);
        if (education.equals("Engineering (CS/IT)")) {
            dr_Ecs.click();
        } else if (education.equals("Engineering (Non IT)")) {
            dr_Enon.click();
        } else if (education.equals("Masters (CS/IT)")) {
            dr_Mcs.click();
        } else if (education.equals("Masters (Non IT)")) {
            dr_Mnon.click();
        } else if (education.equals("Others (Non Engineering and Non MSc/MCA)")) {
            dr_other.click();
        }else if(education.equals(" ")){

        }

    }
    public void clickEnter() throws InterruptedException {
        btn_room.click();
        Thread.sleep(3000);
    }
    public void browserClose(){
        //driver.close();
    }
}
