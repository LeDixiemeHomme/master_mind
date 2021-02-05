package fr.valle.mastermind.features;

import fr.valle.mastermind.model.Sequence;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class ReturnNumbersSteps {

    private final FeatureContext featureContext;
    private Sequence sequenceToGuess;
    private Sequence proposedSequence;

    public ReturnNumbersSteps(FeatureContext featureContext) {
        this.featureContext = featureContext;
    }

    private Sequence getSequence(final String sequenceName) {
        return featureContext.getSequence(sequenceName).orElseThrow(() -> new IllegalArgumentException(sequenceName + " does not exist in board"));
    }

    @Given("The color sequence to guess {string}")
    public void theColorSequenceToGuess(String sequenceName) {
        this.sequenceToGuess = getSequence(sequenceName);
    }

    @And("The proposed color sequence {string}")
    public void theProposedColorSequence(String sequenceName) {
        this.proposedSequence = getSequence(sequenceName);
    }

    @When("The answerer compare the two sequences")
    public void theAnswererCompareTheTwoSequences() throws Exception {
        featureContext.getGame().compareSequences(sequenceToGuess, proposedSequence);
    }

    @Then("The number of well placed color returned should be equal to {int}")
    public void theNumberOfWellPlacedColorReturnedShouldBeEqualTo(int wellPlacedColorNumber) {
        Assertions.assertThat(featureContext.getGame().getAnswerer().getNumberWellPlaced()).isEqualTo(wellPlacedColorNumber);
    }

    @And("the number of correct but misplaced color returned should be equal to {int}")
    public void theNumberOfCorrectButMisplacedColorReturnedShouldBeEqualToNumberOf(int misplacedColorNumber) {
        Assertions.assertThat(featureContext.getGame().getAnswerer().getNumberMisplaced()).isEqualTo(misplacedColorNumber);
    }
}
