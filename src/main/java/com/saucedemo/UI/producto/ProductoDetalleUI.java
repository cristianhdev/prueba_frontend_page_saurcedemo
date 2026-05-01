package com.saucedemo.UI.producto;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ProductoDetalleUI {


    public static final Target LBL_PAGINA_DETALLE_PRODUCTO_VALIDACION = Target.the("Label confirmación pagina detalle").located(By.cssSelector("[data-test='back-to-products']"));

    public static final Target ITEM_PRODUCTO_TITULO_DETALLE = Target.the(" producto titulo detalle").located(By.cssSelector("[data-test='inventory-item-name']"));

    public static final Target ITEM_PRODUCTO_PRECIO_DETALLE = Target.the(" producto precio detalle").located(By.cssSelector("[data-test='inventory-item-price']"));

    public static final Target BTN_AGREGAR_PRODUCTO_CARRITO = Target.the(" boton agregar a carrito").located(By.cssSelector("[data-test='add-to-cart']"));

    public static final Target ICON_CARRITO_COMPRA = Target.the(" carrito compra").located(By.cssSelector("[data-test='shopping-cart-link']"));
}
