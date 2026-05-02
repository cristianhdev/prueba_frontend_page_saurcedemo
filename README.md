### Proyecto Front SauceDemo:

### - Ejecutar automatización:
```bash
gradle clean test
```
### - Gererar reporte:
```bash
gradle aggregate
```


## 🏷️ Tags disponibles

| Tag                 | Descripción                                                  |
|---------------------|--------------------------------------------------------------|
| @smoke     | Pruebas críticas                                             |
| @regression| Suite completa (E2E)                                         |
| @login              | Escenarios relacionados con el inicio de sesión del usuario  |
| @select-product     | Selección de un producto dentro del catálogo                 |
| @vacio-username     | Validación de login con campo username vacío                 |
| @vacio-password     | Validación de login con campo password vacío                 |
| @usuario-invalido   | Intento de login con credenciales incorrectas                |
| @usuario-bloqueado  | Validación de acceso con usuario bloqueado                   |
| @login-out          | Cierre de sesión del usuario                                 |
| @filtros            | Funcionalidad general de filtros de productos                |
| @filtro-za          | Ordenamiento de productos de Z a A                           |
| @filtro-az          | Ordenamiento de productos de A a Z                           |
| @filtro-mayor-menor | Ordenamiento por precio de mayor a menor                     |
| @filtro-menor-mayor | Ordenamiento por precio de menor a mayor                     |
| @checkout           | Proceso de compra (checkout)                                 |
| @checkout-producto  | Validación de compra de un producto específico               |
| @carrito            | Funcionalidades del carrito de compras                       |
| @agregar-producto   | Agregar productos al carrito                                 |
| @remover-producto   | Remover productos del carrito                                |