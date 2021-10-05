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
        } catch (NullPointerException e){
            System.out.println("NO SUCH ROUTE!");
        }
    }


}
