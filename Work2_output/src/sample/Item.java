package sample;

public class Item {

    public String name;
    public ItemType type;
    public int damage_add;
    public int hel_add;
    public int de_add;

    public Item( String name , ItemType type , int d,int h,int de ){
        this.name = name;
        this.type = type;
        this.damage_add = d;
        this.hel_add = h;
        this.de_add = de;
    }

    public ItemType getType(){
        return this.type;
    }

}
