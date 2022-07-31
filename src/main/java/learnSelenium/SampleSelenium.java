package learnSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SampleSelenium {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://ultimateqa.com/automation");
        String title = driver.getTitle();
        System.out.println(title);
        String labelValue = driver.findElement(By.xpath("//span[contains(text(),'Get Latest Blog Posts')]")).getText();
        System.out.println(labelValue);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("74855696521");
        String valuestext=email.getAttribute("value");
       String type= email.getAttribute("type");
       String placeholder= email.getAttribute("placeholder");

       System.out.println(valuestext+ ": text value: " +type+ ": texttype : " +placeholder+ "text placeholder" );




    }
}
