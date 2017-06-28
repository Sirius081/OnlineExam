package DIDI2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 17-6-9.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long num=sc.nextLong();
            long res=0;
            while(num>0){
                res+=num/5;
                num/=10;
            }
            System.out.println(res);
        }
    }
}
