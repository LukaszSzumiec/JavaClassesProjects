package first.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FulfillmentCenter extends Item implements FulfilmentCenterInterface  {

    private final String nameOfWarehouse;
    private List<Item> itemsList;
    private double totalWeight;
    private final double MAX_WEIGHT;

    @Override
    public void search(String searcherName) {
        int a = 0;
        for(Item item : itemsList){

            if(item.getName().equals(searcherName)){
                a = itemsList.indexOf(item);
                System.out.println("Item found");
            }
        }
        System.out.println(a);
    }


    @Override
    public void searchPartial(String searchedName) {
        for(Item item : itemsList){
            String _name = item.getName();
            if(_name.contains(searchedName)){
                System.out.println(item.getName());
            }
        }
    }

    @Override
    public int countByCondition(Item.itemCondition aNew) {
        int counter = 0;
        for(Item item1 : itemsList){
            if(item1.condition == aNew){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void summary() {
        int counter = 1;
        for(Item item : itemsList){
            System.out.println("\nItem number: " + counter);
            System.out.println("Name:" + item.getName());
            System.out.println("Total weight of items: " + item.getWeight());
            System.out.println("Weight of single item: " + item.getWeight()/item.getAmount());
            System.out.println("Amount of items: " + item.getAmount());
            counter++;
        }
    }

    @Override
    public void sortByName() {
             Collections.sort(itemsList,Item::compareTo);
             summary();
    }

    @Override
    public void sortByAmount() {
        Collections.sort(itemsList,Item::compareByAmount);
        Collections.reverse(itemsList);
        summary();
    }

    @Override
    public void addProduct(Item item) {
        try {

            if(MAX_WEIGHT < totalWeight+item.getWeight())
                throw new Exception("Warehouse is full");
            for(Item item1 : itemsList){
                if(item1.getName().equals(item.getName())){
                    double weight = item1.getWeight();
                    weight += item.getWeight();
                    item1.increaseWeight(weight);
                    item1.increaseAmount();
                    System.out.println("The same items");
                    return;
                }
            }

            itemsList.add(item);
        }
        catch (Exception e){
            System.out.println("Warehouse is full.");
        }
        System.out.println("Size of list: " + itemsList.size());
    }

    @Override
    public void max() {
        Collections.max(itemsList,Item::compareByAmount).Print();
    }

    public Item getProduct(Item item) {
        if(item.getAmount() == 1) {
            itemsList.remove(item);
            return item;
        }
        else {
            double weight = item.getWeight();
            weight  /= item.getAmount();
            item.decreaseWeight(weight);
            item.decreaseAmount();
            return item;
        }
    }

    public static class Builder {

        private final String nameOfWarehouse;
        private final double MAX_WEIGHT;

        public Builder(String nameOfWarehouse, double MAX_WEIGHT) {
            this.nameOfWarehouse = nameOfWarehouse;
            this.MAX_WEIGHT = MAX_WEIGHT;
        }

        public FulfillmentCenter build()
        {
            return new FulfillmentCenter(this);
        }
    }

    private FulfillmentCenter(Builder builder) {
        nameOfWarehouse = builder.nameOfWarehouse;
        MAX_WEIGHT = builder.MAX_WEIGHT;
        totalWeight = 0;
        itemsList = new ArrayList<>();
    }
}
