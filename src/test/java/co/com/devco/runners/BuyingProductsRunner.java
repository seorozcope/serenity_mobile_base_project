package co.com.devco.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/buying_products.feature",
        glue = "co.com.devco.stepdefinitions",
        snippets = CAMELCASE,
        tags = "@BuyProducts"
)
public class BuyingProductsRunner {
}
