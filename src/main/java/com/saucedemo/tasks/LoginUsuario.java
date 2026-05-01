package com.saucedemo.tasks;

import com.saucedemo.interactions.ClickElemento;
import com.saucedemo.interactions.EnterElemento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.saucedemo.UI.LoginPageUI.*;

public class LoginUsuario implements Task {

    private String username;
    private String password;


    public LoginUsuario(String username, String password) {
        this.username = username;
        this.password = (password == null || password.isBlank())
                ? ""
                : password;;
    }

    @Override
    @Step("{0} ingresa las credenciales '#username' y '#password'")
    public <T extends Actor> void performAs(T actor) {

        try{
            actor.attemptsTo(

                    EnterElemento.onCampo(INPUT_TEXT_USERNAME,this.username),
                    EnterElemento.onCampo(INPUT_TEXT_PASSWORD,this.password),
                    ClickElemento.onElemento(BTN_LOGIN)
            );

            //Guardamos el usaurio que ha realizado login
            actor.remember("username",this.username);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static LoginUsuario onFormularioLogin(String username,String password){
        return Tasks.instrumented(LoginUsuario.class,username,password);
    }
}
