package first.chess;

import java.util.HashMap;
import java.util.Map;

public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> map;

    public FulfillmentCenterContainer(String name){
        map = new HashMap<String, FulfillmentCenter>();
    }

    public void addCenter(String name, FulfillmentCenter center){
        map.put(name,center);
    }

    public void removeCenter(String name){
        map.remove(name);
    }
    public void findEmpty(){
       // for(FulfillmentCenter center : map)
    }
}
