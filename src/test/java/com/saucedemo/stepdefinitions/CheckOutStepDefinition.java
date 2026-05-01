package com.saucedemo.stepdefinitions;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.carrito.CheckOutCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static com.saucedemo.UI.carrito.CarritoUI.*;
import static com.saucedemo.UI.producto.ProductoDetalleUI.ITEM_PRODUCTO_PRECIO_DETALLE;
import static com.saucedemo.UI.producto.ProductoDetalleUI.ITEM_PRODUCTO_TITULO_DETALLE;
import static com.saucedemo.helpers.MensajesValidacion.mensajeConfirmacionCompra;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;

public class CheckOutStepDefinition {

    @Cuando("complete el formulario de compra")
    public void completeElFormularioDeCompra() {
        theActorInTheSpotlight().attemptsTo(
                CheckOutCarrito.onFormulario()
        );
    }


    @Entonces("se debe ver el mensaje de confirmación del pedido")
    public void seDebeVerElMensajeDeConfirmaciónDelPedido() {
        Producto producto = theActorInTheSpotlight().recall("producto_seleccionado");

        theActorInTheSpotlight().should(
                seeThat("Valida que el producto este en el carrito de compra ", ValidarTexto.onValidar(LBL_CONFIRMACION_COMPRA), containsString(mensajeConfirmacionCompra))
        );
    }

}
