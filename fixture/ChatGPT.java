package fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChatGPT {
    private List<String> teams;
    private List<String> fixtures;

    public ChatGPT(List<String> teams) {
        this.teams = new ArrayList<>(teams);
        this.fixtures = new ArrayList<>();
    }

    public List<String> generateFixtures() {
        // Takım sayısı tekse "Bay" takımını ekleyelim
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        // Takımları karıştıralım
        Collections.shuffle(teams);
        System.out.println(teams);
        int numTeams = teams.size();
        int numRounds = (numTeams - 1) * 2;
        int matchesPerRound = numTeams / 2;

        for (int round = 1; round <= numRounds; round++) {
            for (int match = 0; match < matchesPerRound; match++) {
                int homeIndex = match;
                int awayIndex = (numTeams - 1 - match + round) % (numTeams - 1);
                String fixture = teams.get(homeIndex) + " vs " + teams.get(awayIndex);
                fixtures.add("Round " + round + ": " + fixture);
            }
        }

        return fixtures;
    }

    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");
        teams.add("Eskişehirspor");

        ChatGPT generator = new ChatGPT(teams);
        List<String> fixtures = generator.generateFixtures();
        for (String fixture : fixtures) {
            System.out.println(fixture);
        }
    }
}

