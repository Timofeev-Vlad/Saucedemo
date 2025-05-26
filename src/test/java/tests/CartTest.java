package tests;

import org.testng.annotations.Test;
import user.UserFactory;

public class CartTest extends BaseTest {
    @Test()
    public void deleteThreeGoods() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());
        productsPage.addToCart(0)
                .addToCart(2)
                .addToCart(1)
                .openCart();
        for (int i = 0; i < 3; i++) {
            cartPage.remove();
        }
    }
}
