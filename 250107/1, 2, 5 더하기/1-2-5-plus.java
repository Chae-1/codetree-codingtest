import java.util.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n + 1];
        dp[0] = 1; // 마지막에 등장하는 수를 고정했을 경우, 
                   // k가 되는 수가 등장했을 경우의 수 1
        for (int i = 1; i <= n; i++) {
            // i가 1보다 클 경우 
            // 마지막에 1을 고정한 경우의 수를 더한다.
            if (i >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % 10007;
            }

            // i가 2보다 클 경우
            // 마지막에 2를 고정한 경우의 수를 더한다.
            if (i >= 2) {
                dp[i] += (dp[i] + dp[i - 2]) % 10007;
            }

            // i가 5보다 클 경우
            // 마지막에 5를 고정한 경우의 수를 더한다.
            if (i >= 5) {
                dp[i] = (dp[i] + dp[i - 5]) % 10007;
            }
        }
        
        System.out.println(dp[n] % 10007);
    }
}