package com.saucedemo.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Producto {

    @Getter
    private String tituloProducto;
    private String precioProducto;

}
