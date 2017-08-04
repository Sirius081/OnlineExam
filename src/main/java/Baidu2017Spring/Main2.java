package Baidu2017Spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sirius on 17-6-19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int [] points=new int[n];
            for(int i=0;i<n;i++){
                points[i]=sc.nextInt();
            }
            if (n==2){
                System.out.println(Math.abs(points[1]-points[0]));
                continue;
            }
            int min=Integer.MAX_VALUE;
            for(int i=1;i<n-1;i++){
                int len=0;
                for (int j=1;j<n;j++){
                    if(j==i){
                        len+=Math.abs(points[j+1]-points[j-1]);
                        j++;
                    }else{
                        len+=Math.abs(points[j]-points[j-1]);
                    }

                }
                min=Math.min(min,len);
            }
            System.out.println(min);




        }
    }
}
