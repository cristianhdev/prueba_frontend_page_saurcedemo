package com.saucedemo.tasks.filtro;

import com.saucedemo.interactions.ClickElemento;
import com.saucedemo.interactions.SelecionOpcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static com.saucedemo.UI.producto.ProductosUI.ITEM_PRODUCTO;
import static com.saucedemo.UI.producto.ProductosUI.SELECT_PRODUCTO_FILTRO;

public class FiltrarProductoZA implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickElemento.onElemento(SELECT_PRODUCTO_FILTRO),
                SelecionOpcion.onOpcion(SELECT_PRODUCTO_FILTRO,"Name (Z to A)")
        );

        //Guardamos los productos despues de ordenar
        actor.remember("order-productos-desc", Text.ofEach(ITEM_PRODUCTO));
    }

    public static FiltrarProductoZA onSeleccionFiltroZA(){
        return Tasks.instrumented(FiltrarProductoZA.class);
    }
}
