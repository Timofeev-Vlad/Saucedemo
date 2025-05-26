package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;

import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.*;
import static utils.AllureUtils.takeScreenshot;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Timofeev Vlad vladikti@mail.ru")
    @TmsLink("IAFT4")
    @Issue("2")
    @Test(description = "Проверка авторизации")
    public void correctLogin() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());

        assertTrue(productsPage.titleisDisplayed());
        takeScreenshot(driver);
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void uncorrectLogin(String user, String pass, String errMsg) {
        loginPage.open()
                .fillLoginInput(user)
                .fillPasswordInput(pass)
                .clickSubmitBtn();
        assertEquals(loginPage.getErrorMsg(), errMsg);
    }
}
