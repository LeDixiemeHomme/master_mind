package fr.valle.mastermind.features;

import fr.valle.mastermind.model.Answerer;
import fr.valle.mastermind.model.Game;
import fr.valle.mastermind.model.Sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeatureContext {

    private Game game = new Game(new Answerer(), List.of());

    public void addSequencesToGameSequences(Sequence seq){
        List<Sequence> sequences = new ArrayList<>(game.getSequences());
        sequences.add(seq);

        game = new Game(new Answerer(), sequences);
    }

    public List<Sequence> getSequences() { return game.getSequences(); }

    public Optional<Sequence> getSequence(final String sequenceName) {
        return game.getSequence(sequenceName);
    }

    public Game getGame() {
        return this.game;
    }
}
