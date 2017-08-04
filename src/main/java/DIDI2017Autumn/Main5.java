package DIDI2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 17-6-9.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long m=sc.nextLong();

            int n=sc.nextInt();
            StringBuffer sb=new StringBuffer();
            boolean isNegative=m<0;
            if (m<0){
                m=-m;

            }
            while(m!=0){
                long t=m%n;
                if(t>=10){
                    sb.append((char)(t-10+'A'));
                }else{
                    sb.append(t);
                }

                m/=n;
            }
            if(isNegative){
                System.out.println("-"+sb.reverse().toString());
            }else {
                System.out.println(sb.reverse());
            }
        }
    }
}
