package Huawei2016Autumn_1p9_3;

import java.util.*;

/**
 * Created by sirius on 2017/7/16.
 */
public class Main2_0 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        Map<MyFile,Integer> map=new HashMap();
        Set<MyFile> f_set=new TreeSet<>(new Comparator<MyFile>() {
            @Override
            public int compare(MyFile o1, MyFile o2) {
                if (o1.count!=o2.count) return o2.count-o1.count;
                return o1.row_num-o2.row_num;
            }
        });
        while(sc.hasNext()){
            String line=sc.nextLine();
            MyFile mf=new MyFile(line,count++);
            if (map.size()<8){
                if (!map.keySet().contains(mf)){
                    map.put(mf,0);
                }
                map.put(mf,map.get(mf)+1);
            }
        }
        for (Map.Entry<MyFile,Integer> entry:map.entrySet()){
            entry.getKey().count=entry.getValue();
            f_set.add(entry.getKey());
        }
        for (MyFile mf:f_set){
            System.out.println(mf.getFileName()+" "+mf.row_num+" "+mf.count);
        }
    }
}
class MyFile {
    private String fileName;
    int row_num;
    private int idx;
    int count;
    public MyFile(String line,int idx) {
        String[] sl=line.split(" ");
        this.row_num=Integer.parseInt(sl[1]);
        this.count=0;
        String[] path=sl[0].split("\\\\");
        this.fileName=path[path.length-1];

        this.idx=idx;
    }

    public String getFileName() {
        if (fileName.length()>16){
            return fileName.substring(fileName.length()-16);
        }else{
            return fileName;
        }
    }



    @Override
    public boolean equals(Object o){
        if (!(o instanceof MyFile)) return false;
        return ((MyFile) o).fileName.equals(this.fileName) && ((MyFile)o).row_num==this.row_num;
    }

}