package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int x=sc.nextInt();
            int y=sc.nextInt();
            System.out.println(rev(rev(x)+rev(y)));
        }
    }
    public static int rev(int x){
        return Integer.parseInt(new StringBuffer(""+x).reverse().toString());
    }
}
