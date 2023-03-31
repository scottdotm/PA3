package pa3;

public class Recursion {

    public static int sumEvenDigits(int n) {
        if (n < 10) {
            return (n % 2 == 0) ? n : 0;
        } else {
            int sum = sumEvenDigits(n / 10);
            int lastDigit = n % 10;
            return sum + ((lastDigit % 2 == 0) ? lastDigit : 0);
        }
    }

    public static void binaryStringsWithMoreOnes(int n) {
        binaryStringsWithMoreOnes("", 0, 0, n);
    }

    private static void binaryStringsWithMoreOnes(String str, int numZeroes, int numOnes, int n) {
        if (str.length() == n && numZeroes < numOnes) {
            System.out.println(str);
        } else if (str.length() < n) {
            binaryStringsWithMoreOnes(str + "0", numZeroes + 1, numOnes, n);
            binaryStringsWithMoreOnes(str + "1", numZeroes, numOnes + 1, n);
        }
    }
}
