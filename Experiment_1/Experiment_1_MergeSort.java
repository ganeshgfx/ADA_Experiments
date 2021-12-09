public class Experiment_1_MergeSort {
    public static void main(String[] args) {
        System.out.println("\n");
        int[] SampleSize = {10,50,100,500,1000,5000,10000,50000,100000};
        long start_time;
        float end_time;

        //printArray(MergeSort(new ArraySample(10).average,0,9));

        System.out.println("INPUT SIZE  |  BEST CASE TIME(ms)  |  Average CASE TIME(ms)  |  WORST CASE TIME(ms)");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int SIZE:SampleSize) {

            Array_Sample array = new Array_Sample(SIZE);
            int l = 0;
            int r = SIZE-1;

            if(SIZE<1000)
                System.out.print(SIZE+"\t\t\t\t");
            else
                System.out.print(SIZE+"\t\t\t");


            start_time = System.nanoTime();
            int[] sorted = MergeSort(array.best,l,r);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            MergeSort(array.average,l,r);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            MergeSort(array.worst,l,r);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\n");
        }

    }
    static int[] MergeSort(int[] array,int l,int r){

        if (l < r) {
            int m =l+ (r-l)/2;

            MergeSort(array, l, m);
            MergeSort(array, m + 1, r);

            Merge(array, l, m, r);
        }

        return array;

    }
    static void Merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}