package com.saucedemo.stepdefinitions.filtro;

import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.filtro.FiltrarProductoZA;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.ITEM_PRODUCTO;
import static com.saucedemo.UI.producto.ProductosUI.LBL_PAGINA_PRODUCTOS_VALIDACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class FiltrosZAStepDefinition {

    //Filtros  orden Z-A
    @Cuando("se encuentre en la pagina de productos")
    public void seEncuentreEnLaPaginaDeProductos() {
        theActorInTheSpotlight().should(
                seeThat("Valida que se muestre la pagina de productos", ValidarTexto.onValidar(LBL_PAGINA_PRODUCTOS_VALIDACION), equalTo("Products"))
        );
    }

    @Cuando("los ordena por nombre alfabeticamente \\(Z-A)")
    public void losOrdenPorNombreAlfabeticamenteZA() {
        theActorInTheSpotlight().attemptsTo(
                FiltrarProductoZA.onSeleccionFiltroZA()
        );
    }

    @Entonces("se debe ver los productos ordenados de manera ascendente")
    public void seDebeVerLosProductosOrdenadosDeManeraAscendente() {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(Text.ofEach(ITEM_PRODUCTO),
                        equalTo(actor.recall("order-productos-desc"))
                )
        );
    }

    //Filtros  orden Z-A

}
