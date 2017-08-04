package Huawei2018Youzhao;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by sirius on 2017/6/28.
 */
public class Main3 {
    Pattern searchp=Pattern.compile("\\(search (.+) (.+)\\)");
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String cmd=sc.nextLine();
            StringBuffer str_s=new StringBuffer();
            int num_kuoha=0;
            for (char c :cmd.toCharArray()){
                if(c==' '){
                    if (num_kuoha%2==0||num_kuoha==0){
                        str_s.append(c);
                    }else{
                        str_s.append("^");
                    }
                }else{
                    str_s.append(c);
                }
                if (c=='"'){
                    num_kuoha++;
                }
            }
            System.out.println(process(str_s.toString()).replaceAll("\\^"," "));
        }
//        (search (search "acdsf" "dsf") "d")
    }
    public static String process(String cmd){
        String []t=cmd.split(" ");
        String command=t[0].substring(1);
        switch (command){
            case "quote":{//(quote "!@#$%")
                if (t[1].startsWith("\"")){
                    return "\""+getStr(t[1].substring(0,t[1].length()-1))+"\"";
                }else{
                    StringBuffer sb=new StringBuffer();
                    for (int i=1;i<t.length-1;i++){
                        sb.append(t[i]+" ");
                    }
                    sb.append(t[t.length-1].substring(0,t[t.length-1].length()-1));
                    return process(sb.toString());
                }
                //(quote (search "asdds" "d"))
//(search (search "acdsf" (quote "dsf")) "d")
            }
            case "reverse":{//(reverse "a b c")
                if (t[1].startsWith("\"")){
                    return "\""+reverse(getStr(t[1].substring(0,t[1].length()-1)))+"\"";
                }else{
                    StringBuffer sb=new StringBuffer();
                    for (int i=1;i<t.length-1;i++){
                        sb.append(t[i]+" ");
                    }
                    sb.append(t[t.length-1]);
                    return "\""+reverse(process(sb.toString()))+"\"";
                }
            }
            case "search":{//(search "1234567890" (reverse "dc"))
                String para1=null;
                String para2=null;
                if(t[1].startsWith("\"")){
                    para1=getStr(t[1]);
                    if(t[2].startsWith("\"")){
                        para2=getStr(t[2].substring(0,t[2].length()-1));
                    }else{
                        StringBuffer sb=new StringBuffer();
                        for (int i=1;i<t.length-1;i++){
                            sb.append(t[i]+" ");
                        }
                        sb.append(t[t.length-1].substring(0,t[t.length-1].length()-1));
                        para2=process(sb.toString());
                    }

                }else{
                    para1=process(t[1]+" "+t[2]+" "+t[3]);
                    if(t[4].startsWith("\"")){
                        para2=getStr(t[4].substring(0,t[4].length()-1));
                    }else{
                        StringBuffer sb=new StringBuffer();
                        for (int i=4;i<t.length-1;i++){
                            sb.append(t[i]+" ");
                        }
                        sb.append(getCMD(t[t.length-1]));
                        para2=process(sb.toString());
                    }

                }
                return "\""+search(para1,para2)+"\"";
            }
            case "combine":{
                StringBuffer sb=new StringBuffer();
                StringBuffer tt=new StringBuffer();
                int zuokuohao=0;
                int zuoyinhao=0;
                for (char c:cmd.substring(9,cmd.length()-1).toCharArray()){
                    if(c=='"'){
                        if(zuoyinhao==0){
                            tt.append(c);
                            zuoyinhao=1;
                        }else{
                            sb.append(getStr(tt.toString()+"\""));
                            tt=new StringBuffer();
                        }
                    }else if(c=='('){

                        zuokuohao++;
                        tt.append(c);
                    }else if(c==')'){
                        zuokuohao--;
                        tt.append(c);
                        if(zuokuohao==0){
                            sb.append(getStr(process(tt.toString())));
                            tt=new StringBuffer();
                        }
                    }else if(c==' '){
                        if (zuokuohao!=0){
                            tt.append(c);
                        }
                    }
                    else{
                        tt.append(c);
                    }
                }//(combine "a" "b" (search "abcdef" "cd" ))

                return "\""+sb.toString()+"\"";
            }
        }
        return "error";
    }
    public static String getStr(String str){
        return str.substring(1,str.length()-1);
    }
    public static String getCMD(String cmd){
        return cmd.substring(0,cmd.length()-1);
    }
    public static String reverse(String content){
        return new StringBuffer(content).reverse().toString();
    }
    public static String search(String para1,String para2){
        int idx=para1.indexOf(para2);
        if(idx==-1){
            return "";
        }else{
            return para1.substring(idx);
        }
    }
}
