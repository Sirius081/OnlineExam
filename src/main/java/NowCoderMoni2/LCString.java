package NowCoderMoni2;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class LCString {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String a=sc.next();
            String b=sc.next();
            int [][] dp=new int[a.length()][b.length()];
            int [][]endWith=new int[a.length()][b.length()];
            if(a.charAt(0)==b.charAt(0)){
                dp[0][0]=1;
                endWith[0][0]=1;
            }
            for (int i=1;i<b.length();i++){
                if (a.charAt(0)==b.charAt(i)){
                    endWith[0][i]=endWith[0][i-1]+1;
                    dp[0][i]=Math.max(dp[0][i-1],endWith[0][i]);
                }else{
                    endWith[0][i]=0;
                    dp[0][i]=dp[0][i-1];
                }
            }
            for (int i=1;i<a.length();i++){
                if (a.charAt(i)==b.charAt(0)){
                    endWith[i][0]++;
                    dp[i][0]=Math.max(dp[i-1][0],endWith[i][0]);
                }else{
                    endWith[i][0]=0;
                    dp[i][0]=dp[i-1][0];
                }
            }
            for(int i=1;i<a.length();i++){
                for(int j=1;j<b.length();j++){
                    if(a.charAt(i)==b.charAt(j)){
                        endWith[i][j]=endWith[i-1][j-1]+1;
                        dp[i][j]=Math.max(Math.max(dp[i-1][j],dp[i][j-1]),endWith[i][j]);
                    }else{
                        endWith[i][j]=0;
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            System.out.println(dp[a.length()-1][b.length()-1]);
        }

    }
}
