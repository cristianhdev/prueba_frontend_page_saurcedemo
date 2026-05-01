package com.saucedemo.tasks.carrito;

import com.saucedemo.interactions.ClickElemento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.UI.carrito.CarritoUI.BTN_ELIMINAR_PRODUCTO_CARRITO;
import static com.saucedemo.UI.carrito.CarritoUI.LBL_PAGINA_CARRITO_VALIDACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarCarrito implements Task {

    private String productoNombre = "";

    public EliminarCarrito(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    @Override
    @Step("{0} eliminar el producto '#productoNombre' del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LBL_PAGINA_CARRITO_VALIDACION, isVisible()).forNoMoreThan(25).seconds(),
                WaitUntil.the(BTN_ELIMINAR_PRODUCTO_CARRITO, isVisible()).forNoMoreThan(25).seconds(),
                ClickElemento.onElemento(BTN_ELIMINAR_PRODUCTO_CARRITO)
        );
    }

    public static EliminarCarrito onEliminarProducto(String productoNombre){
        return Tasks.instrumented(EliminarCarrito.class,productoNombre);
    }
}
