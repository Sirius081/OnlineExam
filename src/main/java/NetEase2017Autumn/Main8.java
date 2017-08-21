package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int y1=sc.nextInt();
            int y2=sc.nextInt();
            int y3=sc.nextInt();
            int y4=sc.nextInt();
            if (y1+y2-y3+y4!=0){
                System.out.println("No");
            }else{
                int c=(y3-y1-2*y2)/2;
                int b=c+y2;
                int a=b+y1;
                System.out.println(a+" "+b+" "+c);
            }
        }
    }
}
