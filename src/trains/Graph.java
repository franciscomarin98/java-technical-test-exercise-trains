package trains;

public class Graph {

    public int bestCost = Integer.MAX_VALUE;
    public int[][] cities = {
            {-1, 5, -1, 5, 7},
            {-1, -1, 4, -1, -1},
            {-1, -1, -1, 8, 2},
            {-1, -1, 8, -1, 6},
            {-1, 3, -1, -1, -1},
    };

    public void shortestPath(String cityOrigin, String cityDestiny, int distance) {

        if (cityOrigin.endsWith(cityDestiny) && distance < bestCost && distance > 0) {
            bestCost = distance;
            return;
        }

        char lastChar = cityOrigin.charAt(cityOrigin.length() - 1);
        int lastNodeIndex = lastChar - 'A';
        for (int i = 0; i < cities[lastNodeIndex].length; i++) {
            char newChar = (char) (i + 'A');
            int newCost = cities[lastNodeIndex][i];
            if (newCost > 0) {
                if (cityOrigin.indexOf(newChar) > 0)
                    continue;
                shortestPath(cityOrigin + newChar, cityDestiny, distance + newCost);
            }
        }

    }

    public int numberOfDifferentRoutes(String cityOrigin, String cityDestiny, int distance) {
        if (distance >= 30)
            return 0;

        int numberOfRoutes = 0;
        if (distance > 0 && cityOrigin.endsWith(cityDestiny)) {
            numberOfRoutes++;
        }

        char lastChar = cityOrigin.charAt(cityOrigin.length() - 1);
        int lastNodeIndex = lastChar - 'A';
        for (int i = 0; i < cities[lastNodeIndex].length; i++) {
            char newChar = (char) (i + 'A');
            int newCost = cities[lastNodeIndex][i];
            if (newCost > 0) {
                numberOfRoutes += numberOfDifferentRoutes(cityOrigin + newChar, cityDestiny, distance + newCost);
            }
        }

        return numberOfRoutes;
    }
}
