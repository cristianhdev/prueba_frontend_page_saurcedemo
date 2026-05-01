package com.saucedemo.tasks.usuario;

import com.saucedemo.UI.usuario.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirNavegador implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(HomePageUI.class)
        );
    }

    public static AbrirNavegador navegar(){
        return Tasks.instrumented(AbrirNavegador.class);
    }
}
