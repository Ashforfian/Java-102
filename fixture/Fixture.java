package fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Fixture {
    private ArrayList<String> clubs = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void start() {
        enterClubs();
        generateFixtures();
    }

    private void enterClubs() {
        int teamAmount = 1;
        while (true) {
            System.out.print((teamAmount++) + ". Takımı giriniz (Takım seçme işlemini bitirmek için 'q' giriniz!): ");
            String club = input.next();
            if (club.equals("q")) {
                break;
            }
            clubs.add(club);
        }
        if (clubs.size() % 2 != 0) {
            clubs.add("Bay");
        }
    }

    private void generateFixtures() {
        Collections.shuffle(clubs);
        int totalRounds = (clubs.size() - 1) * 2;
        int matchesPerRound = clubs.size() / 2;

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("Round: " + round);
            for (int match = 0; match < matchesPerRound; match++) {
                String homeClub = clubs.get(match);
                String awayClub = clubs.get(clubs.size() - 1 - match);
                System.out.println(homeClub + " VS " + awayClub);
            }
            rotateTeams(clubs);
            System.out.println();
        }
    }

    private void rotateTeams(ArrayList<String> clubs) {
        String last = clubs.remove(clubs.size() - 1);
        clubs.add(1, last);
    }
}
