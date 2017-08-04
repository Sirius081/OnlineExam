package DIDI2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 17-6-7.
 * https://www.nowcoder.com/test/3701760/summary
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int []nums=new int[n];
            for (int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            int max=nums[0];
            int maxEnd=nums[0];
            for (int i=1;i<n;i++){

                int num=nums[i];
                maxEnd=Math.max(maxEnd+num,num);
                max=Math.max(max,maxEnd);
            }
            System.out.println(max);

        }
    }
}
