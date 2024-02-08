package Answer2b;

// Summary:
//   This program models a secret-sharing process among a group of individuals, each identified by a unique ID. The process involves specific time intervals during which the secret can be shared. The objective is to determine the individuals who eventually know the secret after all sharing intervals.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecretSharing {

  // Method to find the eventual secret recipients
  public static List<Integer> findSecretRecipients(int totalIndividuals, int[][] sharingIntervals, int initialPerson) {
    // Set to store the individuals who eventually know the secret
    Set<Integer> secretRecipients = new HashSet<>();
    // Add the initial person who initially holds the secret
    secretRecipients.add(initialPerson);

    // Iterate through each sharing interval
    for (int[] interval : sharingIntervals) {
      int intervalStart = interval[0]; // Start time of the interval
      int intervalEnd = interval[1]; // End time of the interval

      // Check if the initial person shares the secret during this interval
      if (intervalStart <= initialPerson && initialPerson <= intervalEnd) {
        // If the initial person shares the secret during this interval,
        // add all individuals to the set of secret recipients
        for (int i = 0; i < totalIndividuals; i++) {
          secretRecipients.add(i);
        }
      }
    }

    // Convert the set to a list and return it
    return new ArrayList<>(secretRecipients);
  }

  public static void main(String[] args) {
    // Define the total number of individuals
    int totalIndividuals = 5;
    // Define the sharing intervals
    int[][] sharingIntervals = { { 0, 2 }, { 1, 3 }, { 2, 4 } };
    // Define the initial person who possesses the secret
    int initialPerson = 0;

    // Find the set of secret recipients
    List<Integer> secretRecipients = findSecretRecipients(totalIndividuals, sharingIntervals, initialPerson);

    // Print the set of secret recipients
    System.out.println("Individuals who eventually know the secret:");
    for (int recipient : secretRecipients) {
      System.out.print(recipient + " ");
    }
  }
}
