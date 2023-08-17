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
import org.openqa.selenium.support.ui.Select;
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

    @Given("go to site")
    public void goToSite() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("enter user name")
    public void enterUserName() {
        WebElement nameInput = driver.findElement(By.id("user-name"));
        nameInput.sendKeys("standard_user");

    }

    @And("enter password")
    public void enterPassword() {
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.sendKeys("secret_sauce");
    }

    @Then("click on Login button")
    public void clickOnLoginButton() {
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Given("land on amazon page")
    public void landOnAmazonPage() {
        String webPage = "https://www.google.com/";
        driver.get(webPage);
        driver.manage().window().maximize();
    }

    @When("click on the cart")
    public void clickOnTheCart() {
        WebElement cart = driver.findElement(By.className("goxjub"));
        cart.click();
    }

    @Then("go back to home page")
    public void goBackToHomePage() {
        driver.navigate().back();
    }

    @Given("open web page")
    public void openWebPage() {
        String page = "https://github.com/";
        driver.get(page);
    }

    @And("maximize browser")
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @When("click on the element")
    public void clickOnTheElement() {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/a"));
        element.click();
    }

    @And("go backward")
    public void goBackward() {
        driver.navigate().back();
    }

    @Then("go forward")
    public void goForward() {
        driver.navigate().forward();
    }

    @And("refresh page")
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Given("open google")
    public void openGoogle() {
        driver.get("https://www.google.rs/");
    }

    @When("enter something in the search box")
    public void enterSomethingInTheSearchBox() {
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Last minute summer offers");
    }

    @Then("delete text")
    public void deleteText() {
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.clear();
    }

    @And("go back")
    public void goBack() {
        WebElement searchCTA = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]"));
        searchCTA.click();
        driver.navigate().back();
    }

    @Given("land on the site and maximaze window")
    public void landOnTheSiteAndMaximazeWindow() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @When("select section")
    public void selectSection() {
        WebElement elementsSection = driver.findElement(By.className("card-up"));
        elementsSection.click();
    }

    @And("select check box section")
    public void selectCheckBoxSection() {
        WebElement checkBoxSection = driver.findElement(By.id("item-1"));
        checkBoxSection.click();
    }

    @Then("mark home check box")
    public void markHomeCheckBox() {
        WebElement home = driver.findElement(By.className("rct-title"));
        home.click();

    }

    @Given("go to URL")
    public void goToURL() {
        String appURL = "https://www.cheapflights.com/";
        driver.get(appURL);
        WebDriverWait wait = new WebDriverWait(driver,2);
    }

    @When("check is round trip displayed")
    public void checkIsRoundTripDisplayed() {
        WebElement roundTrip = driver.findElement(By.className("H3mQ-input"));
        if (roundTrip.isDisplayed()){
            System.out.println("Button is displayed");
        }
        else {
            System.out.println("Button is not displayed");
        }
    }

    @Then("select Round trip")
    public void selectRoundTrip() {
        WebElement roundTrip = driver.findElement(By.className("H3mQ-input"));
        roundTrip.click();
    }

    @When("check one way radio button")
    public void checkOneWayRadioButton() {
        WebElement oneWay = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/div[1]/div[1]/div/div[3]/div/div/label[2]/span[2]"));
        if (oneWay.isDisplayed()){
            oneWay.click();
        }
        else {
            System.out.println("Button is broken");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("select one way radio button")
    public void selectOneWayRadioButton() {
        driver.navigate().refresh();
    }


    @Given("land on the login page")
    public void landOnTheLoginPage() {
        driver.get("https://dev.national.nonprod.oat.tms.aws.toyota.com/");
    }

    @When("insert credentials")
    public void insertCredentials() {
        WebElement account190 = driver.findElement(By.xpath("//*[@id=tilesHolder]/div[2]/div/div[1]/div/div[2]"));
        account190.click();
//*[@id="tilesHolder"]/div[2]/div/div[1]/div/div[2]
    }

    @Then("log in")
    public void logIn() {
        WebElement signIn = driver.findElement(By.xpath("//*[@id=idSIButton9"));
        signIn.click();
        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        driver.navigate().refresh();
    }

    @Given("get page")
    public void getPage() {
        driver.get("https://smoothcomp.com/en");
    }

    @When("select dropdown")
    public void selectDropdown() {
        WebElement dropdownAbout = driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[2]/a"));
        dropdownAbout.click();
        WebElement option = driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul[1]/li[2]/ul/li[3]/a"));
        option.click();

    }

    @Then("choose dropdown option")
    public void chooseDropdownOption() {
        driver.navigate().back();
        WebDriverWait wait1 = new WebDriverWait(driver,3);
    }

    @Given("web site landing")
    public void webSiteLanding() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        WebElement joinNow = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/a/img"));
        joinNow.click();
    }

    @When("check expacted text")
    public void checkExpactedText() {
        WebElement titleValidation = driver.findElement(By.className("enroll__heading"));
        String expectedText = "Selenium Certification Training | Enroll Now | Study Online";
        String actualText = titleValidation.getText();
        if(actualText.equals(expectedText)){
            System.out.println("Perfect, text is: " + expectedText);
        }
        else {
            System.out.println("Hmm, this: " + actualText + "is displayed");
        }
    }

    @Then("get home page")
    public void getHomePage() {
        driver.get("https://demoqa.com/");
    }

    @Given("get to buyatoyota.com")
    public void getToBuyatoyotaCom() {
        String appURL = "https://www.buyatoyota.com/home";
        driver.get(appURL);
    }

    @When("see offers")
    public void seeOffers() {
       WebElement seeOffers = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/section/div/div/div/div/div[2]/div/div/div[1]/div/div/div/a[1]"));
       seeOffers.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        //*[@id="root"]/div/div[2]/div/section/div/div/div/div/div[2]/div/div/div[1]/div/div/div/a[1]
    }

    @Then("enter zip code and wait for dealer")
    public void enterZipCodeAndWaitForDealer() {
        WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div[4]/div/div[1]/section/form/div[1]/div/div/input"));
        zipCode.click();
        zipCode.sendKeys("90002");

    }

    @And("find dealer")
    public void findDealer() {
        WebElement find = driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div[4]/div/div[1]/section/form/div[2]/button"));
        find.click();
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @Given("web page")
    public void webPage() {
        driver.get("https://www.buyatoyota.com/home");

    }

    @When("request a quote")
    public void requestAQuote() {
        WebElement requestQuote = driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/nav/div[2]/div/div[2]/ul/li[5]/a/span"));
        requestQuote.click();
        driver.manage().window().maximize(); 
    }

    @Then("validate text")
    public void validateText() {
        WebElement validationText = driver.findElement(By.className("fs67XEFk"));
        String actualText = validationText.getText();
        String expectedText = "Request A Quot";
        if (actualText.equals(expectedText)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

    }

    @Given("land on dev.reg")
    public void landOnDevReg() {
        driver.get("https://dev.regional.nonprod.oat.tms.aws.toyota.com/");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("i0116")));
    }

    @When("send user and pass")
    public void sendUserAndPass() {
        WebElement user = driver.findElement(By.id("i0116"));
        user.sendKeys("Region_190_User@digiscloud.com ");
        WebElement next = driver.findElement(By.id("idSIButton9"));
        next.click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("i0118")));
        WebElement pass = driver.findElement(By.id("i0118"));
        pass.sendKeys("!190Region!!");

    }

    @Then("log in succes")
    public void logInSucces() {
        WebElement signIn = driver.findElement(By.id("idSIButton9"));
        signIn.click();

    }

}
