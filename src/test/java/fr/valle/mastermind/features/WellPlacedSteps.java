package fr.valle.mastermind.features;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WellPlacedSteps {

    @Given("The color sequence to guess {string} {string} {string} {string}")
    public void theColorSequenceToGuess(String arg0, String arg1, String arg2, String arg3) {
    }

    @When("The colorF sequence proposed is {string} {string} {string} {string}")
    public void theColorFSequenceProposedIs(String arg0, String arg1, String arg2, String arg3) {
    }

    @Then("The number of correct but misplaced color should be equal to {int}")
    public void theNumberOfCorrectButMisplacedColorShouldBeEqualTo(int arg0) {
    }

//    @ParameterType("red|blue|yellow|green|black|white")  // regexp
//    public Color color(String color){  // type, name (from method)
//        return new Color(color);       // transformer function
//    }
//
//    @Given("The color sequence to guess {color} {color} {color} {color}")
//    public void theColorSequenceToGuessRedBlueBlueBlue(Color color1, Color color2, Color color3, Color color4) {
//    }
//
//    @When("The color sequence proposed is {color} {color} {color} {color}")
//    public void theColorSequenceProposedIsRedGreenGreenGreen(Color color1, Color color2, Color color3, Color color4) {
//    }
//
//    @Then("The number of well placed color should be equal to {int}")
//    public void theNumberOfWellPlacedColorShouldBeEqualTo(int arg0) {
//    }
}
