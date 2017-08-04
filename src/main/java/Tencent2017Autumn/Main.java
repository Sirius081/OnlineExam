package Tencent2017Autumn;

import java.util.*;

/**
 * Created by sirius on 2017/7/2.
 */
public class Main {

    static void getStrs(int n,List<String> strs,StringBuffer sb){
        if (n==0){
            strs.add(sb.toString());
            return;
        }
        for (int i=0;i<25;i++){
            sb.append((char)('a'+i));
            getStrs(n-1,strs,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> strs=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        for (int i=1;i<=4;i++){
            getStrs(i,strs,sb);
        }
        Collections.sort(strs);
        while(sc.hasNext()){
            String str=sc.next();
//            int index=0;
//            for (int i=0;i<str.length();i++){
//                for (int j=0;j<4-i;j++){
//                    index+=Math.pow(25,j)*(str.charAt(i)-'a');
//                }
//            }
            System.out.println(strs.indexOf(str));
        }
    }
}
