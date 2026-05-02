#language:es
@productos @regression
Característica: Ver detalles del producto

  Antecedentes: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |

  @select-product
  Escenario: usuario puede ver detalles del producto selecionado
    Cuando el usuario seleccione un producto
    Entonces se debe ver la pagina con los detalles del producto