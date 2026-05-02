package com.saucedemo.UI.carrito;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class CarritoUI {


    public static final Target ITEM_PRODUCTO_TITULO_CARRITO = Target.the("carrito compra").located(By.cssSelector("[data-test='inventory-item-name']"));

    public static final Target LBL_PAGINA_CARRITO_VALIDACION = Target.the("Label confirmación pagina carrito").located(By.cssSelector("[data-test='title']"));

    public static final Target BTN_ELIMINAR_PRODUCTO_CARRITO = Target.the("eliminar producto carrito").located(By.xpath("//*[contains(text(),'Remove')]"));

    public static final Target BTN_CHECKOUT_CARRITO = Target.the("checkout carrito").located(By.cssSelector("[data-test='checkout']"));

    public static final Target LBL_PAGINA_CHECKOUT_VALIDACION = Target.the("Label confirmación pagina checkout").located(By.cssSelector("[data-test='title']"));

    public static final Target PAGINA_CHECKOUT_VALIDACION_TITULO_PRODUCTO = Target.the("Label confirmación titulo producto pagina checkout").located(By.cssSelector("[data-test='inventory-item-name']"));

    public static final Target PAGINA_CHECKOUT_VALIDACION_PRECIO_PRODUCTO = Target.the("Label confirmación precio producto pagina checkout").located(By.cssSelector("[data-test='inventory-item-price']"));

    //formulario checkout

    public static final Target INPUT_TEXT_PRIMER_NOMBRE = Target.the(" texto firstName").located(By.cssSelector("[data-test='firstName']"));

    public static final Target INPUT_TEXT_SEGUNDO_NOMBRE = Target.the(" texto lastName").located(By.cssSelector("[data-test='lastName']"));

    public static final Target INPUT_TEXT_POSTAL_CODE = Target.the(" texto postalCode").located(By.cssSelector("[data-test='postalCode']"));

    public static final Target BTN_CONTINUAR_COMPRA = Target.the(" boton continuar").located(By.cssSelector("[data-test='continue']"));

    public static final Target BTN_FINALIZAR_COMPRA = Target.the(" boton finalizar").located(By.cssSelector("[data-test='finish']"));

    public static final Target LBL_CONFIRMACION_COMPRA = Target.the(" mensaje confirmacion compra").located(By.cssSelector("[data-test='complete-header']"));

}
