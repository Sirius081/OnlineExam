package HuaweiYanfa;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            boolean [] hasNum=new boolean [2000];
            for (int i=0;i<n;i++){
                int num=sc.nextInt();
                hasNum[num]=true;
            }
            for (int i=1;i<2000;i++){
                if (hasNum[i]){
                    System.out.println(i);
                }
            }
        }
    }
}
