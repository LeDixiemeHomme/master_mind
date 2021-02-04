package fr.valle.mastermind.model;

import java.util.List;
import java.util.Objects;

public class Sequence{

//    private List<Color> colors;
//
//    public Sequence(List<Color> colors){
//        this.colors = colors;
//    }
//
//    public List<Color> getColors() {
//        return colors;
//    }
//
//    public void setColors(List<Color> colors) {
//        this.colors = colors;
//    }

    private final String name;
    private final List<String> colors;

    public Sequence(String name, List<String> colors){
        this.name = name;
        this.colors = colors;
    }

    public List<String> colors() {
        return colors;
    }

    public String name() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, colors);
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "name='" + name + '\'' +
                ", colors=" + colors +
                '}';
    }
}
