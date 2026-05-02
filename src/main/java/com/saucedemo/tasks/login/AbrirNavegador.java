package com.saucedemo.tasks.login;

import com.saucedemo.UI.login.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirNavegador implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().thePageNamed("pages.base.url")
        );
    }

    public static AbrirNavegador navegar(){
        return Tasks.instrumented(AbrirNavegador.class);
    }
}
