package Tencent2017Autumn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sirius on 2017/7/2.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean[] isPrime=new boolean[1001];
        for (int i=0;i<isPrime.length;i++){
            isPrime[i]=true;
        }
        Set<Integer> primes=new HashSet<>();
        for (int i=2;i<isPrime.length;i++){
            if (isPrime[i]){
                primes.add(i);
                for (int j=2;j*i<isPrime.length;j++) isPrime[j*i]=false;
            }
        }
        while (sc.hasNext()){
            int sum=sc.nextInt();
            int count=0;
            for (int a:primes){

                if(primes.contains(sum-a)&&a<sum/2){
                    count++;
                }
            }
            if (primes.contains(sum/2)){
                count++;
            }
            System.out.println(count);
        }
    }
}
