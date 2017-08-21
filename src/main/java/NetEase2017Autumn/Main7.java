package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main7 {
    final  static int NOWAY=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int res=f(n,0);
            if (res==NOWAY){
                res=-1;
            }
            System.out.println(res);
        }
    }
    public static int f(int n,int steps){
        if (n<0){
            return NOWAY;
        }else if (n==0){
            return steps;
        }else{
            return Math.min(f(n-6,steps+1),f(n-8,steps+1));
        }
    }
}
