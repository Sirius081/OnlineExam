package NetEaseLeihuo2017Intern;

import java.util.Scanner;

/**
 * Created by sirius on 2017/7/2.
 */
public class Main2_80 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int d=sc.nextInt();
            int [][]nums=new int[n][n];
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    nums[i][j]=sc.nextInt();
                }
            }
            int max=Integer.MIN_VALUE;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (j+d-1<n){
                        int tem=0;
                        for (int t=0;t<=d-1;t++){
                            tem+=nums[i][j+t];
                        }
                        max=Math.max(max,tem);
                    }
                    if(i+d-1<n){
                        int tem=0;
                        for (int t=0;t<=d-1;t++){
                            tem+=nums[i+t][j];
                        }
                        max=Math.max(max,tem);
                    }
                    if(i+d-1<n&&j+d-1<n){
                        int tem=0;
                        for (int t=0;t<=d-1;t++){
                            tem+=nums[i+t][j+t];
                        }
                        max=Math.max(max,tem);
                    }
                    if (i-(d-1)>=0&&j-(d-1)>=0){
                        int tem=0;
                        for (int t=0;t<=d-1;t++){
                            tem+=nums[i-t][j-t];
                        }
                        max=Math.max(max,tem);
                    }
                }

            }
            System.out.println(max);
        }
    }
}
