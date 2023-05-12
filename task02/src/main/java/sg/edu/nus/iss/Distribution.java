package sg.edu.nus.iss;

import java.util.HashMap;
import java.util.Map;

public class Distribution {

    private Map<String, Map<String, Integer>> wordMap;

    public Distribution() {
        this.wordMap = new HashMap<>();
    }

    public void newEntry(String word) {
        this.wordMap.put(word, new HashMap<>());
    }

    //access inner map of followers
    public Map<String, Integer> getFollowers(String word) {
        return this.wordMap.get(word);
    }

    //get probability
    public float probability(String word, String follower) {
        int followerCount = 0;
        for (int count : this.wordMap.get(word).values()) {
            followerCount += count;
        }

       float probability = (this.wordMap.get(word).get(follower)) / followerCount * 1.00f;
       return probability;
    }

    public Map<String, Map<String, Integer>> getWordMap() {
        return this.wordMap;
    }

    





    



    
    
}
