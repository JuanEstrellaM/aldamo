package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void addCustomers () {
        By offFocus = By.xpath("//*[@id=\"admin\"]/a/span");
        new Actions(driver).moveToElement(driver.findElement(offFocus)).perform();
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id=\"admin\"]/ul/li[8]/a"))).perform();
        driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]/ul/li[8]/ul/li[1]/a/span")).click();
        for (int i = 0; i < 10; i++){
            addOne(i);
        }
    }

    public void addOne(int i) {
        driver.navigate().to("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/admin/viewCustomers");
        driver.findElement(By.className("plainbtn")).click();
        driver.findElement(By.id("addCustomer_customerName")).clear();
        driver.findElement(By.id("addCustomer_customerName")).sendKeys("Encabezado simple"+i);
        driver.findElement(By.id("addCustomer_description")).clear();
        driver.findElement(By.id("addCustomer_description")).sendKeys("No automatizo en java algun tiempo, " +
                "en Python o Js mi desempeno es muchisimo mejor jaja....");
        driver.findElement(By.id("btnSave")).click();

    }

    public void readCsvFile(String ruta) {

    }
}
