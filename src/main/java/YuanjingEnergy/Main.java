package YuanjingEnergy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by sirius on 2017/8/5.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//num of mooncake
            int demand=sc.nextInt();
            PriorityQueue<MoonCake> q=new PriorityQueue<>(n,new Comparator<MoonCake>() {
                @Override
                public int compare(MoonCake o1, MoonCake o2) {
                    double res=o2.price-o1.price;
                    if (res==0){
                        return 0;
                    }else if (res>0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            long [] counts=new long[n];

            for (int i=0;i<n;i++){
                counts[i]=sc.nextLong();
            }
            for (int i=0;i<n;i++){
                long total_price=sc.nextLong();
                long count=counts[i];
                double price=total_price*1.0/count;
                MoonCake m=new MoonCake(count,price,total_price);
                q.add(m);
            }
            float res=0;
            while(demand>0&&q.size()>0){
                MoonCake m=q.poll();
                if (m.count<=demand){
                    demand-=m.count;
                    res+=m.total_price;
                }else{
                    res+=m.price*demand;
                    demand=0;
                }
            }
            System.out.println(String.format("%.2f",res));
        }
    }
}
class MoonCake{
    long count;
    double price;
    long total_price;
    public MoonCake(long count, double price,long total_price) {
        this.count = count;
        this.price = price;
        this.total_price=total_price;
    }
}