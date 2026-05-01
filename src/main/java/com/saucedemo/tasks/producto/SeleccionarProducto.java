package com.saucedemo.tasks.producto;

import com.saucedemo.interactions.ClickElemento;
import com.saucedemo.models.Producto;
import com.saucedemo.utils.RamdomNumber;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.UI.producto.ProductoDetalleUI.LBL_PAGINA_DETALLE_PRODUCTO_VALIDACION;
import static com.saucedemo.UI.producto.ProductosUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarProducto implements Task {

    private int numeroRandom = 0;

    private String tituloProductoSeleccionado = "";

    private String precioProductoSeleccionado = "";

    private Producto producto;


    @Override
    @Step("{0} selecciona un producto")
    public <T extends Actor> void performAs(T actor) {

        ProductoDetalles(actor);

        actor.attemptsTo(
                ClickElemento.onElemento(ITEM_PRODUCTO_TITULO.of(String.valueOf(this.numeroRandom))),
                WaitUntil.the(LBL_PAGINA_DETALLE_PRODUCTO_VALIDACION, isVisible()).forNoMoreThan(55).seconds()
        );
    }

    /**
     * Capturamos la informacion del producto seleccionado
     * @param actor
     */
    public void ProductoDetalles(Actor actor){
        int cantidadProductos = ITEMS_PRODUCTOS.resolveAllFor(actor).size();

        this.numeroRandom = RamdomNumber.generateInt(cantidadProductos);
        this.tituloProductoSeleccionado = Text.of(ITEM_PRODUCTO_TITULO.of(String.valueOf(this.numeroRandom))).answeredBy(actor);
        this.precioProductoSeleccionado = Text.of(ITEM_PRODUCTO_PRECIO.of(String.valueOf(this.numeroRandom))).answeredBy(actor);

        this.producto = new Producto();

        this.producto.setTituloProducto(this.tituloProductoSeleccionado);
        this.producto.setPrecioProducto(this.precioProductoSeleccionado);

        actor.remember("producto_seleccionado",this.producto);
    }

    public static SeleccionarProducto onSeleccionar(){
        return Tasks.instrumented(SeleccionarProducto.class);
    }
}
