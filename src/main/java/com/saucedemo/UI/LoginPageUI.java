package com.saucedemo.UI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class LoginPageUI {

    public static final Target INPUT_TEXT_USERNAME = Target.the("Input texto username").located(By.id("user-name"));

    public static final Target INPUT_TEXT_PASSWORD = Target.the("Input texto password").located(By.id("password"));

    public static final Target BTN_LOGIN = Target.the("Boton log in").located(By.id("login-button"));

    public static final Target LBL_LOGIN_VALIDACION = Target.the("Label confirmar login exitoso").located(By.xpath("//div[contains(text(),'Swag Labs')]"));

    public static final Target LBL_VALIDACION_ERROR_MESSAGE = Target.the("Label error mensaje").located(By.cssSelector("[data-test='error']"));




}
