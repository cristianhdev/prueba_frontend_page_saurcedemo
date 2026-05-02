package com.saucedemo.validations.carrito;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ValidarTexto;
import net.serenitybdd.screenplay.Actor;

import static com.saucedemo.UI.carrito.CarritoUI.ITEM_PRODUCTO_TITULO_CARRITO;
import static com.saucedemo.UI.carrito.CarritoUI.LBL_PAGINA_CARRITO_VALIDACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidacionCarrito {

   public static Producto producto;


    public static void ValidacionProductoAgregadoCarritoCompra(Actor actor){
        producto = actor.recall("producto_seleccionado");

        theActorInTheSpotlight().should(
                seeThat("Valida que se muestre la pagina de carrito", ValidarTexto.onValidar(LBL_PAGINA_CARRITO_VALIDACION), equalTo("Your Cart")),
                seeThat("Valida que el producto este en el carrito de compra ", ValidarTexto.onValidar(ITEM_PRODUCTO_TITULO_CARRITO), containsString(producto.getTituloProducto()))
        );
    }

    public static void ValidacionProductoEliminadoCarritoCompra(Actor actor){
        producto = actor.recall("producto_seleccionado");

        theActorInTheSpotlight().should(
                seeThat("Valida que se muestre la pagina de carrito", ValidarTexto.onValidar(LBL_PAGINA_CARRITO_VALIDACION), equalTo("Your Cart")),
                seeThat("Valida que el producto este en el carrito de compra ", ValidarTexto.onValidar(ITEM_PRODUCTO_TITULO_CARRITO), containsString(producto.getTituloProducto()))
        );
    }
}
