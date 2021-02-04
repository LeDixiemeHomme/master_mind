package fr.valle.mastermind.features;

import fr.valle.mastermind.model.Sequence;
import io.cucumber.datatable.DataTable;
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
        final Sequence sequence_1 = new Sequence("sequence_1", List.of("blue", "red", "green", "blue"));
        final Sequence sequence_2 = new Sequence("sequence_2", List.of("green", "red", "yellow", "yellow"));
        final Sequence sequence_3 = new Sequence("sequence_3", List.of("green", "red", "yellow", "yellow"));
        final Sequence sequence_4 = new Sequence("sequence_4", List.of("green", "green", "green", "green"));
        final Sequence sequence_5 = new Sequence("sequence_5", List.of("green", "yellow", "yellow", "yellow"));
        final Sequence sequence_6 = new Sequence("sequence_6", List.of("yellow", "red", "red", "red"));
        featureContext.addSequencesToGameSequences(sequence_1);
        featureContext.addSequencesToGameSequences(sequence_2);
        featureContext.addSequencesToGameSequences(sequence_3);
        featureContext.addSequencesToGameSequences(sequence_4);
        featureContext.addSequencesToGameSequences(sequence_5);
        featureContext.addSequencesToGameSequences(sequence_6);
    }

    @Then("the available sequences should be at least:")
    public void theAvailableSequencesShouldBeAtLeast(List<Sequence> sequences) {
        Assertions.assertThat(featureContext.getSequences().hashCode()).isEqualTo(sequences.hashCode());
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
