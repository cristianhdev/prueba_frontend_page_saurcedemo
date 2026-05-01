package com.saucedemo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collections;
import java.util.List;

import static com.saucedemo.UI.producto.ProductosUI.ITEM_PRODUCTO;

public class ProductosDesc implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {

     List<String> nombresOrdenados = (List<String>) Text.ofEach(ITEM_PRODUCTO).answeredBy(actor);

        // ordenar ascendente
      Collections.sort(nombresOrdenados);

        return nombresOrdenados;
    }

    public static ProductosDesc lista() {
        return new ProductosDesc();
    }
}
