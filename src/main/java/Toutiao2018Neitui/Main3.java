package Toutiao2018Neitui;

import java.util.*;

/**
 * Created by sirius on 2017/8/22.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();//number of pm
            int m=sc.nextInt();//number of programmer
            int p=sc.nextInt();//number of idea
            List<Idea> ideas=new ArrayList<>();


            PriorityQueue<Idea> [] qs=new PriorityQueue[n];
            for (int i=0;i<n;i++){
                qs[i]=new PriorityQueue<>(p,new Comparator<Idea>() {
                    @Override
                    public int compare(Idea o1, Idea o2) {
                        if (o1.level!=o2.level){
                            return o2.level-o1.level;
                        }else if(o1.time_needed!=o2.time_needed){
                            return o1.time_needed-o2.time_needed;
                        }else{
                            return o1.pm-o2.pm;
                        }
                    }
                });
            }
            Idea[] ii=new Idea[p];

            for (int i=0;i<p;i++){
                int pm=sc.nextInt();
                int propose_time=sc.nextInt();
                int level=sc.nextInt();
                int time_needed=sc.nextInt();
                Idea idea=new Idea(pm, propose_time, level, time_needed);
                ideas.add(idea);
                ii[i]=idea;
            }
            int [] buzy_time=new int[m];
            for (int i=0;i<m;i++){
                buzy_time[i]=1;
            }
            int current=1;
            while (true){
                boolean hasEle=false;
                if (ideas.size()>0){
                    hasEle=true;
                }else{
                    for (int i=0;i<n;i++){
                        if (qs[i].size()>0){
                            hasEle=true;
                            break;
                        }
                    }
                }
                if (!hasEle){
                    break;
                }

                Iterator<Idea> iter=ideas.iterator();
                while (iter.hasNext()){
                    Idea i=iter.next();
                    if (i.propose_time<=current){
                        qs[i.pm-1].offer(i);
                        iter.remove();
                    }
                }

                for (int i=0;i<m;i++){
                    if (current<buzy_time[i]) {
                        continue;
                    }
                    for (int j=0;j<n;j++){
                        if (qs[j].size()>0) {
                            Idea idea=qs[j].poll();
                            idea.end_time=buzy_time[i]+idea.time_needed;

                            buzy_time[i]+=idea.time_needed;
                            break;
                        }

                    }


                }
                current=Integer.MAX_VALUE;
                for (int i :buzy_time){
                    current=Math.min(i,current);
                }
            }
            for (Idea i:ii){
                System.out.println(i.end_time);
            }
        }
    }
}
class Idea{
    int pm;
    int propose_time;
    int level;
    int time_needed;
    int end_time;

    public Idea(int pm, int propose_time, int level, int time_needed) {

        this.pm = pm;
        this.propose_time = propose_time;
        this.level = level;
        this.time_needed = time_needed;
    }
}