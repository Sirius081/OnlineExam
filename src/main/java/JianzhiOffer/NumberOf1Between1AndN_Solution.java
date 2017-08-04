package JianzhiOffer;

/**
 * Created by sirius on 2017/7/9.
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int t=n;
        int base=1;
        int count=0;
        while(t>=10){
            int num=t%10;
            t=t/10;
            count+=(t-1)*base;
            if(num>=1){
                count+=base;
            }
            base*=10;
        }
        if(t==1){
            count++;
        }else{
            count+=base;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution n=new NumberOf1Between1AndN_Solution();
        System.out.println(n.NumberOf1Between1AndN_Solution(100));
    }
}
