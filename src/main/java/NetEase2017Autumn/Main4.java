package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long [] dd=  new long[31];
        long [] dp=new long[31];
        dd[2]=3;
        dp[2]=6;
        for (int i=3;i<31;i++){
            dd[i]=dd[i-1]+dp[i-1];
            dp[i]=dd[i-1]*2+dp[i-1];
        }
        while (sc.hasNext()){
            int n=sc.nextInt();
            if (n==1){
                System.out.println(3);
            }else{
                System.out.println(dd[n]+dp[n]);
            }
        }

    }
}
