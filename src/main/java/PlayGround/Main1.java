package PlayGround;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sirius on 2017/7/1.
 */
public class Main1 {
    static int [] res=new int[59];
    static{
        res[1]=1;
        res[2]=1;
        for(int i=3;i<=58;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<=i/2;j++){
                max=Math.max(j*(i-j),Math.max(max,res[j]*res[i-j]));
            }
            res[i]=max;
        }

    }
    static Pattern p=Pattern.compile("(\\d+):(\\d+)");
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> minutes=new ArrayList<>();
        for (int i=0;i<timePoints.size();i++){

            Matcher m=p.matcher(timePoints.get(i));
            if (m.matches()){
                int hour=Integer.parseInt(m.group(1));

                int minute=Integer.parseInt(m.group(2));
                minutes.add(hour*60+minute);
                if (hour<=12){
                    minutes.add((hour+24)*60+minute);
                }
            }

        }
        Collections.sort(minutes);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<minutes.size()-1;i++){
            min=Math.min(minutes.get(i+1)-minutes.get(i),min);
        }
        return min;
    }
    public static void main(String[] args) {

        List<String> l=new ArrayList<>();
        l.add("\"23:59\"");
        l.add("\"12:23\"");
        l.add("\"19:23\"");
        l.add("\"10:45\"");
        findMinDifference(l);
    }
}
