package fr.valle.mastermind.features;

import fr.valle.mastermind.model.Sequence;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class DefaultSequencesSteps {

    private final FeatureContext featureContext;

    public DefaultSequencesSteps(final FeatureContext featureContext) {
        this.featureContext = featureContext;
    }

    @Before("@default_sequences")
    public void defaultSequencesAreUsed() {
        List<Sequence> seqs = List.of(
                new Sequence("goal", List.of("red", "red", "red", "red")),
                new Sequence("fail_1", List.of("blue", "blue", "blue", "blue")),
                new Sequence("fail_2", List.of("red", "blue", "blue", "blue")),
                new Sequence("fail_3", List.of("red", "red", "blue", "blue")),
                new Sequence("fail_4", List.of("red", "red", "red", "blue")),
                new Sequence("success", List.of("red", "red", "red", "red")),
                new Sequence("recto", List.of("red", "blue", "green", "yellow")),
                new Sequence("verso", List.of("yellow", "green", "blue", "red")),
                new Sequence("sequence_5", List.of("green", "green", "yellow", "yellow")),
                new Sequence("sequence_6", List.of("yellow", "yellow", "yellow", "red")),
                new Sequence("sequence_7", List.of("yellow", "yellow", "red", "yellow"))
        );
        for (Sequence sequence: seqs) {
            featureContext.addSequencesToGameSequences(sequence);
        }
    }

    @Then("the available sequences should be at least:")
    public void theAvailableSequencesShouldBeAtLeast(List<Sequence> sequences) {
        Assertions.assertThat(featureContext.getContextSequences().hashCode()).isEqualTo(sequences.hashCode());
    }

    @DataTableType
    public Sequence convert(Map<String, String> table) {
        List<String> colors = List.of(
                table.get("color_1"),
                table.get("color_2"),
                table.get("color_3"),
                table.get("color_4"));
        return new Sequence(table.get("name"), colors);
    }
}
