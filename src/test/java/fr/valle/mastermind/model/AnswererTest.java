package fr.valle.mastermind.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnswererTest {

    private Answerer answerer;
    private Sequence identical1;
    private Sequence identical2;
    private Sequence sizeOf2;
    private Sequence sizeOf4;

    @Before
    public void beforeTest() {
        this.answerer = Answerer.builder().build();
        this.identical1 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red", "green", "blue")).build();
        this.identical2 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red", "green", "blue")).build();
        this.sizeOf2 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red")).build();
        this.sizeOf4 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red", "green", "blue")).build();
    }

    @Test (expected = Exception.class)
    public void shouldCompareSequenceWithSameSize() throws Exception {
        answerer.compareSequences(sizeOf2, sizeOf4);
    }

    @Test
    public void should_won_be_false_then_be_true() throws Exception {
        assertFalse(answerer.isWon());
        answerer.compareSequences(identical1, identical2);
        assertTrue(answerer.isWon());
    }

    @Test
    public void should_won_be_false() {
        assertFalse(answerer.isWon());
    }

}
