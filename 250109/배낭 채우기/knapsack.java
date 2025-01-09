import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] w;
    static int[] v;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 보석의 개수
        m = sc.nextInt(); // 최대 무게
        w = new int[m + 1];
        v = new int[n + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        // 0번 보석을 선택했을 경우, 초기값
        for (int i = 0; i <= m; i++) {
            if (w[0] <= i) {
                dp[0][i] = v[0];
            }
        }

        for (int i = 1; i < n; i++) {
            // 선택할 수 있는 아이템이 존재할 경우, 그렇지 않을 경우
            for (int currentW = 0; currentW <= m; currentW++) {
                // w[i] 보다 현재 무게가 클 경우, 아이템 i를 포함시킬 수 있다.
                // 아이템 i를 포함시킨 후와, 포함시키지 않은 값 중 큰 값을 선택하면 된다.
                if (w[i] <= currentW) {
                    dp[i][currentW] = Math.max(dp[i][currentW], v[i] + dp[i - 1][currentW - w[i]]);
                }
                // 보석의 무게가 전체 가방 무게보다 클 경우, 
                // 해당 보석을 선택하지 못하므로, 선택하지 않을 경우의 가치로 계산한다.
                dp[i][currentW] = Math.max(dp[i][currentW], dp[i - 1][currentW]);
            }
        }

        // 계산한 결과 중 가장 큰 값을 선택한다.
        int max = getMax();
        System.out.println(max);
    }

    private static int getMax() {
        int max = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}