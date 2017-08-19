package NetEaseNeituiAutumn2018;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/12.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long x=sc.nextLong();//每天的房租
            long f=sc.nextLong();//已有f个水果
            long d=sc.nextLong();//已有的钱
            long p=sc.nextLong();//一个水果的价格
            long res=0;
            //已有的水果
            if(d>=x*f){
                res+=f;
                d-=x*f;
                res+=d/(x+p);
            }else{
                res+=d/x;
            }
            System.out.println(res);
        }
    }
}
