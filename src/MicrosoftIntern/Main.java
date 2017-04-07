package MicrosoftIntern;



import java.text.Format;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by sirius on 17-3-31.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            int p=sc.nextInt();//initial prob
            int q=sc.nextInt();//add prob interval
            int n=sc.nextInt();//n items
            Queue<TreeNode> queue=new LinkedList<>();
            TreeNode root=new TreeNode(p,0,0,1);
            queue.add(root);
            long base=2;//reset to ⌊P/(2I)⌋%
            double res=0;
            while(!queue.isEmpty()){
                TreeNode node=queue.poll();
                if(node.items<n){
                    base=(long)Math.pow(2,node.items+1);
                    if(node.prob>0){
                        //get  an item
                        queue.add(new TreeNode((int)Math.floor(node.prob/base),node.items+1,node.height+1,node.prob*node.nowProb/100));

                    }
                    //not get an item
                    if(node.prob<100){
                        TreeNode right=null;
                        if(node.prob<=100-q){
                            right=new TreeNode(node.prob+q,node.items,node.height+1,(100-node.prob)*node.nowProb/100);
                        }else{
                            right=new TreeNode(100,node.items,node.height+1,(100-node.prob)*node.nowProb/100);
                        }
                        queue.add(right);
                    }

                }else{
                    res+=node.nowProb*node.height;
                }
            }

            System.out.println(String.format("%.2f",res));
        }
    }
}
class TreeNode{
    int prob;
    int items;
    int height;
    double nowProb;
    public TreeNode(int prob,int items,int height,double nowProb){
        this.prob=prob;
        this.items=items;
        this.height=height;
        this.nowProb=nowProb;
    }
}