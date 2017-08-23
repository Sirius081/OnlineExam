package NetEaseYouDao2017Neitui;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by sirius on 2017/8/21.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int t=sc.nextInt();
            while (t-->0){
                int n=sc.nextInt();
                Num[] nums=new Num[n];
                for (int i=0;i<n;i++){
                    nums[i]=new Num();
                }
                Queue<Num> q=new LinkedList<>();
                Collections.addAll(q,nums);
                int count=1;
                while(!q.isEmpty()){
                    Num num=q.peek();
                    q.poll();
                    q.offer(num);
                    num=q.peek();
                    num.value=count++;
                    q.poll();
                }
                StringBuffer sb=new StringBuffer();
                for (int i=0;i<nums.length-1;i++){
                    sb.append(nums[i].value+" ");
                }
                sb.append(nums[nums.length-1].value);
                System.out.println(sb.toString());
            }
        }
    }
}
class Num{
    int value;
}