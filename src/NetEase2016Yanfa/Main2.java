package NetEase2016Yanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();//路灯数
            long l=sc.nextLong();//路长
            long[] deng=new long[n+2];//路灯坐标
            for (int i=0;i<n;i++){
                deng[i]=sc.nextLong();
            }
            deng[n]=0;
            deng[n+1]=l;
            Arrays.sort(deng);
            double max=Double.MIN_VALUE;

            for(int i=1;i<n;i++){
                if(deng[i]-deng[i-1]>max*2){
                    max=(deng[i]-deng[i-1])/2.0;
                }
            }
            long first=deng[0]-0;
            long last=l-deng[n];
            max=Math.max(first,Math.max(last,max));
            System.out.println(String.format("%.2f",max));
        }
    }
}
