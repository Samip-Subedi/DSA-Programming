package Answer1b;

// Calculates the total time to build engines considering split cost.
public class EngineBuilder {
    // Calculates the minimum time required to build engines.
    public static int minTimeToBuild(int[] engines, int splitCost) {
        int totalTime = 0;
        // Iterates through each engine.
        for (int engineTime : engines) {
            // Checks if splitting the engine is beneficial.
            if (splitCost + engineTime / 2 < engineTime) {
                totalTime += splitCost; // Adds split cost if beneficial.
            } else {
                totalTime += engineTime; // Adds original engine time.
            }
        }
        return totalTime; // Returns total time.
    }
  
    // Main method for testing.
    public static void main(String[] args) {
        int[] engines = {1, 2, 3}; // Engine build times.
        int splitCost = 1; // Cost of splitting an engine.
        System.out.println(minTimeToBuild(engines, splitCost)); // Prints minimum time to build all engines.
    }
  }
  