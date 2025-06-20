import java.util.List;
import java.util.Map;

public class Player {
    private Map<String, Integer> stats;
    private List<Item> inventory;

public Player(Map<String, Integer> stats, List<Item> inventory){
    this.stats = stats;
    this.inventory = inventory;
}

public Map<String, Integer> getStats(){
    return stats;
}

public List<Item> getInventory(){
    return inventory;
}

}