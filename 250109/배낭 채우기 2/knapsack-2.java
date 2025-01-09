import java.util.*;

public class Main {
    static int n;
    static int m;

    static int[] w;
    static int[] v;
    static int[][] dp;

    public static void main(String[] args) {
        initialize();

        // 보석 i를 선택한다.
        for (int i = 1; i < m; i++) {
            for (int currentW = 0; currentW <= m; currentW++) {
                // 보석 i를 선택할 수 있다면
                if (currentW > w[i]) {
                    // 기존 값과 비교해서 큰 값을 채워놓는다.
                    // 단, 중복해서 선택이 가능하기 때문에
                    // dp[i][currentW - w[i]], dp[i - 1][currentW - w[i]] 두 경우 중 큰 값을 선택한다.
                    // 선택된 값과 기존 값 중 큰 값을 dp[i][currentW]에 저장한다.
                    int afterSelectWeight = currentW - w[i];
                    dp[i][currentW] =  Math.max(dp[i][currentW],
                            v[i] + Math.max(dp[i][afterSelectWeight], dp[i - 1][afterSelectWeight]));
                }
                // i를 선택했을 경우와 그렇지 않을 경우와 비교하여 큰 값을 dp[i][currentW]에 저장한다.
                dp[i][currentW] = Math.max(dp[i][currentW], dp[i - 1][currentW]);
            }
        }

    }

    private static void initialize() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        w = new int[n + 1];
        v = new int[n + 1];

        // 무게와 가치를 입력 받는다.
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        dp = new int[n + 1][m + 1];
    }

}