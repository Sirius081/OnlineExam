package Tencent2017Intern;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int [] nums=new int[n];
            for (int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            Arrays.sort(nums);
            int min_cnt=0;
            int max_cnt=0;
            int min_diff=Integer.MAX_VALUE;
            int min_diff_cnt=0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==nums[0]){
                    min_cnt++;
                }
                if (nums[i]==nums[nums.length-1]){
                    max_cnt++;
                }
                if (i<nums.length-1){
                    int diff=nums[i+1]-nums[i];
                    if (diff==min_diff){
                        min_diff_cnt++;
                    }else if (diff<min_diff){
                        min_diff=diff;
                        min_diff_cnt=1;
                    }
                }
            }
            if (min_diff==0){
                min_diff_cnt=0;
                int zero_diff_cnt=0;
                for (int i=0;i<nums.length-1;i++){
                    if (nums[i]==nums[i+1]){
                        zero_diff_cnt++;
                    }else{
                        min_diff_cnt+=zero_diff_cnt*(zero_diff_cnt+1)/2;
                        zero_diff_cnt=0;
                    }
                }
                min_diff_cnt+=zero_diff_cnt*(zero_diff_cnt+1)/2;
            }
            //1 2
            if (nums[0]!=nums[nums.length-1]){
                System.out.println(min_diff_cnt+" "+max_cnt*min_cnt);
            }else{
                int nn=nums.length;
                System.out.println((nn*(nn-1)/2)+" "+(nn*(nn-1)/2));
            }
        }
    }
}
