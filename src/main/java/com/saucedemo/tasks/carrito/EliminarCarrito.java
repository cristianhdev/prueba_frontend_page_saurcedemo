package com.saucedemo.tasks.carrito;

import com.saucedemo.interactions.ClickElemento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.UI.carrito.CarritoUI.BTN_ELIMINAR_PRODUCTO_CARRITO;
import static com.saucedemo.UI.carrito.CarritoUI.LBL_PAGINA_CARRITO_VALIDACION;
import static com.saucedemo.UI.producto.ProductoDetalleUI.BTN_AGREGAR_PRODUCTO_CARRITO;
import static com.saucedemo.UI.producto.ProductoDetalleUI.ICON_CARRITO_COMPRA;
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
                ClickElemento.onElemento(BTN_ELIMINAR_PRODUCTO_CARRITO)
        );
    }

    public static EliminarCarrito onEliminarProducto(String productoNombre){
        return Tasks.instrumented(EliminarCarrito.class,productoNombre);
    }
}
