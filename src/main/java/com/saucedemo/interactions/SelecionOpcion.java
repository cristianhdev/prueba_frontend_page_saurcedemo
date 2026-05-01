package com.saucedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelecionOpcion implements Interaction {

    private final Target elemento;
    private final String opcion;

    public SelecionOpcion(Target elemento, String opcion) {
        this.elemento = elemento;
        this.opcion = opcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try{
            WaitUntil.the(this.elemento,isVisible()).forNoMoreThan(5).seconds();
            elemento.resolveFor(actor).selectByVisibleText(this.opcion);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    public static SelecionOpcion onOpcion(Target elemento,String opcion){
        return Tasks.instrumented(SelecionOpcion.class,elemento,opcion);
    }
}
