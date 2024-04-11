package steps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import setup.StartStopServer;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Steps extends StartStopServer {

    @Before("@setUp")
    public void setup(){
        runServer();
    }

    @After("@setUp")
    public void stop(){
        tearDown();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String page) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + page + "\")")).isDisplayed();
    }

    @When("User clicks {string} button")
    public void user_click_button(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).click();
    }

    @And("User clicks sort by button")
    public void user_clicks_sort_by_button()
    { driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().description(\"sort button\")")).click();
    }

    @Then("First product title is {string}")
    public void first_product_title_is(String title) {
        String element = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).get(0).getText();
        assertEquals(element, title);
    }


    @Given("User is on Products page")
    public void userIsOnProductsPage() {    driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Products\")")).isDisplayed();
    }


    @When("User clicks menu button")
    public void userClicksMenuButton() throws InterruptedException { driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
        Thread.sleep(1000);
    }

    @Then("Log In button is visible")
    public void logInButtonIsVisible() {
        WebElement LogInButtonIsVisible= driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")"));
        assertEquals("Log In", LogInButtonIsVisible.getText());
    }


    @When("User clicks Log In button")
    public void userClicksLogInButton()
    {driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).click();
    }


    @Then("User is on Login page")
    public void userIsOnLoginPage() {
        WebElement loginPageIsDisplayed = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Password\").instance(0)"));
        assertEquals("Password", loginPageIsDisplayed.getText());
    }

    @When("user enters valid Username")
    public void userEntersValidUsername()
    {driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().description(\"Username input field\")")).sendKeys("bob@example.com");
    }

    @And("user enters valid Password")
    public void userEntersValidPassword()
    {driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().description(\"Password input field\")")).sendKeys("10203040");
    }

    @And("user clicks Login button")
    public void userClicksLoginButton()
    {driver.findElement(AppiumBy.androidUIAutomator(
            "new UiSelector().description(\"Login button\")")).click();
    }

    @Then("user is navigated to Products page")
    public void userSuccessfullyLogsInAndIsOnProductsPage() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Products\")")).isDisplayed();
    }

    @When("user enters not valid Username or not valid Password")
    public void userEntersNotValidUsernameOrNotValidPassword() {
        {driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Username input field\")")).sendKeys("bobas.com");
            {driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Password input field\")")).sendKeys("10203040");
            }}
    }

    @Then("user gets error message “Provided credentials do not match any user in this service“")
    public void userGetsErrorMessageWhenTryingLogin() {
      WebElement errorWithLogin=  driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Provided credentials do not match any user in this service.\")"));
        assertEquals("Provided credentials do not match any user in this service.", errorWithLogin.getText());
    }

    @When("user enters locked out user credentials")
    public void userEntersLockedOutUserCredentials() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"alice@example.com (locked out)\")")).click();
    }

    @Then("user gets error message “Sorry, this user has been locked out.“")
    public void userGetsErrorMessageSorryThisUserHasBeenLockedOut() {
        WebElement errorMessage = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Sorry, this user has been locked out.\")"));
        assertEquals("Sorry, this user has been locked out.", errorMessage.getText());
    }

    @Then("menu option “Log Out“ is visible")
    public void menuOptionLogOutIsVisible() {
        WebElement menuLogOutIsDisplayed= driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Log Out\")"));
        assertEquals("Log Out", menuLogOutIsDisplayed.getText());
    }

    @When("user clicks “Log Out“")
    public void userClicksLogOut() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(
                "text(\"Log Out\")")).click();
        Thread.sleep(2000);
    }

    @Then("popup with a message “Are you sure you want to logout?“ appears")
    public void popupWithAMessageAreYouSureYouSureYouWantToLogoutAppears() {
        WebElement popupMessageAppears= driver.findElement(AppiumBy.id("android:id/message"));
        assertEquals("Are you sure you sure you want to logout?", popupMessageAppears.getText());
    }

    @When("user clicks in “Log out“ screen \"Log Out\" button")
    public void userClicksLogOutButtonOnLogOutScreen() {
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Then("popup with a message “You are successfully logged out “")
    public void popupWithAMessageYouAreSuccessfullyLoggedOut() {
        WebElement popupMessageAppears = driver.findElement(AppiumBy.id("android:id/alertTitle"));
        assertEquals("You are successfully logged out.", popupMessageAppears.getText());
    }

    @When("user clicks “OK“")
    public void userClicksOK() {
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Then("Message popup closes")
    public void messagePopupCloses() {
        WebElement loginPageIsDisplayed = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Password\").instance(0)"));
        assertEquals("Password", loginPageIsDisplayed.getText());
    }

    @When("user clicks “Cancel“")
    public void userClicksCancel() {
        driver.findElement(AppiumBy.id("android:id/button2")).click();
    }

    @Then("popup closes")
    public void popupCloses() {
        WebElement logInButtonIsVisible= driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")"));
        assertEquals("Log In", logInButtonIsVisible.getText());
    }

    @And("user is still logged in")
    public void userIsStillLoggedIn() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).click();
        Thread.sleep(1000);
        WebElement userIsOnLoginPageAndNoItemsIsDisplayed = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"No Items\")"));
        assertEquals("No Items", userIsOnLoginPageAndNoItemsIsDisplayed.getText());

    }

    @Given("User is on the checkout page")
    public void userIsOnTheCheckoutPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Proceed To Checkout button")).click();

    }

    @When("User fills in shipping address fields")
    public void userFillsInShippingAddressFields() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Rebecca Winter");
        driver.findElement(AppiumBy.accessibilityId("Address Line 1* input field")).sendKeys("Mandorley 112");

        Thread.sleep(500);
        WebElement scrollElement = driver.findElement(AppiumBy.androidUIAutomator(
                "className(\"android.widget.ScrollView\").scrollable(true)"));
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement) scrollElement).getId(),
                        "direction", "down",
                        "percent", 1
        ));

        driver.findElement(AppiumBy.accessibilityId("City* input field")).sendKeys("Truro");
        driver.findElement(AppiumBy.accessibilityId("State/Region input field")).sendKeys("Cornwall");
        driver.findElement(AppiumBy.accessibilityId("Zip Code* input field")).sendKeys("89750");
        driver.findElement(AppiumBy.accessibilityId("Country* input field")).sendKeys("United Kingdom");
    }

    @And("clicks 'To Payment' button")
    public void clicksToPaymentButton() {
        driver.findElement(AppiumBy.accessibilityId("To Payment button")).click();
    }

    @Then("User is navigated to the payment method window")
    public void userIsNavigatedToThePaymentMethodWindow() throws InterruptedException {
        Thread.sleep(1000);
        WebElement paymentMethodIsDisplayed = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Enter a payment method\")"));
        assertEquals("Enter a payment method", paymentMethodIsDisplayed.getText());
    }

    @Given("user is on the checkout page after successfully login")
    public void userIsOnTheCheckoutPageAfterSuccessfullyLogin() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\").instance(0)")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Username input field\")")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Password input field\")")).sendKeys("10203040");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"Login button\")")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Proceed To Checkout button")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Rebecca Winter");
        driver.findElement(AppiumBy.accessibilityId("Address Line 1* input field")).sendKeys("Mandorley 112");
        Thread.sleep(500);
        WebElement scrollElement = driver.findElement(AppiumBy.androidUIAutomator(
                "className(\"android.widget.ScrollView\").scrollable(true)"));
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement) scrollElement).getId(),
                "direction", "down",
                "percent", 1
        ));

        driver.findElement(AppiumBy.accessibilityId("City* input field")).sendKeys("Truro");
        driver.findElement(AppiumBy.accessibilityId("State/Region input field")).sendKeys("Cornwall");
        driver.findElement(AppiumBy.accessibilityId("Zip Code* input field")).sendKeys("89750");
        driver.findElement(AppiumBy.accessibilityId("Country* input field")).sendKeys("United Kingdom");

        driver.findElement(AppiumBy.accessibilityId("To Payment button")).click();
    }

    @Given("user is on the payment method window")
    public void userIsOnThePaymentMethodWindow() {
        WebElement checkTextPaymentMethod = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Enter a payment method\")"));
        assertEquals("Enter a payment method", checkTextPaymentMethod.getText());
    }

    @When("user fills all payment method fields")
    public void userFillsAllPaymentMethodFields() {
        driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Rebecca Winter");
        driver.findElement(AppiumBy.accessibilityId("Card Number* input field")).sendKeys("3258 1265 7568 789");
        driver.findElement(AppiumBy.accessibilityId("Expiration Date* input field")).sendKeys("0325");
        driver.findElement(AppiumBy.accessibilityId("Security Code* input field")).sendKeys("123");
    }

    @And("clicks the 'Review Order' button")
    public void clicksTheReviewOrderButton() {
        driver.findElement(AppiumBy.accessibilityId("Review Order button")).click();
    }

    @Then("user is navigated to the review order page")
    public void userIsNavigatedToTheReviewOrderPage() {
        WebElement checkTextReviewYourOrderIsDisplayed = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Review your order\")"));
        assertEquals("Review your order", checkTextReviewYourOrderIsDisplayed.getText());
    }
}
