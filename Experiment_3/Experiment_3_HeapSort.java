public class Experiment_3_HeapSort {
    //Implementation and Time analysis of sorting algorithms: Bubble sort, Selection sort,Insertion sort, Merge sort and Quicksort
    public static void main(String[] args) {
        System.out.println("\n");
        int[] SampleSize = {10,50,100,500,1000,5000,10000};
        long start_time;
        float end_time;

        //printArray(QuickSort(new Array_Sample(100).average,0,99));

        System.out.println("INPUT SIZE  |  BEST CASE TIME(ms)  |  Average CASE TIME(ms)  |  WORST CASE TIME(ms)");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int SIZE:SampleSize) {

            ArraySample array = new ArraySample(SIZE);
            int low = 0, high = SIZE-1;

            if(SIZE<1000)
                System.out.print(SIZE+"\t\t\t\t");
            else
                System.out.print(SIZE+"\t\t\t");

            start_time = System.nanoTime();
            HeapSort(array.best);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            HeapSort(array.average);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            HeapSort(array.worst);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\n");
        }

    }
    static int[] HeapSort(int[] array){

        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            make_heap(array, n, i);

        for (int i = n - 1; i > 0; i--) {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            make_heap(array, i, 0);
        }

        return array;

    }
    static void make_heap(int array[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            make_heap(array, n, largest);
        }
    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
class ArraySample {
    int[] average, best, worst;

    ArraySample(int SIZE) {
        average = averageCase(SIZE);
        best = bestCase(SIZE);
        worst = worstCase(SIZE);
    }

    int[] averageCase(int SIZE) {
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int) (Math.random() * (100 - 1 + 1) + 1);
        }
        return array;
    }

    int[] bestCase(int SIZE) {
        int[] array = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    int[] worstCase(int SIZE) {
        int[] array = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            array[SIZE - i] = i;
        }
        return array;
    }
}