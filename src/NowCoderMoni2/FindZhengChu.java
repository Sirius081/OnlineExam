package NowCoderMoni2;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class FindZhengChu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            double a=sc.nextDouble();
            double b=sc.nextDouble();
            double c=sc.nextDouble();
            double res=(b-a)/c;
            if(a%c==0||b%c==0){
                res++;
            }
            System.out.println((long)Math.floor(res));
        }
    }
}
