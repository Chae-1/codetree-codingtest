import java.util.*;

// 부분 수열의 합이 m인 수열의 최소 길이를 구하는 문제
// 1 ~ m까지의 부분 수열의 합의 길이가
public class Main {

    static final int MAX_M = 10000;

    static int n;
    static int m;
    static int[] arr;
    static int[] dp;

    private static void initialize(Scanner sc) {
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        dp = new int[m + 1];

        // i를 만드는 데 필요한 수열의 최소 길이 dp[i]는
        for (int i = 0; i <= m; i++) {
            dp[i] = MAX_M;
        }
        // 아무것도 선택하지 않았을 때, 초기값은 수열의 갯수는 0

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initialize(sc);

        // 1. 순차적으로 동전을 선택한다.
        for (int i = 0; i < n; i++) {
            int selectedNumber = arr[i];
            // 2. m부터 0까지 해당 숫자를 사용해서 수열을 구성했을 경우의 수 업데이트.
            for (int j = m; j >= 0; j--) {
                if (j >= selectedNumber) {
                    dp[j] = Math.min(dp[j], dp[j - selectedNumber] + 1);
                }
            }
        }

        System.out.println(dp[m]);
    }
}