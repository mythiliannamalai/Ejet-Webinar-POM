package TestPackage;

import basePackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Enter_Room_Button;

import java.awt.*;
import java.io.IOException;

public class Enter_Room_Test extends BaseClass {
    Enter_Room_Button enterRoom;

    public Enter_Room_Test() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        enterRoom = new Enter_Room_Button(driver);
    }
    @Test
    public void click_EnterButton() throws InterruptedException, AWTException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        boolean msg = enterRoom.clickEnter();
        Assert.assertTrue(msg);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
