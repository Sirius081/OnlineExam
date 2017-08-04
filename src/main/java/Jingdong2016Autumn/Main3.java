package Jingdong2016Autumn;

/**
 * Created by sirius on 2017/7/16.
 */
public class Main3 {
    public int getInitial(int n) {
        // write code here
        float tt = 1.0f;
        while (true) {
            boolean bingo = true;
            float t = tt;
            for (int i = 0; i <=n; i++) {
                int tem=Math.round(t);
                if (Math.round(t) != t || t <= 0) {
                    bingo = false;
                    break;
                }
                t = (t - 1) * (n - 1) / n;
            }

            if (bingo) {
                break;
            }
            tt++;
        }
        return (int) tt;
    }

    public static void main(String[] args) {
        Main3 m=new Main3();
        m.getInitial(2);
        m.getInitial(3);
    }
}
