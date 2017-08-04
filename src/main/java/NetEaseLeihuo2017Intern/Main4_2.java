package NetEaseLeihuo2017Intern;

import java.util.Scanner;

public class Main4_2 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            double res=2;
            double t=1;
            for(int i=1;i<n;i++){
                t*=0.5;
            }
            res-=t;
            System.out.println(String.format("%.4f",res ));
        }

    }
}
