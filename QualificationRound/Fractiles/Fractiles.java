import java.util.Scanner;

public class Fractiles {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            final int K = in.nextInt();
            final int C = in.nextInt();
            final int S = in.nextInt();
            final StringBuilder ans = new StringBuilder();


             {
                if(C == 1) {
                    if(S < K) {
                        ans.append("IMPOSSIBLE");
                    } else {
                        for (int i = 1; i <= K; i++) {
                            ans.append(i);
                            ans.append(" ");
                        }
                    }
                } else if (K == 1) {
                    if(S < K) {
                        ans.append("IMPOSSIBLE");
                    } else {
                        ans.append(1);
                    }
                } else {
                    if(S < K-1) {
                        ans.append("IMPOSSIBLE");
                    } else {
                        for (int i = 2; i <= K; i++) {
                            ans.append(i);
                            ans.append(" ");
                        }
                    }
                }
            }
            System.out.printf("Case #%d: %s\n", t, ans.toString());
        }
    }
}