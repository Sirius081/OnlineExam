package Baidu2017Spring;

import java.util.Scanner;

/**
 * Created by sirius on 17-6-19.
 */
//5
//        R 0 0 0
//        R 0 4 0
//        R 0 0 3
//        G 92 14 7
//        G 12 16 8
public class Main3 {
    void swap(int[]points,int i,int j){

    }
    int permutation(int[]points,int start, int end,int min){
        for (int i=start;i<end;i++){

        }
        return  0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            Point[] points=new Point[n];
            for(int i=0;i<n;i++){
                points[i]=new Point(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            }

        }
    }
}
class Point{
    String color;
    int x;
    int y;
    int z;

    public Point(String color, int x, int y, int z) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}