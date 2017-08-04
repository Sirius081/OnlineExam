package DIDI2017Autumn;

import java.util.*;

/**
 * Created by sirius on 17-6-7.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//n张桌子
            int m=sc.nextInt();//m批客人
            List<Integer> tables=new LinkedList<>();
            for (int i=0;i<n;i++){
                tables.add(sc.nextInt());
            }
            List<Guests> guests=new ArrayList<>();
            for (int i=0;i<m;i++){
                int cnt_p=sc.nextInt();
                int cnt_m=sc.nextInt();
                guests.add(new Guests(cnt_p,cnt_m));
            }
            Collections.sort(tables);
            Collections.sort(guests, new Comparator<Guests>() {
                @Override
                public int compare(Guests o1, Guests o2) {
                    return o2.cnt_m-o1.cnt_m;
                }
            });
            int res=0;
            for (Guests g :guests){
                Iterator<Integer> it=tables.iterator();
                while(it.hasNext()){
                    int t=it.next();
                    if (g.cnt_p<=t){
                        res+=g.cnt_m;
                        it.remove();
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
class Guests{
    int cnt_p;
    int cnt_m;

    public int getCnt_p() {
        return cnt_p;
    }

    public void setCnt_p(int cnt_p) {
        this.cnt_p = cnt_p;
    }

    public int getCnt_m() {
        return cnt_m;
    }

    public void setCnt_m(int cnt_m) {
        this.cnt_m = cnt_m;
    }

    public Guests(int cnt_p, int cnt_m) {
        this.cnt_p = cnt_p;
        this.cnt_m = cnt_m;
    }
}
