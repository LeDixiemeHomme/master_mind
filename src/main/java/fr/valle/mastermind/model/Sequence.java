package fr.valle.mastermind.model;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sequence {

    private final String name;
    private List<String> colors;
    private final List<String> validColors = List.of("red", "blue", "green", "yellow");

    @Builder
    public Sequence(String name, List<String> colors) {
        this.name = name;
        this.colors = validColorList(colors);
    }

    public List<String> colors() {
        return colors;
    }

    public String name() {
        return name;
    }

    private List<String> validColorList(List<String> uncheckedColors) {
        List<String> temp = new ArrayList<>();

        for (String color : uncheckedColors) {
            try {
                temp.add(this.isValidColor(color));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return temp;
    }

    private String isValidColor(String color) throws Exception {
        if (validColors.contains(color.toLowerCase().strip())) {
            return color.toLowerCase().strip();
        } else {
            throw new Exception("The value " + color + " is not a correct color, you can choose between those value [red, blue, green, yellow].\n" +
                    "Retry please.");
        }
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
