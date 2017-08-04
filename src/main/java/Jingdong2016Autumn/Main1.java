package Jingdong2016Autumn;

import java.util.*;

/**
 * Created by sirius on 2017/7/16.
 */
public class Main1 {
    public int getMost(int[][] board) {
        List<Point> best=new ArrayList<>();
        Set<Integer> xy=new HashSet<>();
        best.add(new Point(5,5,board[5][5]));
        xy.add(5*6+5);
        while(best.size()<36){
            int max=Integer.MIN_VALUE;
            List<Point> candidate=new ArrayList<>();

            for (Point p :best){
                if (p.y-1>=0 ){//左边
                    Point left=new Point(p.x,p.y-1,p.bonus+board[p.x][p.y-1]);
                    if (!xy.contains(left.getXY())){
                        candidate.add(left);
                        max=Math.max(left.bonus,max);

                    }
                }
                if (p.x-1>=0){
                    Point up=new Point(p.x-1,p.y,p.bonus+board[p.x-1][p.y]);
                    if(!xy.contains(up)){
                        candidate.add(up);
                        max=Math.max(up.bonus,max);
                    }
                }
            }
            for (Point p :candidate){
                if(p.bonus==max){
                    best.add(p);
                    xy.add(p.getXY());
                }
            }
        }
        int result=-1;
        for (Point p :best){
            if (p.x==0&&p.y==0){
                result=p.bonus;
                break;
            }
        }
        return result;
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean res=false;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]!=i){
                int j=i;
                while(numbers[j]!=j&&numbers[numbers[j]]!=numbers[j]){
                    int t=numbers[j];
                    numbers[j]=numbers[numbers[j]];
                    numbers[t]=t;

                }
            }
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]!=i){
                duplication[0]=numbers[i];
                res=true;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        duplicate(new int[]{2,3,1,4,2,5,0},7,new int[1]);
    }
}
class Point{
    int x;
    int y;
    int bonus;
    public int getXY(){
        return x*6+y;
    }
    public Point(int x, int y, int bonus) {
        this.x = x;
        this.y = y;
        this.bonus = bonus;
    }
}