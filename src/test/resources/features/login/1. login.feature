#language:es
@LoginSuite
Característica: Login Usuario


  @LoginUsuario
  Escenario: Login usuario exitoso.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password     |
      | standard_user | secret_sauce |
    Entonces se debe acceder correctamente a su cuenta

  @CampoUserNameVacio
  Escenario: Login usuario campo username vacio.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username | password     |
      |          | secret_sauce |
    Entonces se deber visualizar el mensaje "Epic sadface: Username is required"


  @CampoPasswordVacio
  Escenario: Login usuario campo password vacio.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username      | password |
      | standard_user |          |
    Entonces se deber visualizar el mensaje "Epic sadface: Password is required"


  @LoginUsuarioNoRegistrado
  Escenario: Login usuario no registrado.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username | password |
      | tomas    | epic     |
    Entonces se deber visualizar el mensaje "Epic sadface: Username and password do not match any user in this service"

  @LoginUsuarioBloqueado
  Escenario: Login usuario bloqueado.
    Dado que el usuario se encuentra en la página del login
    Cuando ingrese las credenciales
      | username        | password     |
      | locked_out_user | secret_sauce |
    Entonces se deber visualizar el mensaje "Epic sadface: Sorry, this user has been locked out."

