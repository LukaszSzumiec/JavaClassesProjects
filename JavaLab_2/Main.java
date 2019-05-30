package first.chess;

public class Main {

    public static void main(String[] args) {
        Item item = new Item("asdf",1, 12, Item.itemCondition.NEW);
        Item kappa = new Item("assdf", 1, 12, Item.itemCondition.NEW);
        FulfillmentCenter warehouseOne = new FulfillmentCenter.Builder("warehouse", 500000).build();
        item.Print();
        warehouseOne.addProduct(item);
        warehouseOne.addProduct(kappa);

        FulfillmentCenter id = new FulfillmentCenter.Builder("asdf", 5000).build();

        FulfillmentCenterContainer container = new FulfillmentCenterContainer("JD");

        container.addCenter(id.getName(), id);



        System.out.println(item.compareTo(kappa));
    }
}
