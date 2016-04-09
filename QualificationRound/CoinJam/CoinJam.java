import java.util.Scanner;

public class CoinJam {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.printf("Case #%d:\n", t);
            final int N = in.nextInt();
            final int J = in.nextInt();
            int coinjam[] = new int[N];
            initCoinJam(coinjam);
            int j = 0;
            while (j < J) {
                boolean isCoinJam = true;
                long divisors[] = new long[9];
                for (int base = 2; base <= 10; base++) {
                    long divisor = isPrime(coinjam, base);
                    if (divisor == -1) {
                        isCoinJam = false;
                        break;
                    } else {
                        divisors[base - 2] = divisor;
                    }
                }
                if (isCoinJam) {
                    j++;
                    printCoinJam(coinjam);
                    System.out.print(" ");
                    printDivisors(divisors);
                    System.out.print("\n");
                }
                incCoinJam(coinjam);
            }
        }
    }

    private static long isPrime(int[] coinjam, int base) {
        long base10Representation = base10Representation(coinjam,2);
        // check if is prime
        long divisor = -1;
        for(int div = 2; div <= Math.ceil(Math.sqrt(base10Representation)); div++) {
            if(base10Representation % div == 0) {
                divisor = div;
                break;
            }
        }
        if(divisor == -1) {
            return -1;
        } else {
            int[] divisorBits = base2Representation(divisor);
            return base10Representation(divisorBits, base);
        }
    }

    private static int[] base2Representation(long divisor) {
        int[] divisorBits = new int[32];
        for (int i = 0; i < 32; i++) {
            divisorBits[i] = (int) (divisor % 2);
            divisor /= 2;
            if (divisor == 0) break;
        }
        return divisorBits;
    }

    private static long base10Representation(int[] revertedBits, int base) {
        long base10Representation = revertedBits[0];
        long nextBaseVal = 1;
        for (int i = 1; i < revertedBits.length; i++) {
            nextBaseVal *= base;
            base10Representation += nextBaseVal * revertedBits[i];
        }
        return base10Representation;
    }

    private static void printDivisors(long[] divisors) {
        for (long divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }

    private static void initCoinJam(int[] coinjam) {
        coinjam[0] = 1;
        coinjam[coinjam.length - 1] = 1;
    }

    private static void incCoinJam(int[] coinjam) {
        int i = 1;
        boolean carry;
        do {
            carry = coinjam[i] == 1;
            coinjam[i] = coinjam[i] == 0 ? 1 : 0;
            i++;

            if (i == coinjam.length - 1) {
                carry = false;
            }
        } while (carry);
    }

    private static void printCoinJam(int[] coinjam) {
        for (int i = coinjam.length - 1; i >= 0; i--)
            System.out.print(coinjam[i]);
    }
}