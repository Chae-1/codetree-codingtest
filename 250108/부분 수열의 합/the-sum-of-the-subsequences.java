import java.util.*;

public class Main {

    static int MAX_N = 100;
    static int MAX_M = 10000;

    static int n;
    static int m;
    static int[] numbers = new int[MAX_N + 1];
    static int[] dp = new int[MAX_M + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i <= m; i++) {
            dp[i] = MAX_M;
        }


        // 자기 자신을 포함시켰을 경우 dp[0]가 되는데, 이 경우는 0이다.
        dp[0] = 0;

        // 1. 가지고 있는 수열의 마지막부터 처음 원소까지 차례대로 순회하면서
        for (int i = n - 1; i >= 0; i--) {
            int currentNumber = numbers[i];
            // 2. 숫자 m을 만들 수 있는 수열이 있는 지 확인한다.
            for (int j = m; j >= 0; j--) {
                // 선택된 수가 j보다 크면 이 숫자를 포함시킨 수열을 만들 수 있다.
                if (currentNumber <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - currentNumber]); 
                }
            }
        }

        System.out.println(dp[m] == MAX_M ? "No" : "Yes");
    }
}