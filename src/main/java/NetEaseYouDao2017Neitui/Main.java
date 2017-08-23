package NetEaseYouDao2017Neitui;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int T=sc.nextInt();
            while (T-->0){
                int n=sc.nextInt();
                int k=sc.nextInt();
                int []nums=new int[2*n];
                for (int i=0;i<2*n;i++){
                    nums[i]=sc.nextInt();
                }
                for (int i=0;i<k;i++){
                    shuffle(nums);
                }
                StringBuffer sb=new StringBuffer();
                for (int i=0;i<nums.length-1;i++){
                    sb.append(nums[i]+" ");
                }
                sb.append(nums[nums.length-1]);
                System.out.println(sb.toString());
            }
        }
    }
    public static void shuffle(int []nums){
        int[] tem=new int[nums.length];
        for (int i=0;i<nums.length;i+=2){
            tem[i]=nums[i/2];
            tem[i+1]=nums[nums.length/2+i/2];
        }
        System.arraycopy(tem,0,nums,0,nums.length);
    }
}
