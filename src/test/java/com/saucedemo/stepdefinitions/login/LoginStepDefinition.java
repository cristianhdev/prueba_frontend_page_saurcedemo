package com.saucedemo.stepdefinitions.login;

import com.saucedemo.questions.ValidarTexto;
import com.saucedemo.tasks.login.AbrirNavegador;
import com.saucedemo.tasks.login.LogOutUsuario;
import com.saucedemo.tasks.login.LoginUsuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static com.saucedemo.UI.login.HomePageUI.LBL_LOGOUT_VALIDACION;
import static com.saucedemo.UI.login.LoginPageUI.*;
import static com.saucedemo.helpers.MensajesValidacion.mensajeValidacionLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition {

    @Managed(driver = "firefox")
    WebDriver browser;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario").can(BrowseTheWeb.with(browser));
    }

    private Actor usuario_login;

    @Dado("que el usuario se encuentra en la página del login")
    public void queElUsuarioSeEncuentraEnLaPáginaDelLogin() {


        theActorInTheSpotlight().attemptsTo(
                AbrirNavegador.navegar()
        );
    }
    @Cuando("ingrese las credenciales")
    public void ingreseLasCredenciales(DataTable dataLogin) {

        Map<String, String> datos = dataLogin.asMaps().get(0);

        theActorInTheSpotlight().attemptsTo(
                LoginUsuario.onFormularioLogin(datos.get("username"),datos.get("password"))
        );
    }
    @Entonces("se debe acceder correctamente a su cuenta")
    public void seDebeAccederCorrectamenteASuCuenta() {
        theActorInTheSpotlight().should(
                seeThat("Validar titulo página login usuario registrado", ValidarTexto.onValidar(LBL_LOGIN_VALIDACION), equalTo(mensajeValidacionLogin))
        );
    }

    @Entonces("se deber visualizar el mensaje {string}")
    public void seDeberVisualizarElMensaje(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de validación ", ValidarTexto.onValidar(LBL_VALIDACION_ERROR_MESSAGE), equalTo(mensaje))
        );
    }
    @Cuando("cierra la sesion")
    public void cierraLaSesion() {
        theActorInTheSpotlight().attemptsTo(
                LogOutUsuario.on()
        );
    }
    @Entonces("se deber visualizar la pagina de inicio")
    public void seDeberVisualizarLaPaginaDeInicio() {
        theActorInTheSpotlight().should(
                seeThat("Validar que la sesion cierre exitosamente", ValidarTexto.onValidar(LBL_LOGOUT_VALIDACION), equalTo(mensajeValidacionLogin))
        );
    }




}
