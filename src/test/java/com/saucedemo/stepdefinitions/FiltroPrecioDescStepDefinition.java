package com.saucedemo.stepdefinitions;

import com.saucedemo.tasks.filtro.FiltroProductoPrecioAsc;
import com.saucedemo.tasks.filtro.FiltroProductoPrecioDesc;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.ITEMS_PRECIOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FiltroPrecioDescStepDefinition {

    @Cuando("los ordena de mayor a menor por precio")
    public void losOrdenaDeMayorAMenorPorPrecio() {
        theActorInTheSpotlight().attemptsTo(
            FiltroProductoPrecioAsc.onSeleccionFiltroProductoPrecioAsc(),
            FiltroProductoPrecioDesc.onSeleccionFiltroPrecioDesc()
        );
    }

    @Entonces("se debe ver los productos ordenados por precio de manera descendente")
    public void seDebeVerLosProductosOrdenadosPorPrecioDeManeraDescendente() {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(Text.ofEach(ITEMS_PRECIOS),
                        equalTo(actor.recall("order-precio-productos-desc"))
                )
        );
    }

}
