package com.saucedemo.stepdefinitions.carrito;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.carrito.AgregarCarrito;
import com.saucedemo.tasks.carrito.EliminarCarrito;
import com.saucedemo.validations.carrito.ValidacionCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CarritoStepDefinition {

    //Agregar Producto Carrito
    @Cuando("lo agrega al carrito de compras")
    public void loAgregaAlCarritoDeCompras() {

        Producto producto= theActorInTheSpotlight().recall("producto_seleccionado");


        theActorInTheSpotlight().attemptsTo(
                AgregarCarrito.onAgregarProducto(producto.getTituloProducto())
        );
    }

    @Entonces("se debe ver el producto en el carrito de compras")
    public void seDebeVerElProductoEnElCarritoDeCompras() {
        ValidacionCarrito.ValidacionProductoAgregadoCarritoCompra(theActorInTheSpotlight());
    }

    //Eliminar Producto Carrito
    @Cuando("lo agrega al carrito de compras y luego lo elimine")
    public void loAgregaAlCarritoDeComprasYLuegoLoElimina() {

        Producto producto= theActorInTheSpotlight().recall("producto_seleccionado");

        String productoTitulo = producto.getTituloProducto();

        theActorInTheSpotlight().attemptsTo(
                AgregarCarrito.onAgregarProducto(productoTitulo),
                EliminarCarrito.onEliminarProducto(productoTitulo)
        );
    }

    @Entonces("no debe ver el producto en el carrito de compras")
    public void noDebeVerElProductoEnElCarritoDeCompras() {
        ValidacionCarrito.ValidacionProductoEliminadoCarritoCompra(theActorInTheSpotlight());
    }
}
