package Huawei2016Yanfa;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            LoopList head=new LoopList(0);
            LoopList p=head;
            for (int i=1;i<n;i++){
                LoopList ll=new LoopList(i);
                p.next=ll;
                p=p.next;
            }
            p.next=head;
            p=p.next;
            while (p.next!=p){
                p.next.next=p.next.next.next;
                p=p.next.next;
            }
            System.out.println(p.val);
        }
    }
}
class LoopList{
    int val;
    LoopList next;
    public LoopList(int val){
        this.val=val;
    }
}