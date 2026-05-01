package com.saucedemo.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterElemento implements Interaction {

    private final Target elemento;
    private final String textoEntrada;

    public EnterElemento(Target elemento, String textoEntrada) {
        this.elemento = elemento;
        this.textoEntrada = (textoEntrada == null || textoEntrada.isBlank())
                ? ""
                : textoEntrada;
    }

    @Override
    @Step("{0} ingresa el texto '#textoEntrada'")
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    WaitUntil.the(this.elemento,isVisible()).forNoMoreThan(5).seconds(),
                    Enter.theValue(this.textoEntrada).into(this.elemento)
            );

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    public static EnterElemento onCampo(Target elemento,String texto){
        return Instrumented.instanceOf(EnterElemento.class).withProperties(elemento,texto);
    }
}
