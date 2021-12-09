public class Experiment_2_LinearSearch{
    //Implementation and Time analysis of sorting algorithms: Bubble sort, Selection sort,Insertion sort, Merge sort and Quicksort
    public static void main(String[] args) {
        System.out.println("\n");
        int[] SampleSize = {10,50,100,500,1000,5000,10000};
        long start_time;
        float end_time;

        //printArray(new Array_Sample(10,9).worst);

        System.out.println("INPUT SIZE  |  BEST CASE TIME(ms)  |  Average CASE TIME(ms)  |  WORST CASE TIME(ms)");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int SIZE:SampleSize) {

            int element = 9;
            Array_Sample array = new Array_Sample(SIZE,element);


            if(SIZE<1000)
                System.out.print(SIZE+"\t\t\t\t");
            else
                System.out.print(SIZE+"\t\t\t");

            start_time = System.nanoTime();
            LinearSearch(array.best,element);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            LinearSearch(array.average,element);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\t\t\t\t");

            start_time = System.nanoTime();
            LinearSearch(array.worst,element);
            end_time = (System.nanoTime()-start_time)/1000000f;
            System.out.print(end_time+"ms\n");
        }

    }
    static int LinearSearch(int[] array, int element){

        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;

    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

class Array_Sample {
    int[] average,best,worst;
    Array_Sample(int SIZE,int ELEMENT){
        average = averageCase(SIZE);
        best = bestCase(SIZE,ELEMENT);
        worst = worstCase(SIZE,ELEMENT);
    }

    int[] averageCase(int SIZE){
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int)(Math.random()*(100-1+1)+1);
        }
        return array;
    }
    int[] bestCase(int SIZE, int ELEMENT){
        int[] array = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            array[i-1] = i;
        }
        array[0] = ELEMENT;
        return array;
    }
    int[] worstCase(int SIZE, int ELEMENT){
        int[] array = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            array[SIZE-i] = i;
            if(i==ELEMENT)
                array[SIZE-i] = 0;
        }
        array[SIZE-1] = ELEMENT;
        return array;
    }
}