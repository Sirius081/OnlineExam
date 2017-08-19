import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int res = 0;
            for (int i=1; i<=k; i++){
                res += function(1,n,k,i);
                res %= 1000000007;
            }
            System.out.println(res);
        }

    }
    public static int function(int lenth, int n, int k, int previous){
        if (lenth == n){
            return 1;
        }
        int sum = 0;
        for (int i=1; i<=k; i++){
            if (previous<=i || previous%i !=0){
                sum += function(lenth+1,n,k,i);
                sum %= 1000000007;
            }
        }
        return sum;
    }
}