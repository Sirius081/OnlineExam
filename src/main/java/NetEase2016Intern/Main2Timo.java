package NetEase2016Intern;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class Main2Timo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            long dis=sc.nextLong();
            long res=0;
            long[][]paotai=new long[3][2];
            for(int i=0;i<3;i++){
                paotai[i][0]=sc.nextLong();
                paotai[i][1]=sc.nextLong();
            }
            long[]enemy=new long[2];
            enemy[0]=sc.nextLong();
            enemy[1]=sc.nextLong();
            for (long [] p:paotai){
                if(distance(p,enemy)<=dis){
                    res++;
                }
            }
            System.out.println(res+"x");
        }
    }
    public static double distance(long []a,long[]b){
        return Math.sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
    }
}
