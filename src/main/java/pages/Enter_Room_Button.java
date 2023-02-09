package pages;

import basePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Enter_Room_Button extends BaseClass {
    @FindBy(xpath="//span[contains(text(),'ENTER ROOM')]")
    WebElement btn_room;

    public Enter_Room_Button(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean clickEnter() throws InterruptedException {
        boolean value = btn_room.isEnabled();
        btn_room.click();
        Thread.sleep(3000);
        return value;
    }


}
