package fr.valle.mastermind.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Builder public class Answerer {

    private int numberWellPlaced;
    private int numberMisplaced;
    private boolean won;

    void compareSequences(Sequence sequenceToGuess, Sequence proposedSequence) throws Exception {
        if(sequenceToGuess.colors().size() != (proposedSequence.colors().size())){
            throw new Exception("Sequences should be of the same size");
        }

        int numberWellPlaced = 0;
        int numberMisplaced = 0;
        int size = sequenceToGuess.colors().size();
        List<Integer> bannedSpots = new ArrayList<>();

        for(int i = 0; i < size; i++){
            if(proposedSequence.colors().get(i).equals(sequenceToGuess.colors().get(i))){
                bannedSpots.add(i);
                numberWellPlaced++;
            }else {
                for(int j = 0; j < size; j++){
                    if(proposedSequence.colors().get(i).equals(sequenceToGuess.colors().get(j)) && !bannedSpots.contains(j)){
                        bannedSpots.add(j);
                        numberMisplaced++;
                        break;
                    }
                }
            }
        }
        this.setNumberWellPlaced(numberWellPlaced);
        this.setNumberMisplaced(numberMisplaced);

        this.setWon(this.getNumberWellPlaced() == size);
    }
}
