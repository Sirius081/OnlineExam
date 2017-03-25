package NowCoderMoni2.ac;

import java.util.*;

/**
 * Created by sirius on 17-3-24.
 */
public class StrToVec {

    public static String strToVec(String s){
        int[]count=new int[26];
        StringBuffer sb=new StringBuffer();
        for(char c:s.toCharArray()){
            count[c-'a']++;

        }
        for(int i:count){
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            int count=0;
            Set<String> vecs=new HashSet<>();
            while(N-->0){
                String s=sc.next();
                vecs.add(strToVec(s));
            }
            System.out.println(vecs.size());
        }
    }
}
