public class Factorial_Recursive {
    public static void main(String[] args) {

        long start_time;
        float end_time;

        //System.out.println(Factorial(5));

        System.out.println("INPUT  |  OUTPUT  |  TIME(ms)");
        System.out.println("-----------------------------");
        for (int n = 1;n<10;n++) {

            start_time=0;
            end_time=0;

            System.out.print(n + "\t\t");


            long factorial = 0;

            start_time = System.nanoTime();

            factorial = Factorial(n);

            end_time = (System.nanoTime() - start_time) / 1000000f;

            if (factorial < 1000)
                System.out.print(factorial+"\t\t\t");
            else
                System.out.print(factorial+"\t\t");

            System.out.print(end_time + "ms\t\t\n");
        }
    }

    static long Factorial(int number){
        if(number < 1)
            return 1;
        else
            return(number * Factorial( number-1) );

    }
}