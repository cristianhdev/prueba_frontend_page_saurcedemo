package com.saucedemo.tasks.filtro;

import com.saucedemo.interactions.ClickElemento;
import com.saucedemo.interactions.SelecionOpcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.*;

public class FiltroProductoPrecioDesc implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickElemento.onElemento(SELECT_PRODUCTO_FILTRO),
                SelecionOpcion.onOpcion(SELECT_PRODUCTO_FILTRO,"Price (high to low)")
        );

        //Guardamos los productos despues de ordenar
        actor.remember("order-precio-productos-desc", Text.ofEach(ITEMS_PRECIOS));
    }

    public static FiltroProductoPrecioDesc onSeleccionFiltroPrecioDesc(){
        return Tasks.instrumented(FiltroProductoPrecioDesc.class);
    }

}
