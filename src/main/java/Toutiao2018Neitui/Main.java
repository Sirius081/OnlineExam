package Toutiao2018Neitui;

import java.util.*;

/**
 * Created by sirius on 2017/8/22.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            Point[] points=new Point[n];
            for (int i=0;i<n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                points[i]=new Point(x,y);
            }
            List<Point> res=new ArrayList<>();
            for (int i=0;i<n;i++){
                boolean isMax=true;
                Point p=points[i];
                for (int j=0;j<n;j++){
                    if (j==i){
                        continue;
                    }
                    Point p2=points[j];
                    if (p.littleEqualThan(p2)){
                        isMax=false;
                        break;
                    }
                }
                if (isMax){
                    res.add(points[i]);
                }
            }
            Collections.sort(res, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.x-o2.x;
                }
            });
            for (Point p:res){
                System.out.println(p.x+" "+p.y);
            }
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean littleEqualThan(Point p){
        return this.x<=p.x&&this.y<=p.y;
    }
}