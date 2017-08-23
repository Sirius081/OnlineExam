package Huawei2016Yanfa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sirius on 17-8-23.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            Set<Character> s=new HashSet<>();
            for (char c :str.toCharArray()){
                if (!s.contains(c)){
                    s.add(c);
                    System.out.printf(c+"");
                }
            }
            System.out.println();
        }
    }
}
