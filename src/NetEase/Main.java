package NetEase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//n个数字
            long k=sc.nextLong();//k次变化
            long []nums=new long[n];
            for (int i=0;i<n;i++){
                nums[i]=sc.nextLong();
            }
            while(k-->0){
                long first=nums[0];//第一个数
                for(int i=0;i<n-1;i++){
                    nums[i]=nums[i]+nums[i+1];
                    nums[i]%=100;
                }
                nums[n-1]=nums[n-1]+first;
                nums[n-1]%=100;
            }
            for(int i=0;i<n-1;i++){
                System.out.printf(nums[i]+" ");
            }
            System.out.println(nums[n-1]);
        }
    }
}
