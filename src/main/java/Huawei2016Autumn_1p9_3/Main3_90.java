package Huawei2016Autumn_1p9_3;

import java.util.Scanner;

/**
 * Created by sirius on 2017/7/16.
 */
public class Main3_90 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String line=sc.nextLine();
            String [] cards=line.split("-");
            Card c1=new Card(cards[0]);
            Card c2=new Card(cards[1]);
            int res=Card.compare(c1,c2);
            if (res==0){
                System.out.println("ERROR");
            }else if(res>0){
                System.out.println(cards[0]);
            }else{
                System.out.println(cards[1]);
            }
        }
    }
}

class Card{
    int key;
    int card_type;
    public static int compare(Card c1,Card c2){
        if (c1.card_type!=c2.card_type){
            if (c1.card_type==4){
                return 1;
            }
            if (c2.card_type==4){
                return -1;
            }
            return 0;
        }else {
            return c1.key-c2.key;
        }

    }
    //3 4 5 6 7 8 9 10 J Q K A(14) 2(15) joker(16) JOKER(17)
    void setKey(String key){
        if (key.equals("joker")){
            this.key=16;
        }else if (key.equals("JOKER")){
            this.key=17;
        }else if (key.equals("2")){
            this.key=15;
        }else if (key.equals("1")){
            this.key=14;
        } else if (key.charAt(0)>='3' && key.charAt(0)<='9'+1){
            this.key=Integer.parseInt(key);
        }else{
            this.key=key.charAt(0)-'J'+11;
        }
    }
    //TODO 比较key
    public Card(String card){
        String []cc=card.split(" ");
        if (cc.length==1){
            this.card_type=1;

        }else if (cc.length==2){
            if (cc[0].equals("joker")||cc[0].equals("JOKER")){
                this.card_type=4;
            }else{
                this.card_type=2;
            }
        }else if (cc.length==3){
            this.card_type=3;
        }else if (cc.length==4){
            this.card_type=4;
        }else{
            this.card_type=5;
        }
        setKey(cc[0]);
    }
}