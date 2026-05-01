package com.saucedemo.tasks.carrito;

import com.saucedemo.interactions.ClickElemento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.UI.carrito.CarritoUI.LBL_PAGINA_CARRITO_VALIDACION;
import static com.saucedemo.UI.producto.ProductoDetalleUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarCarrito implements Task {

    private String productoNombre = "";

    public AgregarCarrito(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    @Override
    @Step("{0} agrega el producto '#productoNombre' al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickElemento.onElemento(BTN_AGREGAR_PRODUCTO_CARRITO),
                ClickElemento.onElemento(ICON_CARRITO_COMPRA),
                WaitUntil.the(LBL_PAGINA_CARRITO_VALIDACION, isVisible()).forNoMoreThan(25).seconds()
        );
    }

    public static AgregarCarrito onAgregarProducto(String productoNombre){
        return Tasks.instrumented(AgregarCarrito.class,productoNombre);
    }
}
