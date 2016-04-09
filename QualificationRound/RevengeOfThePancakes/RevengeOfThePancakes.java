import java.util.Scanner;

public class RevengeOfThePancakes {

    static final boolean UP = true;
    static final boolean DOWN = false;

    static int flipCount = 0;

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= T; t++) {
            flipCount = 0;
            final char[] S = in.nextLine().toCharArray();
            boolean pancakes[] = new boolean[S.length];
            for(int i = 0; i < S.length; i++) {
                if('+' == S[i]) {
                    pancakes[S.length-1 - i] = UP;
                } else {
                    pancakes[S.length-1 - i] = DOWN;
                }
            }

            for(int i = 0; i < pancakes.length; i++) {
                if(pancakes[i] == UP) {
                    continue;
                } else {
                    if(pancakes[pancakes.length-1] == UP) {
                        for(int j = pancakes.length-1; j >= 0; j--) {
                            if(pancakes[j] == UP) {
                                continue;
                            } else {
                                flip(pancakes, j+1);
                                break;
                            }
                        }
                        flip(pancakes, i);
                    } else {
                        flip(pancakes, i);
                    }
                }
            }
            System.out.printf("Case #%d: %d\n", t, flipCount);
        }
    }

    private static void flip(boolean[] pancakes, int i) {
        int flipStackSize = pancakes.length - i;
        for (int j = 0; j < (flipStackSize + 1) / 2; j++) {
            boolean tmp = pancakes[i + j];
            pancakes[i + j] = !pancakes[pancakes.length - 1 - j];
            pancakes[pancakes.length - 1 - j] = !tmp;
        }
        flipCount++;
    }
}