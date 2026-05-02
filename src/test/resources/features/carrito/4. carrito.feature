#language:es
@CarritoSuite @Regression
Característica: Carrito de compras

  Antecedentes: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |


  @AgregarProductoAlCarritoDeCompras
  Escenario: usuario puede agregar producto al carrito de compras
    Cuando el usuario seleccione un producto
    Y lo agrega al carrito de compras
    Entonces se debe ver el producto en el carrito de compras


  @RemoverProductosDelCarrito
  Escenario: usuario puede eliminar el producto del carrito de compras
    Cuando el usuario seleccione un producto
    Y lo agrega al carrito de compras y luego lo elimine
    Entonces no debe ver el producto en el carrito de compras

