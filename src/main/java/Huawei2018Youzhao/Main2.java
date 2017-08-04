package Huawei2018Youzhao;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sirius on 2017/6/28.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();

            System.out.println(reverseWords(str));
        }
    }
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String s_trim= s.trim();
        Stack<Character> chracter_reversed = new Stack<>();


        boolean contain_space=false;
        for (int i=0; i< s_trim.length();i++){
            char c = s_trim.charAt(i);
            if (c==' '){
                if (!contain_space){
                    chracter_reversed.push(c);
                    contain_space=true;
                }
            }else{
                contain_space=false;
                chracter_reversed.push(c);
            }
        }
        Stack<Character> tem_stack = new Stack<>();
        while (!chracter_reversed.empty()){
            char temp =chracter_reversed.pop();
            if(temp==' '){
                while (!tem_stack.empty()){
                    char c =tem_stack.pop();
                    sb.append(c);
                }
                sb.append(' ');
            }else{
                tem_stack.push(temp);
            }
        }
        while (!tem_stack.empty()){
            char c =tem_stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }
}
