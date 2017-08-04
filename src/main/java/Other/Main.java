package Other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sirius on 16-10-10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String compo=sc.next();
            int m=sc.nextInt();
            Set<Integer> pairs=new HashSet<>();
            for(int i=0;i<m;i++){
                StringBuffer pair=new StringBuffer(sc.next());
                pairs.add(pairToInt( pair.toString()));
                pairs.add(pairToInt(pair.reverse().toString()));
            }
            char [] com=compo.toCharArray();
            int [] count=new int[n];
            count[0]=0;
            if(n==1){
                System.out.println(0);
            }else{
                int depth=0;
                for(int i=1;i<n;i++){
                    int j=i-1;

                    int min=Integer.MAX_VALUE;
                    int minIndex=j;
                    for(;j>=0;j--){
                        String p=""+com[j]+com[i];

                        if(!pairs.contains(pairToInt(p))){
                            break;
                        }else{
                            if(count[j]+1<min && j<i-depth){
                                min=count[j]+1;
                                minIndex=j;
                            }
                        }
                    }

                    if(j>=0){
                        count[i]=count[j]+i-j-1;
                    }else{
                        count[i]=i;
                    }
                    if(count[i]>min){
                        count[i]=min;
                        if(minIndex==j-1){
                            depth++;
                        }else{
                            depth=0;
                        }


                    }else{
                        depth=0;
                    }
                }
                System.out.println(count[n-1]);
            }
        }
    }
    public static int pairToInt(String pair){
        int result=0;
        result+=(pair.charAt(0)-'a')*26+(pair.charAt(1)-'a');
        return result;
    }
}
