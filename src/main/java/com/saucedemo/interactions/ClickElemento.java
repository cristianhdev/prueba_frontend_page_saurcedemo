package com.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickElemento implements Interaction {

    private final Target elemento;

    public ClickElemento(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    @Step("{0} hace clic el '#elemento'")
    public <T extends Actor> void performAs(T actor) {
        System.out.println("click elemento:"+ this.elemento.getName());

            actor.attemptsTo(
                    WaitUntil.the(this.elemento, isVisible()).forNoMoreThan(25).seconds(),
                    Click.on(this.elemento)
            );
    }

    public static ClickElemento onElemento(Target elemento){
        return Instrumented.instanceOf(ClickElemento.class).withProperties(elemento);
    }
}
