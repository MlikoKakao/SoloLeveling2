import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> stats = StatsUtil.loadStats();
        List<Item> inventory = InventoryUtil.loadInventory();


        System.out.println("HP, MP, STR, VIT, AGL, INTEL, SNS");

        for(int i=0;i<5;i++)
        {
            boolean pointsAdded = false;
            while (!pointsAdded) {
                System.out.print("Which stat would you like to increase? You have " + (5 - i) + " points remaining: ");
                String input = scanner.next().toLowerCase().trim();

                if (input.equals("reset")) {
                    StatsUtil.resetStats(stats);
                    StatsUtil.saveStats(stats);
                    pointsAdded = true;
                    i = 5;
                    continue;
                }

                switch (input) {
                    case "hp":
                    case "mp":
                    case "str":
                    case "vit":
                    case "agl":
                    case "intel":
                    case "sns":
                        stats.put(input, stats.get(input) + 1);
                        System.out.println("You increased your " + input.toUpperCase() + " by 1!");
                        pointsAdded = true;
                        break;
                    default:
                        System.out.println("Invalid stat. Try again.");
                        break;
                }
            }

        }

            StatsUtil.saveStats(stats);

            System.out.println("Updated stats: ");
            List<String> customOrder = List.of("hp", "mp", "str", "vit", "agl", "intel", "sns");


            for (String stat : customOrder) {
                String fullName = StatsUtil.getFullStatName(stat);
                System.out.print(fullName +": " + stats.get(stat)+" \n");
            }
        }


    }


