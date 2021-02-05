package fr.valle.mastermind.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Answerer {

    private int numberWellPlaced;
    private int numberMisplaced;

    boolean compareSequences(Sequence sequenceToGuess, Sequence proposedSequence) throws Exception {
        if (sequenceToGuess.colors().size() != (proposedSequence.colors().size())) {
            throw new Exception("Sequences should be of the same size");
        }

        int numberWellPlaced = 0;
        int numberMisplaced = 0;
        int size = sequenceToGuess.colors().size();
        int[][] bannedSpots = new int[2][size];

        for (int i = 0; i < 2; i++) {
            for (int z = 0; z < size; z++) {
                bannedSpots[i][z] = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            if (proposedSequence.colors().get(i).equals(sequenceToGuess.colors().get(i))) {
                bannedSpots[0][i] = 1;
                bannedSpots[1][i] = 1;
                numberWellPlaced++;
            }
        }

        for (int i = 0; i < size; i++) {
            if (bannedSpots[0][i] == 0) {
                for (int j = 0; j < size; j++) {
                    if (proposedSequence.colors().get(i).equals(sequenceToGuess.colors().get(j)) && bannedSpots[1][j] == 0) {
                        bannedSpots[1][j] = 1;
                        numberMisplaced++;
                        break;
                    }
                }
            }
        }
        this.setNumberWellPlaced(numberWellPlaced);
        this.setNumberMisplaced(numberMisplaced);

        return (this.getNumberWellPlaced() == size);
    }
}
