import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,5,4,8,7,1};
        Test t=new Test();
        t.buildHeap(nums);
        int heapSize=nums.length;
        for (int i=0;i<nums.length;i++){
            int tt=nums[heapSize-1];
            nums[heapSize-1]=nums[0];
            nums[0]=tt;
            heapSize--;
            t.maxHead(nums,heapSize,0);

        }
        for (int i :nums){
            System.out.println(i);
        }
    }
    public void buildHeap(int[]nums){
        for (int i=nums.length/2;i>=0;i--){
            maxHead(nums,nums.length,i);
        }
    }
    public void maxHead(int[]nums,int headSize,int index){
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;
        if (left<headSize&&nums[largest]<nums[left]){
            largest=left;
        }
        if (right<headSize&&nums[largest]<nums[right]){
            largest=right;
        }
        if (largest!=index){
            int t=nums[index];
            nums[index]=nums[largest];
            nums[largest]=t;

            maxHead(nums,headSize,largest);
        }
    }
}