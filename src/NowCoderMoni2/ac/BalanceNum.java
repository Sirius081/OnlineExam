package NowCoderMoni2.ac;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class BalanceNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String num=sc.next();
            String res="NO";
            for (int i=1;i<num.length();i++){
                long dot1=1;
                for(char c:num.substring(0,i).toCharArray()){
                    dot1*=c-'0';
                }
                long dot2=1;
                for(char c:num.substring(i,num.length()).toCharArray()){
                    dot2*=c-'0';
                }
                if(dot1==dot2){
                    res="YES";
                }

            }
            System.out.println(res);
        }
    }
}
