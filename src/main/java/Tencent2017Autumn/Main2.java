package Tencent2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/7/2.
 */
public class Main2 {
    public static void main(String[] args) {
        boolean []finished=new boolean[1025];
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(a>1024||a<0||b>1024||b<0){
                System.out.println(-1);
                continue;
            }
            finished[a]=true;
            System.out.println(finished[b]?1:0);
        }
    }
}
