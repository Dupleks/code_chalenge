public class Day4Task1 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 12, 11};
        int sum = 5;
        findIfSpecificSumExistInArray(numbers, sum);

    }

    public static boolean findIfSpecificSumExistInArray(int[] numbers, int sum) {
        boolean bool1 = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int a = 1; a < numbers.length; a++) {
                if (i != a) {
                    int n = numbers[i] + numbers[a];
                    if (n == sum) {
                        bool1 = true;
                        break;
                    }
                }
            }
        }
        return bool1;
    }
}
