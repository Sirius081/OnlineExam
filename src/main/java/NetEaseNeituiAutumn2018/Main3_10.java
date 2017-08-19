package NetEaseNeituiAutumn2018;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/12.
 */
public class Main3_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            long []tem=new long[k+1];
            long []tem2=new long[k+1];
            for (int i=1;i<=k;i++){
                tem[i]=1;
            }
            int []tt=new int[k+1];
            for (int i=1;i<=k;i++){
                for (int j=1;j*i<=k;j++){
                    tt[i]++;
                }
            }
            for(int i=1;i<n;i++){
                for (int j=1;j<=k;j++){
                    for (int p=1;p<=j;p++){
                        tem2[j]+=tem[p];

                    }

                }
                System.arraycopy(tem2,0,tem,0,tem2.length);
            }

            long sum=0;
            for (long l:tem){
                sum+=l;
            }
            System.out.println(sum%1000000007);
        }
    }
}
