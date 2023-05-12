package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileAnalyst {

    private Distribution fileDistribution;
    private List<String> wordsList;

    public fileAnalyst() {
        this.fileDistribution = new Distribution();
        this.wordsList = new ArrayList<>();
    }

    public void analyse(String text) {
        Distribution distribution = new Distribution();
        String filteredText = text.replace(".", ". ");
        filteredText = filteredText.toLowerCase().replaceAll("\\p{Punct}", "");
        String[] unfilteredWords = filteredText.split(" ");
        this.wordsList = Arrays.asList(unfilteredWords);
        

        // HashMapping the word and followers
        for (int i = 0; i < unfilteredWords.length - 1; i++) {
            String word = unfilteredWords[i];
            String follower = unfilteredWords[i + 1];

            if (!this.fileDistribution.getWordMap().keySet().contains(word)) {
                distribution.newEntry(word);
            }
            int c = distribution.getWordMap().get(word).computeIfAbsent(follower, count -> 0);
            distribution.getWordMap().get(word).put(follower, c + 1);
        }

        this.fileDistribution = distribution;
    }

    public void printAnalysis() {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String word = this.wordsList.get(i);
            String follower = this.wordsList.get(i+1);

            System.out.println(word);
            for (String key : this.fileDistribution.getWordMap().get(word).keySet()) {
                System.out.println("   " + key + " " + this.fileDistribution.probability(word, key));
            }
        }
    }
}
