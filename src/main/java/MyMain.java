import java.util.HashMap;
import java.util.Map;

public class MyMain {

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        double total = 0;
        for (double[] arr : mat)
            for (double num : arr) total += num;
        return total / (mat[0].length * mat.length);
    }

    // Returns the median of the 2D array mat
    public static double median(double[][] mat) { 
        double[] allNumbers = new double[mat.length * mat[0].length];
        int index = 0;
        for (double[] arr : mat) {
            for (double num : arr) {
                allNumbers[index] = num;
                index++;
            }
        }
        return (allNumbers.length % 2 == 1) ? allNumbers[allNumbers.length / 2] : (allNumbers[allNumbers.length / 2] + allNumbers[allNumbers.length / 2 - 1]) / 2;
    }
    

    // Returns the mode of the 2D array mat
    public static double mode(double[][] mat) {
        HashMap<Double, Integer> occurrences = new HashMap<>();
        for (double[] arr : mat)
            for (double num : arr) occurrences.merge(num, 1, Integer::sum);
        int mostOccurrences = 0;
        double mostCommonNumber = Integer.MIN_VALUE;
        for (Map.Entry<Double, Integer> i : occurrences.entrySet()) {
            if (i.getValue() > mostOccurrences) {
                mostOccurrences = i.getValue();
                mostCommonNumber = i.getKey();
            }
        }
        return mostCommonNumber;
    }


    public static void main(String[] args) {
        double[][] m1 = {
                {1,  2,  4,  6},
                {7,  9,  10, 12},
                {14, 15, 17, 18},
                {22, 23, 27, 30}
        };

        double[][] m2 = { {1,  2,  4,  5,  6},
                {7,  9,  10, 12, 13},
                {14, 15, 17, 18, 20},
                {22, 23, 27, 30, 32},
                {33, 37, 38, 42, 44} };
        System.out.println(median(m1));
    }
}
