package com.saucedemo.tasks.carrito;

import com.saucedemo.interactions.ClickElemento;
import com.saucedemo.interactions.EnterElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static com.saucedemo.UI.carrito.CarritoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckOutCarrito implements Task {

    private final List<Map<String, String>> formularioData;

    public CheckOutCarrito(List<Map<String, String>> formularioData) {
        this.formularioData = formularioData;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickElemento.onElemento(BTN_CHECKOUT_CARRITO),
                WaitUntil.the(LBL_PAGINA_CHECKOUT_VALIDACION,isVisible()).forNoMoreThan(25).seconds(),
                EnterElemento.onCampo(INPUT_TEXT_PRIMER_NOMBRE,this.formularioData.get(0).get("nombre")),
                EnterElemento.onCampo(INPUT_TEXT_SEGUNDO_NOMBRE,this.formularioData.get(0).get("apellido")),
                EnterElemento.onCampo(INPUT_TEXT_POSTAL_CODE,this.formularioData.get(0).get("codigopostal")),
                ClickElemento.onElemento(BTN_CONTINUAR_COMPRA),
                WaitUntil.the(BTN_FINALIZAR_COMPRA,isVisible()).forNoMoreThan(25).seconds(),
                ClickElemento.onElemento(BTN_FINALIZAR_COMPRA),
                WaitUntil.the(LBL_CONFIRMACION_COMPRA,isVisible()).forNoMoreThan(25).seconds()

        );
    }

    public static CheckOutCarrito onFormulario(List<Map<String, String>> datos){
        return Tasks.instrumented(CheckOutCarrito.class,datos);
    }
}
