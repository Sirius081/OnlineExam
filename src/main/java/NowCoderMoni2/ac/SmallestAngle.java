package NowCoderMoni2.ac;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class SmallestAngle {//ac
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            int maxX=Integer.MIN_VALUE;
            int minX=Integer.MAX_VALUE;
            int maxY=Integer.MIN_VALUE;
            int minY=Integer.MAX_VALUE;

            while(N-->0){
                int x=sc.nextInt();
                minX=minX<=x?minX:x;
                maxX=maxX>=x?maxX:x;
                int y=sc.nextInt();
                minY=minY<=y?minY:y;
                maxY=maxY>=y?maxY:y;
            }
            System.out.println((maxY-minY)*(maxX-minX));
        }
    }
}
