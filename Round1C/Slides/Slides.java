import java.util.Scanner;

public class Slides {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            final int B = in.nextInt();
            int M = in.nextInt();
            System.out.printf("Case #%d: ", t);

            if (maxPossibleWays(B) < M) {
                System.out.print("IMPOSSIBLE\n");
                continue;
            } else {
                System.out.print("POSSIBLE\n");
            }
            final int[][] connections = new int[B][B];

            int previousBuilding = 0;
            Integer currentBuilding = null;
            while (M > 0) {
                if (currentBuilding == null) {
                    connections[previousBuilding][B - 1] = 1;
                    currentBuilding = previousBuilding + 1;
                    M--;
                } else {
                    connections[previousBuilding][currentBuilding] = 1;
                    connections[currentBuilding][B - 1] = 1;
                    M--;
                    currentBuilding++;
                    if (currentBuilding == B - 1) {
                        previousBuilding++;
                        currentBuilding = null;
                    }
                }
            }

            printConnections(connections, B);
        }
    }

    private static void printConnections(int[][] connections, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(connections[i][j]);
            }
            System.out.print("\n");
        }
    }

    private static int maxPossibleWays(int b) {
        return 1 + ((b - 2) * (b - 1)) / 2;
    }
}