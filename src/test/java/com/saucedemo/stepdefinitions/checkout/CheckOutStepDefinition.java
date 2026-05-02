package com.saucedemo.stepdefinitions.checkout;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.carrito.CheckOutCarrito;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static com.saucedemo.UI.carrito.CarritoUI.*;
import static com.saucedemo.helpers.MensajesValidacion.mensajeConfirmacionCompra;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;

public class CheckOutStepDefinition {


    @Cuando("complete el formulario de compra")
    public void completeElFormularioDeCompra(DataTable dataFormulario) {
        List<Map<String, String>> datos = dataFormulario.asMaps(String.class, String.class);

        theActorInTheSpotlight().attemptsTo(
                CheckOutCarrito.onFormulario(datos)
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
