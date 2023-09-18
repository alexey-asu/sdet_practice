import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQATest {
    @Test
    public void eightComponents() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String title = driver.getTitle();
        assertEquals("DEMOQA", title);


        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("johndoe@example.com");

        WebElement gender = driver.findElement(By.id("gender-radio-1"));
        executor.executeScript("arguments[0].click();", gender);

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("1234567890");

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        monthDropdown.sendKeys("January");
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        yearDropdown.sendKeys("1990");
        WebElement dayButton = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--002']"));
        dayButton.click();

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("1234 Main St");

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("English");
        subjects.sendKeys(Keys.ENTER);

        WebElement hobbies=driver.findElement(By.id("hobbies-checkbox-1"));
        executor.executeScript("arguments[0].click();", hobbies);

        WebElement state=driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);


        WebElement city=driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        WebElement uploadpicture=driver.findElement(By.id("uploadPicture"));
        String currentdir=System.getProperty("user.dir");
        uploadpicture.sendKeys(currentdir + "/src/test/resources/Les_Horribles_Cernettes.jpg");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        executor.executeScript("arguments[0].click()", submitButton);

        WebElement successMessage = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String value = successMessage.getText();
        assertEquals("Thanks for submitting the form", value);


        driver.quit();
        driver.quit();
    }
}
