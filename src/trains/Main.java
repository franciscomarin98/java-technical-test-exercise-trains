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

        train.calculateDistance(new String[]{"A", "B", "C"});
        train.calculateDistance(new String[]{"A", "D"});
        train.calculateDistance(new String[]{"A", "D", "C"});
        train.calculateDistance(new String[]{"A", "E", "B", "C", "D"});
        train.calculateDistance(new String[]{"A", "E", "D"});

        train.calculateNumbersOfTrips("C", "C", 3, routesAndDistance);
        train.calculateNumbersOfTrips("A", "C", 4, routesAndDistance);

        Graph graph = new Graph();

        graph.shortestPath("A", "C", 0);
        System.out.println("The length of the shortest route (in terms of distance to travel) from A to C is: " + graph.bestCost);

        graph.shortestPath("B", "B", 0);
        System.out.println("The length of the shortest route (in terms of distance to travel) from B to B is: " + graph.bestCost);

        System.out.println("The number of different routes from C to C with a distance of less than 30 is: " + graph.numberOfDifferentRoutes("C", "C", 0));

    }
}
