package fr.valle.mastermind;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/fr/valle/mastermind/features"},
        glue = {"fr.valle.mastermind.features"},
        tags = "not @wip"
)
public class RunFeatureTest {
}
