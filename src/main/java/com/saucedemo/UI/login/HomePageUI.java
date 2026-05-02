package com.saucedemo.UI.login;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class HomePageUI extends PageObject {

    public static final Target BTN_LOGOUT_MENU = Target.the("Boton logout menu").located(By.id("react-burger-menu-btn"));

    public static final Target BTN_LOGOUT_OPTION = Target.the("Boton logout").located(By.id("logout_sidebar_link"));

    public static final Target LBL_LOGOUT_VALIDACION = Target.the("Label confirmar logout exitoso").located(By.xpath("//div[contains(text(),'Swag Labs')]"));

}
