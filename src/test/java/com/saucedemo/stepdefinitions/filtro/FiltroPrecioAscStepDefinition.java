package com.saucedemo.stepdefinitions.filtro;

import com.saucedemo.tasks.filtro.FiltroProductoPrecioAsc;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.ITEMS_PRECIOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FiltroPrecioAscStepDefinition {

    @Cuando("los ordena de menor a mayor por precio")
    public void losOrdenaDeMenorAMayorPorPrecio() {
        theActorInTheSpotlight().attemptsTo(
                FiltroProductoPrecioAsc.onSeleccionFiltroProductoPrecioAsc()
        );
    }


    @Entonces("se debe ver los productos ordenados por precio de manera ascendente")
    public void seDebeVerLosProductosOrdenadosPorPrecioDeManeraAscendente() {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(Text.ofEach(ITEMS_PRECIOS),
                        equalTo(actor.recall("order-precio-productos-asc"))
                )
        );

    }

}
