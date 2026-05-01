package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarElemento implements Question<Boolean> {

    private final Target target;

    public ValidarElemento(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(100).seconds());
        return target.isVisibleFor(actor);
    }

    public static ValidarElemento isPresente (Target target) {
        return new ValidarElemento(target);
    }
}
