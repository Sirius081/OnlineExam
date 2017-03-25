package NetEase2016Yanfa;

import java.util.*;

/**
 * Created by sirius on 17-3-24.
 * https://www.nowcoder.com/test/710847/summary
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//n门课
            long r=sc.nextLong();//满分
            long avg=sc.nextLong();//最低平均分
            long req=n*avg;
            int N=n;
            long score=0;
            long [][] map=new long[n][2];
            while(N>0){
                long ai=sc.nextLong();//平时成绩
                score+=ai;
                long bi=sc.nextLong();//性价比
                map[n-N]=new long[]{ai,bi};
                N--;

            }
            Arrays.sort(map, new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return (int)(o1[1]-o2[1]);
                }
            });
            long time=0;

            for (long[]m:map){
                 if(score>=req){
                    break;
                }else{
                    long bi=m[1];//性价比
                    long ai=m[0];//平时成绩
                    long t=r-ai;//这门课最多可以多拿t分
                    if(score+t<=req){//没学到满分
                        score+=t;
                        time+=t*bi;
                    }else{//学满分数就超量

                        time+=(req-score)*bi;
                        score=req;
                    }
                }
            }
            System.out.println(time);
        }
    }
}
