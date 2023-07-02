package Bindings;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    JavascriptExecutor js;
    ChromeOptions option;

    @Before
    public void initialization(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jovan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        option = new ChromeOptions();
        option.addArguments("--window-size-1366,656");
        //option.addArguments("headless");
        option.setExperimentalOption("useAutomationExtension", false);
        option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(option);
        action = new Actions(driver);
        wait = new WebDriverWait(driver,30);
        js = (JavascriptExecutor) driver;
    }
    @After
    public void Exit() {
        driver.quit();

    }

    @Given("^login page$")
    public void login_page(){
        // Write code here that turns the phrase above into concrete action
        //System.out.println("Step 1");
        driver.get("https://www.linkedin.com/");
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    @When("^page loads$")
    public void page_loads(){
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("Step 2");
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("Password");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.xpath("//a[text()='Join now']")).isDisplayed();
    }

    @Then("^close driver$")
    public void close_driver(){
        // Write code here that turns the phrase above into concrete actions
        //System.out.println("Step 3");
        driver.quit();
    }

    @Given("navigate to  google and search for jobstoday.world")
    public void navigate_to_google_and_search_for_jobstodayworld(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("jobstoday.world");
        driver.findElement(By.name("btnK")).click();
    }

    @And("open jobstoday.world website")
    public void open_jobs_today_world_website() throws InterruptedException {
        WebElement jobstoday_link = driver.findElement(By.xpath("//a[@href='https://www.jobstoday.world/']"));
        wait.until(ExpectedConditions.elementToBeClickable(jobstoday_link));
        driver.findElement(By.xpath("//a[@href='https://www.jobstoday.world/']")).click();
        Thread.sleep(1000);
    }

    @When("^click on Search Button (\\d+) times$")
    public void click_on_search_5_time(int repeat_times) throws InterruptedException {
        WebElement Search_1 = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        wait.until(ExpectedConditions.elementToBeClickable(Search_1));
        Search_1.click();
        Thread.sleep(30000);
        WebElement Search_Button = driver.findElement(By.xpath("//button[contains(@class,'b-search-options__main-form-btn')]"));
        System.out.println("Press 1");
        for(int i = 2;i<=repeat_times;i++) {
            wait.until(ExpectedConditions.elementToBeClickable(Search_Button));
            Search_Button.click();
            System.out.println("Press " + i);
            Thread.sleep(30000);
            js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
        }
    }

    @Given("open google with search restuls for jobstoday.world")
    public void open_google_with_search_restuls_for_jobstoday_world() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.google.com/search?source=hp&ei=T_lUX6rtB8-maMiErsAM&q=jobstoday.world&oq=jobstoday.world&gs_lcp=CgZwc3ktYWIQAzICCAA6DggAEOoCELQCEJoBEOUCOggILhCxAxCTAjoCCC46BQgAELEDOgUIABCSAzoICC4QxwEQowI6BQguELEDOggILhCxAxCDAToICAAQsQMQgwE6CwguELEDEMcBEKMCOggILhDHARCvAToECAAQCjoGCAAQChAeOgQIABAeOgYIABAIEB46CAgAEAgQChAeULEUWOomYPEmaAFwAHgCgAFMiAGTBJIBAjE0mAEAoAEBqgEHZ3dzLXdperABBg&sclient=psy-ab&ved=0ahUKEwjq0J7J5dTrAhVPExoKHUiCC8gQ4dUDCAk&uact=5");
        driver.manage().window().maximize();
    }

    @Given("Start Browser with jobstoday.world website")
    public void start_browser_with_jobstoday_world_website() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.jobstoday.world/");
        driver.manage().window().maximize();
    }


    @Given("Start Browser with google.com")
    public void startBrowserWithGoogleCom() {
        driver.get("https://www.google.com");
    }

    @When("click on Search Button {int} time")
    public void clickOnSearchButtonTime(int arg0) {
        WebElement searchInput = driver.findElement(By.id("APjFqb"));
        searchInput.sendKeys("Jiu jitsu");
        searchInput.submit();
    }

    @Then("click on Search Button")
    public void clickOnSearchButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();


    }


    @Given("go to web page")
    public void goToWebPage() {
        driver.get("https://www.facebook.com/");
    }

    @When("pass user name and pass")
    public void passUserNameAndPass() {
        WebElement nameInput = driver.findElement(By.id("email"));
        nameInput.sendKeys("jovandiclazar@yahoo.com");
        WebElement surnameInput = driver.findElement(By.id("pass"));
        surnameInput.sendKeys("nemanmejede2");

    }

    @Then("click on Login")
    public void clickOnLogin() {
        driver.findElement(By.className("_sv4")).isDisplayed();
    }
}

