package Tencent2017Intern;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            char [] ss=str.toCharArray();
            int [][]dp=new int[str.length()][str.length()];
            for (int i=0;i<str.length();i++){
                dp[i][i]=1;
            }
            for (int i=ss.length-1;i>=0;i--){
                for(int j=i+1;j<ss.length;j++){
                    if (ss[i]==ss[j]){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
            System.out.println(ss.length-dp[0][ss.length-1]);
        }
    }
}
