#language:es
@LoginOutSuite @Regression
Característica: LogOut Usuario

  Antecedentes: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |

  @LogOutUsuario
  Escenario: Usuario cierra sesion
  Cuando cierra la sesion
  Entonces se deber visualizar la pagina de inicio