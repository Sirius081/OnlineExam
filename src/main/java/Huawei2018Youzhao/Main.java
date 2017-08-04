package Huawei2018Youzhao;

import java.util.Scanner;

/**
 * Created by sirius on 2017/6/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            int last_type=-1;// 0字母 1 数字  2字母
            char first=str.charAt(0);
            if((first>='a' && first<='z')||(first>='A'&& first<='Z')){//字母
                last_type=0;
            }else if (first>='0'&&first<='9'){//数字
                last_type=1;
            }else {
                last_type=2;
            }
            int []counter=new int[3];

            for(int i=1;i<str.length();i++){
                char c=str.charAt(i);
                int current_type=-1;
                if((c>='a' && c<='z')||(c>='A'&& c<='Z')){//字母
                    current_type=0;
                }else if (c>='0'&&c<='9'){//数字
                    current_type=1;
                }else {
                    current_type=2;
                }
                if (current_type!=last_type){
                    counter[last_type]++;
                    last_type=current_type;
                }
            }
            counter[last_type]++;
            System.out.println(counter[0]+","+counter[1]+","+counter[2]);
        }
    }
}
