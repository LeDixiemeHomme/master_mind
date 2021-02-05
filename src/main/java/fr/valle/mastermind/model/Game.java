package fr.valle.mastermind.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private Answerer answerer;
    private Sequence sequenceToGuess;
    private Sequence proposedSequence;
    private boolean won;

    public void compareSequences(Sequence seq1, Sequence seq2) throws Exception {
        this.setWon(this.answerer.compareSequences(seq1, seq2));
    }
}
