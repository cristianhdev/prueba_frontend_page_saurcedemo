package com.saucedemo.tasks.carrito;

import com.saucedemo.interactions.ClickElemento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.saucedemo.UI.carrito.CarritoUI.BTN_ELIMINAR_PRODUCTO_CARRITO;



public class EliminarCarrito implements Task {

    private String productoNombre = "";

    public EliminarCarrito(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    @Override
    @Step("{0} eliminar el producto '#productoNombre' del carrito")
    public <T extends Actor> void performAs(T actor) {

        //Transformamos el nombre para buscar el elemento a eliminar, remplazamos los espacios por '-' y bajamos a minisculas
        String productotag = productoNombre.replaceAll("\\s+","-").toLowerCase();

        actor.attemptsTo(
                ClickElemento.onElemento(BTN_ELIMINAR_PRODUCTO_CARRITO.of(productotag))
        );
    }

    public static EliminarCarrito onEliminarProducto(String productoNombre){
        return Tasks.instrumented(EliminarCarrito.class,productoNombre);
    }
}
