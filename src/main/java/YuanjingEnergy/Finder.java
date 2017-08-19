package YuanjingEnergy;

/**
 * Created by sirius on 2017/8/5.
 */
import java.util.*;

public class Finder {
    public int findString(String[] str, int n, String x) {
        // write code here
        int low=0;
        int high=n-1;
        while (low<=high){
            int mid=(low+high)/2;
            while (str[mid].equals("")&&mid>=0){
                mid--;
            }
            while (str[mid].equals("")&&mid<n){
                mid++;
            }
            int tem=str[mid].compareTo(x);
            if (tem==0){
                return mid;
            }else if (tem>0){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String [] str={"a","b","","c","","d"};
        Finder f=new Finder();
        f.findString(str,6,"c");
    }
}