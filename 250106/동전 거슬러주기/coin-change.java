import java.util.*;

public class Main {

    static int MAX_M = 10000;
    static int MAX_N = 100;

    static int n;
    static int m;
    static int[] dp = new int[MAX_M + 1];
    static int[] coins = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        // 100 10000
        // 전체 시간 복잡도: 100 -> 10000
        // 금액 M을 거슬러주기 위한 최소 동전 수
        // 금액 M을 거슬러주기 위한 최소 동전 수 1 + Min(dp[N]);
        // dp 금액 i을 거슬러주기 위해 필요한 최소 동전 수
        coins = new int[n];

        for (int i = 0; i < m + 1; i++) {
            dp[i] = MAX_M; // 최대 동전 갯수 n으로
        }

        // 초기 금액 coins[i]를 거슬러주기 위해 필요한 최소 동전 수 1
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            dp[coins[i]] = 1; // 초기 금액 coins[i]를 거슬러주기 위해 필요한 최소 동전 수
        }


        // 금액 coins[i]를 거슬러주기 위해 필요한 최소 동전 수
        for (int i = 1; i < m + 1; i++) {
            // 가지고 있는 동전을 순회한다.
            for (int j = 0; j < n; j++) {
                // 금액 i가 coins[j]보다 클 경우
                // coins[j]를 사용해서 금액 i를 거스를 수 있다는 의미.
                // dp[i]는 금액 i를 거슬러주기 위한 최소 동전 수이다.
                // i를 거슬러 주기 위해 최소 동전 수를 구하기 위해서는 기존 dp[i], dp[j] + 1중 최소를 구하면 된다.  
                if (i - coins[j] > 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[m] == MAX_M ? -1 : dp[m]);

    }
}