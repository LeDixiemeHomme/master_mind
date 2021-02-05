package fr.valle.mastermind.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnswererTest {

    private Game game;
    private Answerer answerer;
    private Sequence identical1;
    private Sequence identical2;
    private Sequence sizeOf2;
    private Sequence sizeOf4;

    @Before
    public void beforeTest() {
        this.game = new Game();
        this.answerer = Answerer.builder().build();
        this.identical1 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red", "green", "blue")).build();
        this.identical2 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red", "green", "blue")).build();
        this.sizeOf2 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red")).build();
        this.sizeOf4 = Sequence.builder().name("sequence_1").colors(List.of("blue", "red", "green", "blue")).build();
    }

    @Test (expected = Exception.class)
    public void shouldCompareSequenceWithSameSize() throws Exception {
//        game.setAnswerer(answerer);
        game.compareSequences(answerer, sizeOf2, sizeOf4);
    }

    @Test
    public void should_won_be_false_then_be_true() throws Exception {
//        game.setAnswerer(answerer);
        assertFalse(game.isWon());
        game.compareSequences(answerer,identical1, identical2);
        assertTrue(game.isWon());
    }

    @Test
    public void should_won_be_false() {
        assertFalse(game.isWon());
    }

}
