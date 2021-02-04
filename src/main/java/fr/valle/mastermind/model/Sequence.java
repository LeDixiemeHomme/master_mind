package fr.valle.mastermind.model;

import java.util.List;

public class Sequence{

    private List<Color> colors;

    public Sequence(List<Color> colors){
        this.colors = colors;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
}
