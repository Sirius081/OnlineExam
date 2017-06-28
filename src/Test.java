import java.util.Stack;

/**
 * Created by sirius on 17-3-25.
 */
public class Test {

    int permutation(int[]nums,int start,int end,int count){
        if(start==end-1){
            for(int i=0;i<nums.length;i++){
                System.out.println(nums[i]);
                if(!(nums[i]%(i+1)==0||(i+1)%nums[i]==0)){
                    return count;
                }

            }
            return count+1;
        }else{
            int res=count;
            for(int i=start;i<end;i++){
                swap(nums,start,i);
                res+=permutation(nums,start+1,end,count);
                swap(nums,start,i);
            }
            return res;
        }
    }
    void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public int countArrangement(int N) {
        int [] nums=new int[N];
        for(int i=0;i<N;i++){
            nums[i]=i+1;
        }
        int res=0;
        for (int i=0;i<nums.length-1;i++){

        }
        return permutation(nums,0,N,0);
    }



    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        Test t=new Test();
        t.countArrangement(2);
    }

}
