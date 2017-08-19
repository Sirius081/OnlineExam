package HuaweiYanfa;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int count=0;
            while(n>=3){
                count+=n/3;
                n=n/3+n%3;
            }
            if(n==2){
                count++;
            }
            System.out.println(count);
        }
    }
}
