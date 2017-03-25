package NetEase2016Intern;

import java.util.Scanner;

/**
 * Created by sirius on 17-3-24.
 */
public class Main3Mogu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            int M=sc.nextInt();
            int K=sc.nextInt();
            int [][] mogu=new int[N][M];
            while(K-->0){
                int x=sc.nextInt();
                int y=sc.nextInt();
                mogu[x-1][y-1]++;
            }
            int res=0;
            int max=Integer.MIN_VALUE;
            int maxI=0;
            int maxJ=0;
            for(int i=0;i<N-2;i++){
                for(int j=0;j<M-2;j++){//扫描附近9个格子
                    int count=0;
                    for(int ii=0;ii<3;ii++){
                        for(int jj=0;jj<3;jj++){
                            if(mogu[i+ii][j+jj]>0){
                                count+=1;
                            }
                        }
                    }
                    if(max<count){
                        maxI=i;
                        maxJ=j;
                        max=count;
                    }

                }
            }
            res+=max;
            max=Integer.MIN_VALUE;
            for(int ii=0;ii<3;ii++){
                for(int jj=0;jj<3;jj++){
                    if(mogu[maxI+ii][maxJ+jj]>0){
                        mogu[maxI+ii][maxJ+jj]--;
                    }
                }
            }
            for(int i=0;i<N-2;i++){
                for(int j=0;j<M-2;j++){//扫描附近9个格子
                    int count=0;
                    for(int ii=0;ii<3;ii++){
                        for(int jj=0;jj<3;jj++){
                            if(mogu[i+ii][j+jj]>0){
                                count+=1;
                            }

                        }
                    }
                    if(max<count){
                        max=count;
                    }

                }
            }
            System.out.println(res+max);
        }
    }
}
