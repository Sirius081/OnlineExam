package Baidu2017Spring;

import java.util.*;

/**
 * Created by sirius on 17-6-19.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            List<Integer> nums=new ArrayList<>();
            PriorityQueue<Integer> q=new PriorityQueue<>();
            for(int i=0;i<n;i++){
                int num=sc.nextInt();
                nums.add(num);
                q.offer(num);
            }
            int res=0;
            for (int i=0;i<n;i++){
                int a1=nums.get(i);
                int a2=q.peek();
                if(a1==a2){
                    int j=i;
                    int t=q.poll();
                    while(nums.get(j)==t){
                        j++;
                        if (j>=n)break;
                        t=q.poll();
                    }
                    res=n-(j-i);
                    break;
                }


            }
            System.out.println(res);
        }
    }
}
