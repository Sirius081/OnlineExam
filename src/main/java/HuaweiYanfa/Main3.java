package HuaweiYanfa;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            long base=1;
            long res=0;
            for (int i=str.length()-1;i>=2;i--){
                res+=getNum(str.charAt(i))*base;
                base*=16;
            }
            System.out.println(res);
        }
    }
    public static int getNum(char c){
        if(c>='0'&&c<='9'){
            return c-'0';
        }else{
            return c-'A'+10;
        }
    }
}
