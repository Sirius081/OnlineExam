package Huawei2016Autumn_1p9_3;

import java.util.Scanner;

/**
 * Created by sirius on 2017/7/16.
 * https://www.nowcoder.com/test/question/3897c2bcc87943ed98d8e0b9e18c4666?pid=260145&tid=9178132
 */
public class Main1AC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            long []nums=new long[n];
            for (int i=0;i<n;i++){
                nums[i]=sc.nextLong();
            }
            for (int i=0;i<m;i++){
                String c=sc.next();
                if (c.equals("U")){
                    int idx=sc.nextInt();
                    long num=sc.nextLong();
                    update(idx,num,nums);
                }else{
                    int start=sc.nextInt();
                    int end=sc.nextInt();
                    System.out.println(query(Math.min(start,end),Math.max(start,end),nums));
                }
            }
        }
    }
    public static void update(int idx,long num,long[]nums){
        nums[idx-1]=num;
    }
    public static long query(int start,int end,long[]nums){
        long max=Long.MIN_VALUE;
        for (int i=start-1;i<=end-1;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}
