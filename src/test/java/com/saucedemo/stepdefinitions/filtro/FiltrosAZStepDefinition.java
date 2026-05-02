package com.saucedemo.stepdefinitions.filtro;

import com.saucedemo.tasks.filtro.FiltrarProductoAZ;
import com.saucedemo.tasks.filtro.FiltrarProductoZA;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.ITEM_PRODUCTO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FiltrosAZStepDefinition {

    @Cuando("los ordena de nombre alfabeticamente \\(A-Z)")
    public void losOrdenDeNombreAlfabeticamenteAZ() {
        theActorInTheSpotlight().attemptsTo(
                FiltrarProductoZA.onSeleccionFiltroZA(),
                FiltrarProductoAZ.onSeleccionFiltroAZ()
        );
    }
    @Entonces("se debe ver los productos ordenados de manera descendente")
    public void seDebeVerLosProductosOrdenadosDeManeraDescendente() {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(Text.ofEach(ITEM_PRODUCTO),
                        equalTo(actor.recall("order-productos-asc"))
                )
        );
    }
}
