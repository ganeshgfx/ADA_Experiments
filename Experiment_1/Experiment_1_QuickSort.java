public class Experiment_1_BubbleSort {
    public static void main(String[] args) {
        System.out.println("\n");
        int[] SampleSize = {10,50,100,500,1000,5000,10000,50000,100000};
        long start_time;
        float end_time;

        System.out.println("INPUT SIZE  |  BEST CASE TIME(ms)  |  Average CASE TIME(ms)  |  WORST CASE TIME(ms)");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int SIZE:SampleSize) {

            Array_Sample array = new Array_Sample(SIZE);

            if(SIZE<1000)
                System.out.print(SIZE+"\t\t\t\t");
            else
                System.out.print(SIZE+"\t\t\t");


            start_time = System.nanoTime();
            int[] sorted = bubble_sort(array.best);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            bubble_sort(array.average);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            bubble_sort(array.worst);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\n");
        }

    }
    static int[] bubble_sort(int[] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
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
