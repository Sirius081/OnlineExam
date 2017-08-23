package Toutiao2018Neitui;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sirius on 2017/8/22.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            BigInteger res=new BigInteger("0");
            int min=Integer.MAX_VALUE;
            for (int i=0;i<n;i++){
                int num=sc.nextInt();
                res=res.add(new BigInteger(num+""));
                min=Math.min(num,min);
            }
            res=res.multiply(new BigInteger(min+""));
            System.out.println(res.toString());
        }
    }
}
