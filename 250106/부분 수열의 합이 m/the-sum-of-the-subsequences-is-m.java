import java.util.*;

// 부분 수열의 합이 m인 수열의 최소 길이를 구하는 문제
// 1 ~ m까지의 부분 수열의 합의 길이가
public class Main {

    public static final int MAX_M = 10000;

    static int n;
    static int m;
    static int[] arr;
    static int[] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        dp = new int[m + 1];

        // i를 만드는 데 필요한 수열의 최소 길이 dp[i]는
        for (int i = 0; i <= m; i++) {
            dp[i] = MAX_M;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(m, n - 1) == MAX_M ? -1 : dp[m]);
    }

    // target : 구하고자 하는 합이 target인 수열의 크기
    // idx : 포함 시킨 현재 인덱스, 마지막 인덱스부터 시작
    private static int solve(int target, int idx) {

        // target == 0인 경우 최초 target을 만족하는 부분 수열이 존재한다는 의미
        if (target == 0) {
            return 0;
        }

        // idx < 0이라면, 존재할 수 없는 수열 이므로 MAX 값 반환
        if (idx < 0) {
            return MAX_M;
        }

        // dp[target]이 MAX_M이 아니라면, 이때는
        if (dp[target] != MAX_M) {
            return dp[target];
        }

        for (int i = idx; i >= 0; i--) {
            // 구하고자 하는 값이 arr[idx]에 있는 값보다 크면,
            // arr[idx]에 있는 값을 포함시켜서 target을 만들 수 있다.
            if (target >= arr[i]) {
                dp[target] = Math.min(dp[target], 1 + solve(target - arr[i], i - 1));
            }
        }

        return dp[target];
    }
}