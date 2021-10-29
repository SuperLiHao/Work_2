package sample;

public class XiaoBin {

    public int health;
    public int damage;
    public int defence;
    public boolean situation;//存活状态
    public String name;

    public XiaoBin(String name ,int health,int damage,int defence){

        if ( name.length() <= 20 )
         this.name = name;
        else this.name = name.substring(20);
        if ( damage > 999 )
            this.damage = damage%999;
        else
             this.damage = damage;
        if ( health > 500 )
            this.health = health%500;
        else
            this.health = health;

        this.defence = defence;

        this.situation = true;
        return;
    }


    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
