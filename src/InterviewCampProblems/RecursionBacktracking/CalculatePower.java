package InterviewCampProblems.RecursionBacktracking;

public class CalculatePower {

    public static int positivePower(int x, int power){
       if(x == 0)
           return Integer.MIN_VALUE; // infinity

        int result = power(Math.abs(x), Math.abs(power));
        if(power<0){
            return 1/result;
        }
        if(x < 0 && power % 2 == 1)
            return -1 * result;
        return result;
    }

    public static int power(int x, int power){
        if(power==0)
            return 1;
        if(x==1)
            return 1;
        if(power==1)
            return x;

        if(power % 2 == 0)
            return power(x,power/2) * power(x, power/2);
        else
            return x * power(x, power/2) * power(x, power/2);
    }

    public static void main(String[] args) {

        System.out.println(power(2,5));

    }

}
