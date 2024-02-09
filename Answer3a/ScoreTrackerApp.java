package Answer3a;

// Summary:
// The task requires implementing a ScoreTracker class to manage student scores and compute the median score from a stream of assignment scores. The class should offer methods to initialize a new ScoreTracker object, add new assignment scores to the data stream, and retrieve the median score. In cases where the count of scores is even, the median should represent the average of the two middle scores.

// Solution Overview:
// The ScoreTrackerApp class is implemented using an ArrayList to store assignment scores. Upon adding a new score, the ArrayList is sorted to maintain order. The getMedianScore method calculates the median based on the sorted list of scores, handling both even and odd counts of scores. The class is demonstrated with example inputs in the main method.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreTrackerApp {
    private List<Double> scores; // ArrayList to store assignment scores

    // Constructor to initialize a new ScoreTracker object
    public ScoreTrackerApp() {
        scores = new ArrayList<>();
    }

    // Method to add a new assignment score to the data stream
    public void addScore(double score) {
        scores.add(score); // Add the score to the ArrayList
        Collections.sort(scores); // Sort the ArrayList
    }

    // Method to calculate and return the median of all assignment scores in the data stream
    public double getMedianScore() {
        int size = scores.size();
        if (size == 0) {
            throw new IllegalStateException("No scores available.");
        }

        int middleIndex = size / 2; // Index of the middle score

        // Check if the number of scores is even
        if (size % 2 == 0) {
            // If even, calculate the average of the two middle scores
            double lowerMedian = scores.get(middleIndex - 1);
            double upperMedian = scores.get(middleIndex);
            return (lowerMedian + upperMedian) / 2.0;
        } else {
            // If odd, return the middle score
            return scores.get(middleIndex);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        ScoreTrackerApp scoreTracker = new ScoreTrackerApp();
        scoreTracker.addScore(85.5);
        scoreTracker.addScore(92.3);
        scoreTracker.addScore(77.8);
        scoreTracker.addScore(90.1);
        double median1 = scoreTracker.getMedianScore();
        System.out.println("Median score 1: " + median1);

        scoreTracker.addScore(81.2);
        scoreTracker.addScore(88.7);
        double median2 = scoreTracker.getMedianScore();
        System.out.println("Median score 2: " + median2);
    }
}
