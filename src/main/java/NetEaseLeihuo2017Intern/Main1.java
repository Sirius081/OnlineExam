package NetEaseLeihuo2017Intern;

import java.util.Scanner;

/**
 * Created by sirius on 2017/7/2.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String strs=sc.next();
            if (strs.length()==0){
                System.out.println();
                continue;
            }
            char last=strs.charAt(0);
            int count=1;
            StringBuffer sb=new StringBuffer();
            for (int i=1;i<strs.length();i++){
                if(strs.charAt(i)==last){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(last);

                    last=strs.charAt(i);
                    count=1;
                }
            }
            sb.append(count);
            sb.append(last);

            System.out.println(sb);
        }
    }
}
