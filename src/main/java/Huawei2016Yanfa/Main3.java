package Huawei2016Yanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sirius on 17-8-23.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int [][] map=new int[9][9];
            boolean [][]row_used=new boolean[10][10];
            boolean [][]col_used=new boolean[10][10];


            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    map[i][j]=sc.nextInt();
                    if (map[i][j]!=0){
                        row_used[i][map[i][j]]=true;
                        col_used[j][map[i][j]]=true;
                    }
                }
            }
            dfs(map,col_used,row_used);
            for (int i=0;i<9;i++){
                for (int j=0;j<8;j++){
                    System.out.printf(""+map[i][j]+" ");
                }
                System.out.println(map[i][8]);
            }
        }
    }
    public static boolean dfs(int[][] map,boolean[][]row_used,boolean[][]col_used){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (map[i][j]==0){
                    boolean hasNum=false;
                    for (int t=1;t<=9;t++){
                        if (!row_used[i][t]&&!col_used[j][t]){
                            hasNum=true;
                            row_used[i][t]=true;
                            col_used[j][t]=true;

                            map[i][j]=t;
                            if (dfs(map,col_used,row_used)){
                                return true;
                            }

                            row_used[i][t]=false;
                            col_used[j][t]=false;
                            map[i][j]=0;
                        }
                    }
                    if (!hasNum){
                        return false;
                    }
                }
            }
        }
        return  true;
    }
}
