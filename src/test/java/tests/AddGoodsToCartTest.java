package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.assertEquals;

public class AddGoodsToCartTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Timofeev Vlad vladikti@mail.ru")
    @TmsLink("IAFT4")
    @Issue("2")
    @Test(description = "Проверяем, что товары добавлены в корзину")
    public void addThreeGoods() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());
        productsPage.addToCart(0)
                .addToCart(2)
                .addToCart(1)
                .openCart();
        assertEquals(cartPage.getProductsNames().size(), 3);
    }
}
