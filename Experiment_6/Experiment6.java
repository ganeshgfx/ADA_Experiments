package Experiment_6;
public class Experiment6 {
    static int MatrixChainOrder(int p[], int i, int j) {
        if (i == j) return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int count = MatrixChainOrder(p, i, k)
                        + MatrixChainOrder(p, k + 1, j)
                        + p[i - 1] * p[k] * p[j];
 
            if (count < min)
                min = count;
        }
        return min;
    }
    public static void main(String args[]){
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6};
        int n = arr.length;
        System.out.println();
        System.out.println(
            "Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
        System.out.println();
    }
}