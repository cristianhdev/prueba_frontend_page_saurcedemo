package com.saucedemo.stepdefinitions;

import com.saucedemo.models.Producto;
import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.producto.SeleccionarProducto;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static com.saucedemo.UI.producto.ProductoDetalleUI.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProductoStepDefinition {

    @Cuando("el usuario seleccione un producto")
    public void elUsuarioSeleccioneUnProducto() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProducto.onSeleccionar()
        );
    }
    @Entonces("se debe ver la pagina con los detalles del producto")
    public void seDebeVerLaPaginaConLosDetallesDelProducto() {

        Producto producto =theActorInTheSpotlight().recall("producto_seleccionado");

        theActorInTheSpotlight().should(
                seeThat("Valida que se muestre la pagina detalle del producto", ValidarTexto.onValidar(LBL_PAGINA_DETALLE_PRODUCTO_VALIDACION), equalTo("Back to products")),
                seeThat("Valida que el titulo sea igual al del articulo seleccionado ", ValidarTexto.onValidar(ITEM_PRODUCTO_TITULO_DETALLE), containsString(producto.getTituloProducto())),
                seeThat("Valida que el precio sea igual al del articulo seleccionado ", ValidarTexto.onValidar(ITEM_PRODUCTO_PRECIO_DETALLE), containsString(producto.getPrecioProducto()))
        );
    }


}
