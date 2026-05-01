#language:es
@DetallesProductoSuite @Regression
Característica: Ver detalles del producto

  Antecedentes: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |
