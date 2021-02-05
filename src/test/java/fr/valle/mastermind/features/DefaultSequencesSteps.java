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
        final Sequence goal = new Sequence("goal", List.of("red", "red", "red", "red"));
        final Sequence fail_1 = new Sequence("fail_1", List.of("blue", "blue", "blue", "blue"));
        final Sequence fail_2 = new Sequence("fail_2", List.of("red", "blue", "blue", "blue"));
        final Sequence fail_3 = new Sequence("fail_3", List.of("red", "red", "blue", "blue"));
        final Sequence fail_4 = new Sequence("fail_4", List.of("red", "red", "red", "blue"));
        final Sequence success = new Sequence("success", List.of("red", "red", "red", "red"));
        final Sequence recto = new Sequence("recto", List.of("red", "blue", "green", "yellow"));
        final Sequence verso = new Sequence("verso", List.of("yellow", "green", "blue", "red"));
        final Sequence sequence_5 = new Sequence("sequence_5", List.of("green", "green", "yellow", "yellow"));
        final Sequence sequence_6 = new Sequence("sequence_6", List.of("yellow", "yellow", "yellow", "red"));
        final Sequence sequence_7 = new Sequence("sequence_7", List.of("yellow", "yellow", "red", "yellow"));
        featureContext.addSequencesToGameSequences(goal);
        featureContext.addSequencesToGameSequences(fail_1);
        featureContext.addSequencesToGameSequences(fail_2);
        featureContext.addSequencesToGameSequences(fail_3);
        featureContext.addSequencesToGameSequences(fail_4);
        featureContext.addSequencesToGameSequences(success);
        featureContext.addSequencesToGameSequences(recto);
        featureContext.addSequencesToGameSequences(verso);
        featureContext.addSequencesToGameSequences(sequence_5);
        featureContext.addSequencesToGameSequences(sequence_6);
        featureContext.addSequencesToGameSequences(sequence_7);
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
