package com.saucedemo.tasks.usuario;

import com.saucedemo.interactions.ClickElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.UI.usuario.HomePageUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogOutUsuario implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickElemento.onElemento(BTN_LOGOUT_MENU),
                ClickElemento.onElemento(BTN_LOGOUT_OPTION),
                WaitUntil.the(LBL_LOGOUT_VALIDACION, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static LogOutUsuario on(){
        return Tasks.instrumented(LogOutUsuario.class);
    }
}
