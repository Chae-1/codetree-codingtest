import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coins = new int[n];
        dp = new int[m + 1];
        // init

        for (int i = 0; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            dp[coins[i]] = 1;
        }

        // 1. i원을 거슬러 줄 수 있는 최대 동전 수 dp를 연산한다..
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                // 2. coins[j]를 사용해 금액 i를 거슬러줄 수 있다면
                if (i >= coins[j]) {
                    // 기존 값과 coins[j]를 사용한 뒤에 i - coins[j]를 거슬러 줬을 때의 최대 동전 수 중 큰 값을 선택한다.
                    dp[i] = Math.max(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        System.out.println(dp[m] < 0 ? -1 : dp[m]);

    }
}