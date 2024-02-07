package Answer1a;

public class MinimumCostDecoration {

    // Method to find the minimum cost of decorating all venues while ensuring
    // neighboring venues have different themes
    public static int findMinimumCost(int[][] venueThemes) {
      //  if the input array is empty or null
      if (venueThemes == null || venueThemes.length == 0 || venueThemes[0].length == 0) {
        return 0; // Return 0 if there no venue or themes
      }
  
      // the number of venues and themes
      int numVenues = venueThemes.length;
      int numThemes = venueThemes[0].length;
  
      //  an array to store the minimum costs
      int[][] minCosts = new int[numVenues][numThemes];
  
      // Init the first row of the minCosts array with the costs of decorating
      // the first venue with each theme
      System.arraycopy(venueThemes[0], 0, minCosts[0], 0, numThemes);
  
      // Iterate through each venue starting from the second one
      for (int venueIndex = 1; venueIndex < numVenues; venueIndex++) {
        
        for (int themeIndex = 0; themeIndex < numThemes; themeIndex++) {
          // Initialize the cost of decorating the current venue with the current theme to
          // the maximum value
          minCosts[venueIndex][themeIndex] = Integer.MAX_VALUE;
          // Iterate through each theme for the previous venue
          for (int prevThemeIndex = 0; prevThemeIndex < numThemes; prevThemeIndex++) {
            // Check if theme for the current venue is different from the theme for the
            // previous venue
            if (prevThemeIndex != themeIndex) {
              // Update minimum cost of decorating the current venue with the current
              // theme
              minCosts[venueIndex][themeIndex] = Math.min(minCosts[venueIndex][themeIndex],
                  minCosts[venueIndex - 1][prevThemeIndex]);
            }
          }
          // Add the cost of decorating the current venue with the current theme
          minCosts[venueIndex][themeIndex] += venueThemes[venueIndex][themeIndex];
        }
      }
  
      // Find the minimum cost among the last row of the minCosts array
      int minCost = Integer.MAX_VALUE;
      for (int cost : minCosts[numVenues - 1]) {
        minCost = Math.min(minCost, cost);
      }
  
      // Return minimum cost
      return minCost;
    }
  
    // Main method for testing
    public static void main(String[] args) {
      // Example input
      int[][] venueThemes = { { 1, 3, 2 }, { 4, 6, 8 }, { 3, 1, 5 } };
      // Call the findMinimumCost method and print the result
      int minCost = findMinimumCost(venueThemes);
      System.out.println("The minimum cost of venue decoration is: " + minCost); 
      
      // The minimum cost of venue decoration
         // is: 7 // output : 
    }
}
