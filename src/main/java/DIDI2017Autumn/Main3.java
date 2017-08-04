package DIDI2017Autumn;


import java.util.*;


/**
 * Created by sirius on 17-6-9.
 */
enum Direction{
    up,down,left,right;
}
public class Main3 {
    public static List<DP> run(int m,int n,int tili,int[][] map){
        DP zhongdian=new DP(tili, Direction.down,0,n-1);
        List<DP> optimalDP=new ArrayList<>();
        DP[][] dps=new DP[m][n];
        dps[0][n-1]=zhongdian;
        optimalDP.add(zhongdian);
        while(optimalDP.size()<m*n){
            PriorityQueue<DP> candidateDP=new PriorityQueue<>();
            for (DP dp:optimalDP){
                if(dp.x>0&&map[dp.x-1][dp.y]==1&&dps[dp.x-1][dp.y]==null){
                    candidateDP.add(new DP(dp.stepsLeft, Direction.down,dp.x-1,dp.y));
                }
                if (dp.x<m-1&&map[dp.x+1][dp.y]==1&&dps[dp.x+1][dp.y]==null){
                    candidateDP.add(new DP(dp.stepsLeft-3, Direction.up,dp.x+1,dp.y));
                }
                if (dp.y>0&&map[dp.x][dp.y-1]==1&&dps[dp.x][dp.y-1]==null){
                    candidateDP.add(new DP(dp.stepsLeft-1, Direction.right,dp.x,dp.y-1));
                }
                if(dp.y<n-1&&map[dp.x][dp.y+1]==1&&dps[dp.x][dp.y+1]==null){
                    candidateDP.add(new DP(dp.stepsLeft-1, Direction.left,dp.x,dp.y+1));
                }

            }
            DP opt=candidateDP.peek();

            if (opt==null||opt.stepsLeft<0){
                System.out.println("Can not escape!");
                return optimalDP;
            }else{
                optimalDP.add(opt);
                dps[opt.x][opt.y]=opt;
                if (opt.x==0&&opt.y==0){
                    DP iter=opt;
                    while(!(iter.x==0&&iter.y==n-1)){
                        System.out.print("["+iter.x+","+iter.y+"],");
                        switch (iter.directionLast){
                            case up:{
                                iter=dps[iter.x-1][iter.y];
                                break;
                            }
                            case down:{
                                iter=dps[iter.x+1][iter.y];
                                break;
                            }
                            case left:{
                                iter=dps[iter.x][iter.y-1];
                                break;
                            }
                            case right:{
                                iter=dps[iter.x][iter.y+1];
                                break;
                            }
                        }
                    }
                    System.out.println("["+(0)+","+(n-1)+"]");
                    return optimalDP;
                }
            }
        }
        return optimalDP;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            int tili=sc.nextInt();//体力
            int [][] map=new int[m][n];
            for (int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    map[i][j]=sc.nextInt();
                }
            }

        run(m,n,tili,map);


        }
    }
}
class  DP implements Comparable<DP>{
    int stepsLeft;
    Direction directionLast;
    int x;
    int y;

    public DP(int stepsLeft, Direction directionLast, int x, int y) {
        this.stepsLeft = stepsLeft;
        this.directionLast = directionLast;
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(DP o) {
        return o.stepsLeft-this.stepsLeft;
    }
}

