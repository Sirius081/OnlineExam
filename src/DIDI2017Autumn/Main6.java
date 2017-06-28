package DIDI2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 17-6-9.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int sum=sc.nextInt();
            long []last=new long[sum+1];
            int first=sc.nextInt();
            if(first<=sum){
                last[first]=1;
            }

            for (int i=1;i<n;i++){
                long []dp=new long[sum+1];
                System.arraycopy(last,0,dp,0,sum+1);
                int num=sc.nextInt();

                for (int j=1;j<sum+1;j++){
                    if (num+j<=sum){
                        dp[num+j]+=last[j];
                    }else{
                        break;
                    }
                }
                last=dp;
                if(num<=sum){
                    last[num]++;
                }

            }
            System.out.println(last[sum]);
        }
    }
}
