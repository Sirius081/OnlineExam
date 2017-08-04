package NetEase;

import java.util.Scanner;


public class Main3 {
    public static  double Power(double base, int exponent) {
        if(exponent==0)return 1;
        if(exponent==1)return base;
        double res=Power(base,exponent>>1);
        res*=res;
        if(exponent%2==1){
            res*=base;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(Power(2,1));
        System.out.println(1&1);
        System.out.println(3>>1);
        while(sc.hasNext()){
            String str=sc.next();
            long numOfG=0;//g�ĸ���
            for(char c:str.toCharArray()){
                if(c=='G'){
                    numOfG++;
                }
            }
            System.out.println(Math.min(steps(str,'B'),steps(str,'G')));
        }
    }
    public static long steps(String str,char ch){
        long numOfCh=0;
        for(char c:str.toCharArray()){
            if(c==ch){
                numOfCh++;
            }
        }
        //�ж�ǰnumOfCh���numOfCh���ı�ch�϶�
        long prior=0;
        long post=0;
        for(int i=0;i<numOfCh;i++){
            if(str.charAt(i)==ch){
                prior++;
            }
            if(str.charAt(str.length()-i-1)==ch){
                post++;
            }
        }
        long steps=0;

        if(post<prior){//ǰ�벿�ֶ࣬��Ѻ�벿�ֵ�ch�Ƶ�ǰ�벿��
            int noCh=0;
            while(str.charAt(noCh)==ch&&noCh<numOfCh){
                noCh++;
            }
            for(int i=0;i<str.length()-numOfCh&&noCh<numOfCh;i++){
                int t=str.length()-i-1;
                if(str.charAt(t)==ch){
                    steps+=t-noCh;
                    noCh++;
                    while(str.charAt(noCh)==ch&&noCh<numOfCh){
                        noCh++;
                    }
                }
            }

        }else{
            int noCh=str.length()-1;
            while(str.charAt(noCh)==ch&&noCh>str.length()-numOfCh-1){
                noCh--;
            }
            for(int i=0;i<str.length()-numOfCh&&noCh>str.length()-numOfCh-1;i++){
                int t=i;
                if(str.charAt(t)==ch){
                    steps+=noCh-i;
                    noCh--;
                    while(str.charAt(noCh)==ch&&noCh>str.length()-numOfCh-1){
                        noCh--;
                    }
                }
            }

        }
        return steps;
    }
}











