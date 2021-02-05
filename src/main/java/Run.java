import fr.valle.mastermind.model.Answerer;
import fr.valle.mastermind.model.Game;
import fr.valle.mastermind.model.Sequence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        List<String> emptyColors = new ArrayList<>();
        List<String> toFillColors = new ArrayList<>();
        Sequence toGuessSequence = new Sequence("empty", emptyColors);

        System.out.println("Entrez 'exit' pour quitter.");
        System.out.println("Il faut entrez les couleurs de la sequence secrete :");
        System.out.println("Il y a 4 places dans une séquence. Entrez une couleur et appyuez sur entrée. Cela 4 fois");
        System.out.println("Les différentes couleurs sont [red, blue, green, yellow].");

        while (toGuessSequence.colors().size() <= 3) {
            System.out.println("La séquence secrete contient : " + toFillColors.toString());
            if (toFillColors.size() <= 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("> ");

                String line = "";
                line += scanner.nextLine();

                if (line.equals("exit")) {
                    System.exit(0);
                } else {
                    toFillColors.add(line);
                }
            } else {
                toGuessSequence = new Sequence("secrete", toFillColors);
                toFillColors.clear();
            }
            System.out.println("");
        }


        System.out.println("Le jeu commence.");

        while (!game.isWon()) {
            Answerer answerer = Answerer.builder().build();
            Sequence proposedSequence = new Sequence("empty", emptyColors);
            System.out.println("Il faut maintenant entrez les couleurs de la sequence proposée");
            System.out.println("Il y a 4 places dans une séquence. Entrez une couleur et appyuez sur entrée. Cela 4 fois");
            System.out.println("Les différentes couleurs sont [red, blue, green, yellow].");

            while (proposedSequence.colors().size() < 4) {
                System.out.println("La séquence proposée contient : " + toFillColors.toString());
                if (toFillColors.size() <= 3) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("> ");

                    String line = "";
                    line += scanner.nextLine();

                    if (line.equals("exit")) {
                        System.exit(0);
                    } else {
                        toFillColors.add(line);
                    }
                } else {
                    proposedSequence = new Sequence("proposée", toFillColors);
                    toFillColors.clear();
                }
            }
            System.out.println("");

            game.setAnswerer(answerer);
            game.compareSequences(toGuessSequence, proposedSequence);
            System.out.println(toGuessSequence);
            System.out.println(proposedSequence);
            System.out.println("Il y a " + toGuessSequence.colors().size() + " couleurs dans la séquence");
            System.out.println("Il y a " + game.getAnswerer().getNumberMisplaced() + " bonnes couleurs mal placées");
            System.out.println("Il y a " + game.getAnswerer().getNumberWellPlaced() + " bonnes couleurs bien placées");
        }
        if (game.isWon()) {
            System.out.println("You win, GG");
        }
    }
}
