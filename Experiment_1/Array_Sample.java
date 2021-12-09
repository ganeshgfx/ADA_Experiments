public class Array_Sample{
    int[] average,best,worst;
    Array_Sample(int SIZE){
        average = averageCase(SIZE);
        best = bestCase(SIZE);
        worst = worstCase(SIZE);
    }
    int[] averageCase(int SIZE){
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int)(Math.random()*(100-1+1)+1);
        }
        return array;
    }
    int[] bestCase(int SIZE){
        int[] array = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            array[i-1] = i;
        }
        return array;
    }
    int[] worstCase(int SIZE){
        int[] array = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) {
            array[SIZE-i] = i;
        }
        return array;
    }
}