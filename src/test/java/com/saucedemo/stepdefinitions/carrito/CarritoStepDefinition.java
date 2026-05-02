package com.saucedemo.stepdefinitions.carrito;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.carrito.AgregarCarrito;
import com.saucedemo.tasks.carrito.EliminarCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static com.saucedemo.UI.carrito.CarritoUI.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;

public class CarritoStepDefinition {



    //Agregar Producto Carrito
    @Cuando("lo agrega al carrito de compras")
    public void loAgregaAlCarritoDeCompras() {
        Producto producto = theActorInTheSpotlight().recall("producto_seleccionado");

        theActorInTheSpotlight().attemptsTo(
                AgregarCarrito.onAgregarProducto(producto.getTituloProducto())
        );

    }

    @Entonces("se debe ver el producto en el carrito de compras")
    public void seDebeVerElProductoEnElCarritoDeCompras() {

        Producto producto = theActorInTheSpotlight().recall("producto_seleccionado");

        theActorInTheSpotlight().should(
                seeThat("Valida que se muestre la pagina de carrito", ValidarTexto.onValidar(LBL_PAGINA_CARRITO_VALIDACION), equalTo("Your Cart")),
                seeThat("Valida que el producto este en el carrito de compra ", ValidarTexto.onValidar(ITEM_PRODUCTO_TITULO_CARRITO), containsString(producto.getTituloProducto()))
        );
    }



    //Eliminar Producto Carrito
    @Cuando("lo agrega al carrito de compras y luego lo elimine")
    public void loAgregaAlCarritoDeComprasYLuegoLoElimina() {
        Producto producto = theActorInTheSpotlight().recall("producto_seleccionado");

        theActorInTheSpotlight().attemptsTo(
                AgregarCarrito.onAgregarProducto(producto.getTituloProducto()),
                EliminarCarrito.onEliminarProducto(producto.getTituloProducto())
        );
    }

    @Entonces("no debe ver el producto en el carrito de compras")
    public void noDebeVerElProductoEnElCarritoDeCompras() {
        Producto producto = theActorInTheSpotlight().recall("producto_seleccionado");

        theActorInTheSpotlight().should(
                seeThat("Valida que se muestre la pagina de carrito", ValidarTexto.onValidar(LBL_PAGINA_CARRITO_VALIDACION), equalTo("Your Cart")),
                seeThat("Valida que el producto este en el carrito de compra ", ValidarTexto.onValidar(ITEM_PRODUCTO_TITULO_CARRITO), not(containsString(producto.getTituloProducto())))
        );
    }
}
