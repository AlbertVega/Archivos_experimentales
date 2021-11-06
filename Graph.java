import java.util.Scanner;

public class Graph {
    static int[][] e = new int[10][10];
    static int n, m;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 1; i <= m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            e[a][b] = 1;
        }
        floyd();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(e[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (e[i][j] != 0) {
                        e[i][j] = 1;
                    } else if (e[i][k]!=0 && e[k][j]!=0) {
                        e[i][j] = 1;
                    }
                }
            }
        }
    }
}