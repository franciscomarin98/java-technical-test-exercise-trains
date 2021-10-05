package trains;

import java.util.HashMap;
import java.util.Map;



public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Number>> routesAndDistance = new HashMap<>();

        routesAndDistance.put("A", new HashMap<>() {{
            put("B", 5);
            put("D", 5);
            put("E", 7);
        }});

        routesAndDistance.put("B", new HashMap<>() {{
            put("C", 4);
        }});

        routesAndDistance.put("C", new HashMap<>() {{
            put("D", 8);
            put("E", 2);
        }});

        routesAndDistance.put("D", new HashMap<>() {{
            put("C", 8);
            put("E", 6);
        }});

        routesAndDistance.put("E", new HashMap<>() {{
            put("B", 3);
        }});

        Train train = new Train(routesAndDistance);
        System.out.println(routesAndDistance);

        train.calculateDistance(new String[]{"A","B","C"});
        train.calculateDistance(new String[]{"A","D"});
        train.calculateDistance(new String[]{"A","D","C"});
        train.calculateDistance(new String[]{"A","E","B","C","D"});
        train.calculateDistance(new String[]{"A","E","D"});
    }
}
