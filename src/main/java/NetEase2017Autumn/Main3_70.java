package NetEase2017Autumn;

import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main3_70 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int [] res=new int[100001];
            for (int i=0;i<res.length;i++){
                res[i]=Integer.MAX_VALUE;
            }
            res[start]=0;
            for (int i=start;i<=end;i++){
                if (res[i]==Integer.MAX_VALUE){
                    continue;
                }
                for (int j=2;j<Math.sqrt(i)+1;j++){
                    if (i+j>end) break;
                    if (i%j==0){
                        res[i+j]=Math.min(res[i]+1,res[i+j]);
                        res[i+i/j]=Math.min(res[i+i/j],res[i]+1);
                    }
                }
            }
            if (res[end]==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(res[end]);
            }
        }
    }

}
