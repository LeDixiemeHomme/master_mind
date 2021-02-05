package fr.valle.mastermind.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
public class AnswererTest {

    @Test
    void shouldCompareSequenceWithSameSize() throws Exception {
        final Sequence sequence1 = new Sequence("sequence_1", List.of("blue", "red", "green", "blue"));
        final Sequence sequence2 = new Sequence("sequence_2", List.of("blue", "red", "green", "blue"));
    }

    @Test
    void should_won_be_true() throws Exception {
        final Sequence sequence1 = new Sequence("sequence_1", List.of("blue", "red", "green", "blue"));
        final Sequence sequence2 = new Sequence("sequence_2", List.of("blue", "red", "green", "blue"));

//        answer

//        Assertions.assertThat()
    }

}
