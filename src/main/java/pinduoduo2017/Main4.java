package pinduoduo2017;

import java.util.*;

/**
 * Created by sirius on 2017/8/1.
 */
public class Main4 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] maze = new char[n][m];
            int[][] visited = new int[n][m];
            int[][] fa = new int[n][m];       //记录到该节点的上一个节点的坐标
            char[][] last_dir = new char[n][m];
            int[] dx = {-1, 1, 0, 0};            //四个方向
            int[] dy = {0, 0, -1, 1};
            char[] dir = {'U', 'D', 'L', 'R'};
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], '0');
            }

            int src_x = 0,src_y=0; //起点
            int des_x=0,des_y=0; //终点
            HashMap<Character,int[]> doormap= new HashMap();
            HashMap<Character,int[]> keymap=new HashMap();
            for(int i=0;i<n;i++) {
                maze[i] = scanner.next().toCharArray();
                System.out.println(maze[i]);
                for(int j=0;j<m;j++){
                    if(maze[i][j]=='2'){
                        src_x=i;
                        src_y=j;
                }else if(maze[i][j]=='3'){
                        des_x=i;
                        des_y=j;
                    }else if(maze[i][j]>='A' && maze[i][j]<='Z'){
                    doormap.put(maze[i][j], new int[]{i, j});
                    }else if(maze[i][j]>='a' && maze[i][j]<='z'){
                        keymap.put(maze[i][j], new int[]{i,j});
                    }
            }
        }
        //int src_x=scanner.nextInt();    //起点
        //int src_y=scanner.nextInt();
        //int des_x=scanner.nextInt();    //终点
        //int des_y=scanner.nextInt();
        System.out.println(maze);
        if(maze[src_x][src_y]!='1')
            continue;
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(src_x*m+src_y);         //矩阵数组按0,1,2...n*m编号
        fa[src_x][src_y]= (char) (src_x*m+src_y);
        visited[src_x][src_y]=1;
        while(!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / m;
            int y = index % m;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == '1' && visited[nx][ny] == 0) {
                    queue.offer(nx * m + ny);
                    visited[nx][ny] = 1;
                    fa[nx][ny] = (char) index;
                    last_dir[nx][ny] = (char) i;
                }else if(nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] >= 'a'&& maze[nx][ny] <= 'z'&& visited[nx][ny] == 0){
                    queue.offer(nx * m + ny);
                    visited[nx][ny] = 1;
                    fa[nx][ny] = (char) index;
                    last_dir[nx][ny] = (char) i;
                }else if(nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] >= 'A'&& maze[nx][ny] <= 'Z'&& visited[nx][ny] == 0){
                    char door=maze[nx][ny];
                    char key=(char) ((int) door +32);
                    int[] id=keymap.get(key);
                    if(visited[id[0]][id[1]]==1){
                        queue.offer(nx * m + ny);
                        visited[nx][ny] = 1;
                        fa[nx][ny] = (char) index;
                        last_dir[nx][ny] = (char) i;
                    }
                }
            }
        }
        StringBuffer path=new StringBuffer();
        int fx=des_x;
        int fy=des_y;
        int index=des_x*m+des_y;
        while(fa[fx][fy]!=index){
            path.append(dir[last_dir[fx][fy]]);
            int x=fa[fx][fy]/m;
            int y=fa[fx][fy]%m;
            fx=x;
            fy=y;
            index=fx*m+fy;
        }
        System.out.println(path.reverse().toString().length());
    }
        scanner.close();
}

}
