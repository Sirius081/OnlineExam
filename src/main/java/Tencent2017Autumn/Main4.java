package Tencent2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/7/2.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            StringBuffer sb=new StringBuffer();
            long low=-90;
            long high=90;
            boolean isLeft=false;
            for (int i=0;i<6;i++){
                long mid=(low+high)/2;
                if(mid<=n){
                    low=mid;
                    sb.append(1);
                }else {
                    high=mid;
                    sb.append(0);
                }
            }

            System.out.println(sb);
        }
    }
}
