package fr.valle.mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class Answerer {

    private int numberWellPlaced;
    private int numberMisplaced;

    public int numberWellPlaced() {
        return numberWellPlaced;
    }

    public int numberMisplaced() {
        return numberMisplaced;
    }

    private void setNumberWellPlaced(int number){
        this.numberWellPlaced = number;
    }

    private void setNumberMisplaced(int number){
        this.numberMisplaced = number;
    }

    // TODO faire l'algo qui prend 2 Sequence et renvoie deux int en fonction
    void compareSequences(Sequence sequenceToGuess, Sequence proposedSequence){
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
    }

}
