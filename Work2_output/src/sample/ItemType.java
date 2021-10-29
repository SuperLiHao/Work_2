package sample;

public class ItemType {

    public static ItemType HEAD = new ItemType(1); //头部
    public static ItemType CHEST = new ItemType(2); //胸甲
    public static ItemType KZ = new ItemType(3); //裤子
    public static ItemType XZ = new ItemType(4); //鞋子
    public static ItemType Sword = new ItemType(5); //武器

    int key;

    public ItemType(int key){
        this.key = key;
    }

}
