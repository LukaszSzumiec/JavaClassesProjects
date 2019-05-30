package first.chess;

public interface FulfilmentCenterInterface
{
    void search(String searcherName);
    void searchPartial(String searchedName);
    int countByCondition(Item.itemCondition aNew);
    void summary();
    void sortByName();
    void sortByAmount();
    void addProduct(Item item);
    void max();

}
