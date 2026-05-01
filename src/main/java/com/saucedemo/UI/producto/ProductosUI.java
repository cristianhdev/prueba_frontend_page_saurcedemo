package com.saucedemo.UI.producto;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class ProductosUI {

    public static final Target ITEMS_PRODUCTOS = Target.the(" productos").located(By.cssSelector("[data-test='inventory-item']"));

    public static final Target ITEM_PRODUCTO = Target.the(" producto").locatedBy("([data-test='inventory-item'])[{0}");

    public static final Target ITEM_PRODUCTO_TITULO = Target.the(" producto titulo").locatedBy("(//div[@data-test='inventory-item-name'])[{0}]");

    public static final Target ITEM_PRODUCTO_PRECIO = Target.the(" producto precio").locatedBy("(//div[@data-test='inventory-item'])[{0}]//div[contains(@data-test,'inventory-item-price')]");

    public static final Target ITEM_PRODUCTO_IMAGEN = Target.the(" producto imagen").located(By.cssSelector("(//div[@data-test='item-4-img-link'])"));

}
