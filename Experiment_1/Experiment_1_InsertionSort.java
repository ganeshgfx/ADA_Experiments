public class Experiment_1_InsertionSort {

    public static void main(String[] args) {
        System.out.println("\n");
        int[] SampleSize = {10,50,100,500,1000,5000,10000,50000,100000};
        long start_time;
        float end_time;

        //printArray(InsertionSort(new ArraySamples(10).average));

        System.out.println("INPUT SIZE  |  BEST CASE TIME(ms)  |  Average CASE TIME(ms)  |  WORST CASE TIME(ms)");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int SIZE:SampleSize) {

            Array_Sample array = new Array_Sample(SIZE);

            if(SIZE<1000)
                System.out.print(SIZE+"\t\t\t\t");
            else
                System.out.print(SIZE+"\t\t\t");


            start_time = System.nanoTime();
            int[] sorted = InsertionSort(array.best);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            InsertionSort(array.average);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            InsertionSort(array.worst);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\n");
        }

    }
    static int[] InsertionSort(int[] array){

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        return array;

    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}