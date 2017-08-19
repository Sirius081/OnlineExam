package Tencent2017Intern;



import java.util.Scanner;

/**
 * Created by sirius on 2017/8/19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            char []ss=sc.next().toCharArray();
            int up_cnt=0;
            int low_cnt=0;
            for (char c :ss){
                if(c>='a'&&c<='z'){
                    low_cnt++;
                }else{
                    up_cnt++;
                }
            }
            int high=ss.length-1;
            while (high>=0&&isUp(ss[high])) high--;
            if (high<0){
                System.out.println(new String(ss));
                continue;
            }
            for (int i=0;i<low_cnt;i++){
                if (isUp( ss[i])){
                    char t=ss[i];
                    for (int j=i;j<high;j++){
                        ss[j]=ss[j+1];
                    }
                    ss[high]=t;
                    i--;
                }
            }
            System.out.println(new String(ss));
        }
    }
    public static boolean isUp(char c){
        return c>='A'&&c<='Z';
    }
}
