package sample;

import sample.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public int size;
    public String title;
    public List<Item> items = new ArrayList<>();

    public Inventory(int size,String title){

        this.size = size;
        this.title = title;

    }

    public List<Item> getItems(){
        return  this.items;
    }

    public void addItem(Item i){
        items.add(i);
        return;
    }

}
