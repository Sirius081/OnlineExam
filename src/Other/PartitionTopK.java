package Other;

import java.util.*;

public class PartitionTopK {
    public int partition(int []a,int low,int high,int k){
        int left=low;
        int right=high;
        int pivot=low;
        while(low<high){
            while(a[high]>=a[pivot]&&low<high){
                high--;
            }
            while(a[low]<=a[pivot]&&low<high){
                low++;
            }
            int t=a[low];
            a[low]=a[high];
            a[high]=t;
        }
        int t=a[low];
        a[low]=a[pivot];
        a[pivot]=a[low];
        if(low-pivot==k-1){
            return a[low];
        }else{
            if(low-pivot<k-1){
                return partition(a,low,right,k-low+pivot);
            }else{
                return partition(a,left,low,k);
            }
        }
    }
    public int findKth(int[] a, int n, int K) {
        // write code here
        return partition(a,0,n-1,K);
    }
    public static void main(String[] args) {
        int []a=new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
       int t= new PartitionTopK().findKth(a,49,24);
        System.out.println(t);
        Arrays.sort(a);
        System.out.println(a[23]);
    }
}