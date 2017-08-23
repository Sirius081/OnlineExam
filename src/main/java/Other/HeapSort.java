package Other;

/**
 * Created by sirius on 17-8-23.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[]nums=new int[]{2,3,1,6,8,7,5,4};
        buildHeap(nums);
        int heapSize=nums.length;
        for (int i=0;i<nums.length;i++){
            swap(nums,0,nums.length-1-i);
            fixDownHeap(nums,0,--heapSize);
        }
        for (int i:nums){
            System.out.println(i);
        }
    }
    public static void buildHeap(int[] nums){
        for (int i=nums.length/2;i>=0;i--){
            fixDownHeap(nums,i,nums.length);
        }
    }
    public static void fixDownHeap(int []nums,int index,int heapSize){
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;
        if (left<heapSize&&nums[left]>nums[largest]){
            largest=left;
        }
        if (right<heapSize&&nums[right]>nums[largest]){
            largest=right;
        }
        if (largest!=index){
            swap(nums,largest,index);
            fixDownHeap(nums,largest,heapSize);
        }
    }
    public static void swap(int []nums, int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
