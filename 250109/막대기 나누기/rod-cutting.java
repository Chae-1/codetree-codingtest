import java.util.*;

public class Main {
    static int n;
    static int[] values;
    static int[] dp;

    public static void main(String[] args) {
        initialize();

        // 막대기 길이가 1 ~ n 인 모든 경우에 대해 순회를 한다.
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                // 끝의 막대기 길이가 j일 경우,
                // 이전 값과 막대기 j의 가격 + 막대기 길이가 i - j 일 경우를 비교하여 최댓값을 구한다.
                dp[i] = Math.max(dp[i], values[j] + dp[i - j]);
            }
        }
        System.out.println(getMax());
    }

    private static int getMax() {
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static void initialize() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        values = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }
    }
}