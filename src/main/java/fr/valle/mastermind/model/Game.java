package fr.valle.mastermind.model;

import java.util.List;
import java.util.Optional;

public class Game {

    private final Answerer answerer;
    private final List<Sequence> sequences;

    public Game(Answerer answerer, List<Sequence> sequences) {
        this.answerer = answerer;
        this.sequences = sequences;
    }

    public List<Sequence> getSequences() {
        return sequences;
    }
    public Optional<Sequence> getSequence(final String sequenceName) {
        return sequences.stream().filter(s->s.name().equals(sequenceName)).findAny();
    }

    public Answerer getAnswerer() {
        return answerer;
    }

    public void compareSequences(Answerer answerer, Sequence seq1, Sequence seq2){
        answerer.compareSequences(seq1, seq2);
    }
}