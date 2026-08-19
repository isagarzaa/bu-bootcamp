import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        // Step 3: write and print report
        // finding highest and lowest scores
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
            if (score < min) {
                min = score;
            }
        }
        writeReport(scores, avg, max, min, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        int num = Integer.parseInt(line);
                        scores.add(num);
                    } catch (NumberFormatException e) {
                        
                        System.out.println("read a non-integer\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    } 
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            System.out.println("no valid scores were found");
            return 0.0;
        }
        else {
            double total = 0.0;
            for (int i = 0; i < scores.size(); i++) {
                total += scores.get(i);
            }
            return total / scores.size();
        }
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        if (scores.isEmpty()) {
            return;
        }

        // your code here
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // writing to the file
            writer.write("=== Grade Analysis Report ===\n");
            writer.write(String.format("Average score: %.2f%n", avg)); 
            writer.write(String.format("Highest score: %d%n", high));  
            writer.write(String.format("Lowest score: %d%n", low));  

            writer.write("\nGrade distribution:\n");
            writer.write(String.format("%4s%12s %2d%n", "A", "(90-100):", countA));
            writer.write(String.format("%4s%12s %2d%n", "B", "(80-89):", countB));
            writer.write(String.format("%4s%12s %2d%n", "C", "(70-79):", countC));
            writer.write(String.format("%4s%12s %2d%n", "D", "(60-69):", countD));
            writer.write(String.format("%4s%12s %2d%n", "F", "(below 60):", countF));

            // printing in terminal
            System.out.print("=== Grade Analysis Report ===\n");
            System.out.print(String.format("Average score: %.2f%n", avg)); 
            System.out.print(String.format("Highest score: %d%n", high));  
            System.out.print(String.format("Lowest score: %d%n", low));  

            System.out.print("\nGrade distribution:\n");
            System.out.print(String.format("%4s%12s %2d%n", "A", "(90-100):", countA));
            System.out.print(String.format("%4s%12s %2d%n", "B", "(80-89):", countB));
            System.out.print(String.format("%4s%12s %2d%n", "C", "(70-79):", countC));
            System.out.print(String.format("%4s%12s %2d%n", "D", "(60-69):", countD));
            System.out.print(String.format("%4s%12s %2d%n", "F", "(below 60):", countF));

        } catch (IOException e) {
            System.out.println("error writing");
        }
    }
}   