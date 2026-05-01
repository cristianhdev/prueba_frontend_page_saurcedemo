package com.saucedemo.tasks.filtro;

import com.saucedemo.interactions.ClickElemento;
import com.saucedemo.interactions.SelecionOpcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.ITEMS_PRECIOS;
import static com.saucedemo.UI.producto.ProductosUI.SELECT_PRODUCTO_FILTRO;

public class FiltroProductoPrecioAsc implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickElemento.onElemento(SELECT_PRODUCTO_FILTRO),
                SelecionOpcion.onOpcion(SELECT_PRODUCTO_FILTRO,"Price (low to high)")
        );

        //Guardamos los productos despues de ordenar
        actor.remember("order-precio-productos-asc", Text.ofEach(ITEMS_PRECIOS));
    }

    public static FiltroProductoPrecioAsc onSeleccionFiltroProductoPrecioAsc(){
        return Tasks.instrumented(FiltroProductoPrecioAsc.class);
    }

}
