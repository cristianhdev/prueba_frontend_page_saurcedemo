package com.saucedemo.questions.filtro;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collections;
import java.util.List;

import static com.saucedemo.UI.producto.ProductosUI.ITEMS_PRECIOS;


public class ProductosAscPrecio implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {

        List<String> preciosOrdenados = (List<String>) Text.ofEach(ITEMS_PRECIOS).answeredBy(actor);

        // ordenar ascendente
        Collections.sort(preciosOrdenados);

        return preciosOrdenados;
    }
    public static ProductosAscPrecio listaPrecio() {
        return new ProductosAscPrecio();
    }
}
