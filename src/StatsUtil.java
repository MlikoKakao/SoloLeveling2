import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatsUtil {
    public static String getFullStatName(String shortName) {
        switch(shortName) {
            case "hp": return "HP";
            case "mp": return "MP";
            case "str": return "Strength";
            case "vit": return "Vitality";
            case "agl": return "Agility";
            case "intel": return "Intelligence";
            case "sns": return "Sense";
            default: return shortName.toUpperCase();
        }
    }

    public static Map<String, Integer> loadStats() {

        Map<String, Integer> stats = new HashMap<>();
        String[] keys = {"hp","mp","str","vit","agl","intel","sns"};
        for (String key : keys) stats.put(key, 0);

        File file = new File("stats.txt");
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String [] parts = fileScanner.nextLine().split(":");
                    if (parts.length == 2) stats.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
                }
            } catch (Exception e) {
                System.out.println("Error loading stats: " + e.getMessage());
            }
        }
        return stats;
    }
    public static void saveStats(Map<String, Integer> stats) {
        try (PrintWriter writer = new PrintWriter("stats.txt")){
            for (Map.Entry<String, Integer> entry: stats.entrySet()) {
                writer.println(entry.getKey()+": "+entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error saving stats: " + e.getMessage());
        }
    }
    public static void resetStats(Map<String, Integer> stats) {
        for (String key : stats.keySet()) {
            stats.put(key, 0);
        }
        System.out.println("Stats have been reset to 0");
    }
}

