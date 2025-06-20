public class Item {
    private String itemName;
    private int hpItem;
    private int strItem;
    private boolean consumable;

    public Item(String itemName, int hpItem, int strItem, boolean consumable){
        this.itemName = itemName;
        this.hpItem = hpItem;
        this.strItem = strItem;
        this.consumable = consumable;
    }
    public String getItemName(){
        return itemName;
    }
    public int getHpItem(){
        return hpItem;
    }
    public int getStrItem(){
        return strItem;
    }
    public boolean getConsumable(){
        return consumable;
    }

    }

