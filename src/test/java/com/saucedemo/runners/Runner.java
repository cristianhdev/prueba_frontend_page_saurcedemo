package com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/saucedemo/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //tags = "@RemoverProductosDelCarrito",
        plugin= {
                "pretty",
                "html:target/site/cucumber-report.html",
                "json:target/site/cucumber.json"
        })
public class Runner {
}
