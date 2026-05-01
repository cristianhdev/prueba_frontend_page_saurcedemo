#language:es
@FiltrosSuite @Regression
Característica: Ordenar productos por nombre y precio

  Antecedentes: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |

  @FiltrarOrdenZA
  Escenario: Ordenar productos por nombre en orden ascendente
    Cuando se encuentre en la pagina de productos
    Y los ordena por nombre alfabeticamente (Z-A)
    Entonces se debe ver los productos ordenados de manera ascendente


  @FiltrarOrdenAZ
  Escenario: Ordenar productos por nombre en orden descendente
    Cuando se encuentre en la pagina de productos
    Y los ordena de nombre alfabeticamente (A-Z)
    Entonces se debe ver los productos ordenados de manera descendente

  @FiltrarPorPrecioDesc
  Escenario: Ordenar productos por precio en orden descendente (Mayor a Menor)
    Cuando se encuentre en la pagina de productos
    Y los ordena de mayor a menor por precio
    Entonces se debe ver los productos ordenados por precio de manera descendente

  @FiltrarPorPrecioAsc
  Escenario: Ordenar productos por precio en orden ascendente (Menor a Mayor)
    Cuando se encuentre en la pagina de productos
    Y los ordena de menor a mayor por precio
    Entonces se debe ver los productos ordenados por precio de manera ascendente

