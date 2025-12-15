package Promod_Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignmentWaits {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[text()=' User']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']"))).click();

//        driver.findElement(By.xpath("//button[text()='Okay']")).click();

        Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
        drop.selectByVisibleText("Consultant");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();


        //cart page
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//        Thread.sleep(5000);
//        String parent= driver.getWindowHandle();
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
//        Set<String> windows= driver.getWindowHandles();
//        for (String window: windows){
//            if (!window.equals(parent)){
//                driver.switchTo().window(window);
//            }
//        }
//        Alert alert= driver.switchTo().alert();
//        alert.accept();


        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".row h4 a"))));

        assert list != null;
        int j = 1;
        for (WebElement e : list) {

            driver.findElement(By.xpath("(//button[text()='Add '])[" + j + "]")).click();
            j++;
//            WebElement cartItem= driver.findElement(By.cssSelector("(.row h4 a)[i]"));
            System.out.println("Product" + e.getText() + " added to cart");
        }

        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();


    }


}

