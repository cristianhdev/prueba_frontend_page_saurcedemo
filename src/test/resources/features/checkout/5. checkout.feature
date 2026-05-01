#language:es
@ProductoSuite @smoke
Característica: Compra completa producto

  Antecedentes: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |

    @CheckOutProducto
    Escenario: checkout producto
      Cuando el usuario seleccione un producto
      Y lo agrega al carrito de compras
      Y complete el formulario de compra
      Entonces se debe ver el mensaje de confirmación del pedido

