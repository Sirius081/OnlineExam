package NetEase2016Intern;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 * https://www.nowcoder.com/test/970447/summary
 */
public class Main1 {
    public static long GCD(long a,long b){
        if(b==0){
            return a;
        }else{
            return GCD(b,a%b);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long n=sc.nextLong();
            long ability=sc.nextLong();//当前能力
            while(n-->0){
                long monster=sc.nextLong();
                if(monster<=ability){
                    ability+=monster;
                }else{
                    ability+=GCD(monster,ability);
                }
            }
            System.out.println(ability);
        }
    }
}
