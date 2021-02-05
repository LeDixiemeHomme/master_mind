package fr.valle.mastermind.features;

import fr.valle.mastermind.model.Answerer;
import fr.valle.mastermind.model.Game;
import fr.valle.mastermind.model.Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeatureContext {

    private Game game = new Game();

    private List<Sequence> contextSequences = new ArrayList<>();

    public FeatureContext() {
        Answerer answerer = Answerer.builder().build();
        game.setAnswerer(answerer);
    }

    public void addSequencesToGameSequences(Sequence seq) {
        contextSequences.add(seq);
    }

    public Optional<Sequence> getSequence(final String sequenceName) {
        return contextSequences.stream().filter(s -> s.name().equals(sequenceName)).findAny();
    }

    public List<Sequence> getContextSequences() {
        return this.contextSequences;
    }


    public Game getGame() {
        return this.game;
    }
}
