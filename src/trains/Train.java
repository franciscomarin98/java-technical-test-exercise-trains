package trains;

import java.util.Map;

public class Train {
    Map<String, Map<String, Number>> routes;

    public Train(Map<String, Map<String, Number>> _routes) {
        this.routes = _routes;
    }

    void calculateDistance(String[] route) {
        int distance = 0;
        try {
            for (int i = 0; i < route.length - 1; i++) {
                int currentDistance = (int) this.routes.get(route[i]).get(route[i + 1]);
                distance += currentDistance;
            }
            System.out.println("The distance of the route is: " + distance);
        } catch (NullPointerException e) {
            System.out.println("NO SUCH ROUTE!");
        }
    }

    void calculateNumbersOfTrips(String cityOrigin, String cityDestiny, int maximumStops, Map<String, Map<String, Number>> routes) {
        int count = 0;
        if (routes.containsKey(cityOrigin)) {
            Map<String, Number> temporal = routes.get(cityOrigin);

            if (temporal.containsKey(cityDestiny)) {
                count += 1;
            }

            for (String key : temporal.keySet()) {
                if (routes.get(key).containsKey(cityDestiny)) {
                    count += 1;
                }
                for (String key2 : routes.get(key).keySet()) {
                    if (!key.equals(key2)) {
                        if (routes.get(key2).containsKey(cityDestiny)) {
                            count += 1;
                        }
                    }
                }
            }

            if (count <= maximumStops) {
                System.out.println("The number of trips starting at " + cityOrigin + " and ending at " + cityDestiny + " with a maximum of " + maximumStops + " stops are: " + count);
            } else {
                System.out.println("No results");
            }

        }
    }
}

