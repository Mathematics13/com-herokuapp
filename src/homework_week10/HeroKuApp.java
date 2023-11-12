package homework_week10;

/** Project-3 - ProjectName : com-herokuapp
 BaseUrl = http://the-internet.herokuapp.com/login
 1. Setup chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Enter the email to email field.
 7. Enter the password to password field.
 8. Click on Login Button.
 9. Print the current url.
 10. Refresh the page.
 11. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

public class HeroKuApp
{
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static  WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.edge.driver" , "msedgedriver.exe");
        driver = new EdgeDriver();                                                            //launch the edge browser

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(4000);

        String title = driver.getTitle();
        System.out.println("Title of the page is : " +title);                             //Printing the title of the page

        String currenturl = driver.getCurrentUrl();
        System.out.println("Current URL is : " +currenturl );                           //Printing the current url

        String pageSource =  driver.getPageSource();
        System.out.println("Page Source is : " +pageSource);                           //Printing the page source
        Thread.sleep(4000);

        WebElement username = driver.findElement(By.id("username"));                 //Find, Locate
        username.sendKeys("tomsmith");                                  //Action
        Thread.sleep(4000);

        WebElement pwd =  driver.findElement(By.id("password"));                   //Find, Locate
        pwd.sendKeys("SuperSecretPassword!");                         //Action
        Thread.sleep(4000);

        WebElement login = driver.findElement(By.className("radius"));          //Find, Locate
        login.click();                                                         //Action
        Thread.sleep(4000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is : " +currentUrl );                //Printing the current url

        driver.navigate().refresh();                                        //Refreshing the page
        Thread.sleep(4000);

        driver.quit();                                                     //Close the browser
    }
}
