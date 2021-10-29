package sample;

import sample.Inventory;
import sample.Item;

public class Player {

    String name;
    int health = 1;
    int damage = 0;
    int defence = 0;
    Inventory bag;

    public boolean situaion;

    Item H;//头部
    Item C;//xiong
    Item K;//KZ
    Item X;//XZ
    Item S;//sword

    public Player(String name , int health , int damage , int defence){

            this.name = name;
            this.health = health;
            this.damage = damage;
            this.defence = defence;

            this.situaion = true;

            this.bag = new Inventory( 10 , name + "  的背包" );
            bag.addItem( new Item( "测试小刀" , ItemType.Sword , 100,1,0 ) );
    }

    public void setName(String name){
        this.name = name;
        return;
    }
    public void setDamage( int d ){
        this.damage = d;
    }
    public void setHealth (int h){
        this.health = h;
    }
    public void setDefence(int d){
        this.defence = d;
    }

    public int getHealth(){
        return this.health;
    }

    public String getName(){
        return this.name;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getDefence(){
        return this.defence;
    }

    public Inventory getBag(){
        return  this.bag;
    }

    public Item getC() {
        return C;
    }

    public Item getH() {
        return H;
    }

    public Item getK() {
        return K;
    }

    public Item getS() {
        return S;
    }

    public Item getX() {
        return X;
    }

    public void setC(Item c) {
        C = c;
    }

    public void setH(Item h) {
        H = h;
    }

    public void setK(Item k) {
        K = k;
    }

    public void setS(Item s) {
        S = s;
    }

    public void setX(Item x) {
        X = x;
    }
}
