package NowCoderMoni2.ac;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class Triangle {//ac
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            int []lens=new int[N];
            for(int i=0;i<N;i++){
                lens[i]=sc.nextInt();
            }
            int res=0;
            for(int i=0;i<N-2;i++){
                for(int j=i+1;j<N-1;j++){
                    for(int k=j+1;k<N;k++){
                        if(isTriangle(lens[i],lens[j],lens[k])){
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
    public static boolean isTriangle(int a,int b,int c){
        int []ar={a,b,c};
        Arrays.sort(ar);
        return ar[0]+ar[1]>ar[2];
    }
}
