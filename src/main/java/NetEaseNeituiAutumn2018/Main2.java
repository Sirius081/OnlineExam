package NetEaseNeituiAutumn2018;

import java.util.*;

/**
 * Created by sirius on 2017/8/12.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            long []x=new long[n];
            long []y=new long[n];
            Point [] points=new Point[n];
            for (int i=0;i<n;i++){
                x[i]=sc.nextLong();
            }
            for (int i=0;i<n;i++){
                y[i]=sc.nextLong();
                points[i]=new Point(x[i],y[i],n);
            }
            long []res=new long[n];
            for (int i=1;i<n;i++){
                res[i]=Long.MAX_VALUE;
            }
            for (int i=0;i<n;i++){
                long [] dis=new long[n];
                for (int j=0;j<n;j++){
                    dis[j]=getDis(points[i],points[j]);
                }
                Arrays.sort(dis);
                for (int j=1;j<n;j++){
                    dis[j]+=dis[j-1];
                    res[j]=Math.min(dis[j],res[j]);
                }
            }
//            for (int i=1;i<=n;i++){
//                long min_dis=Long.MAX_VALUE;
//                for (Point p:points){
//                    min_dis=Math.min(min_dis,p.dis[i-1]);
//                    res[i-1]=min_dis;
//                }
//            }
            StringBuffer sb=new StringBuffer();
            for (int i=0;i<n-1;i++){
                sb.append(res[i]+" ");
            }
            sb.append(res[n-1]);
            System.out.println(sb);
        }
    }
    public static long getDis(Point p1,Point p2){
        return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
    }
}

class Point{
    long x;
    long y;

    public Point(long x, long y,int n) {
        this.x = x;
        this.y = y;

    }
}