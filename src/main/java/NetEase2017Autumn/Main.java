package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int [] nums=new int[n];
            for (int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            int low=0;
            int high=nums.length-1;
            int res=0;
            while (low<=high){
                if (nums[low]==nums[high]){
                    low++;
                    high--;

                }else if (nums[low]<nums[high]){
                    nums[low+1]=nums[low]+nums[low+1];
                    low++;
                    res++;
                }else{
                    nums[high-1]=nums[high]+nums[high-1];
                    high--;
                    res++;
                }
            }
            System.out.println(res);

        }
    }
}
