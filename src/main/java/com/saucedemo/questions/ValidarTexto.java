package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarTexto implements Question<String> {

    private final Target elemento;

    public ValidarTexto(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(this.elemento).answeredBy(actor);
    }

    public static ValidarTexto onValidar(Target elemento){
        return new ValidarTexto(elemento);
    }
}
