package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            long n=sc.nextLong();
            System.out.println(T(n));
        }
    }
    public static long T(long n){
        if (n==1){
            return 1;
        }
        long res=0;
        if (n%2==1){
            res+=n;
            n--;
        }
        res+=(n/2)*(n/2);
        res+=T(n/2);
        return res;
    }
}
