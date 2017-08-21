package NetEase2017Autumn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer> set=new HashSet<>();
        while (sc.hasNext()){
            int n=sc.nextInt();
            for (int i=1;i*i<=n;i++){
                set.add(i*i);
            }
            int res=0;
            for (int i:set){
                if (set.contains(n-i)){
                    res+=4;
                }
            }
            if (set.contains(n)){
                res+=4;
            }
            System.out.println(res);
        }
    }
}
