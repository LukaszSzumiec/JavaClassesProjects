package first.chess;

import javax.swing.*;
import java.util.Comparator;

public class Item extends Object implements Print, Comparable<Item> {

    @Override
    public int compareTo(Item i) {
        if(i == null) return Integer.parseInt(null);
        try {
            if(i instanceof Item){
                return this.name.compareTo(i.name);
            }
                throw new Exception("That is not a item.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -1;
    }
    public int compareByAmount(Item item){
        if(amount > item.amount)
            return 1;
        if(amount == item.amount)
            return 0;
        else
            return -1;
    }

    public void increaseWeight(double weight) {
        this.weight += weight;
    }

    public void increaseAmount() {
        amount++;
    }

    public void decreaseWeight(double weight) {
        this.weight -= weight;
    }

    public double getWeight(){
        return this.weight;
    }

    public String getName(){
        return this.name;
    }

    public double getAmount(){
        return amount;
    }

    public void decreaseAmount(){
        amount--;
    }
    public enum itemCondition{NEW, USED, REFURBISHED};
    protected itemCondition condition;
    private  String name;
    private double amount;
    private double weight;

    Item(String name, double amount, double weight, itemCondition condition){
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        this.condition = condition;
    }
    Item(){

    }
    @Override
    public void Print() {
        System.out.println("Item name: " + name);
        System.out.println("\t Amount of items: " + amount);
        System.out.println("\t Weight of single item: " + weight);
        System.out.println("\t Item condition: " + condition);
    }
}
