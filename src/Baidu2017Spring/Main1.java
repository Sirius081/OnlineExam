package Baidu2017Spring;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sirius on 17-6-19.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            Set<Integer> priceSet=new HashSet<>();
            PriorityQueue<Integer> q=new PriorityQueue<>();
            for (int i=0;i<n;i++){
                int price=sc.nextInt();
                if (!priceSet.contains(price)){
                    priceSet.add(price);
                    q.offer(price);
                }
            }
            if(q.size()>=3) {
                q.poll();
                q.poll();
                System.out.println(q.poll());
            }else {
                System.out.println(-1);
            }
        }
    }
}
