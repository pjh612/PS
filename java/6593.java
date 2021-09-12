    import java.io.*;

    import java.util.*;


    public class Main {

        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static int [][][]visit ;
        static int [][]dir = {{1,0,0},{0,1,0},{-1,0,0},{0,-1,0},{0,0,-1},{0,0,1}};
        static int l,r,c;
        static int sx,sy,sz;
        public static void main(String[] args) throws IOException {
            while(true)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                l = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                visit = new int[l][r][c];
                for(int i=0;i<l;i++)
                {
                    for(int j=0;j<r;j++)
                    {
                        for(int k=0;k<c;k++)
                            visit[i][j][k] = -1;
                    }
                }
                if(l==0 && r == 0 && c ==0 ) {
                    break;
                }
                char [][][] arr= new char[l][r][c];
                for (int i=0;i<l;i++)
                {
                    for(int j=0;j<r;j++)
                    {
                        arr[i][j] = br.readLine().toCharArray();
                        for(int k=0;k<c;k++)
                        {
                            if(arr[i][j][k] == 'S') {
                                sz = i;
                                sy = j;
                                sx = k;

                            }
                        }
                    }
                    br.readLine();
                }

                Queue<POS> q = new LinkedList<>();
                q.add(new POS(sx,sy,sz));
                visit[sz][sy][sx] = 0;
                boolean flag =false ;
                while(!q.isEmpty())
                {
                    int x = q.peek().x;
                    int y = q.peek().y;
                    int z= q.peek().z;
                    q.poll();
                    if(arr[z][y][x] == 'E')
                    {
                        System.out.println("Escaped in "+visit[z][y][x]+" minute(s).");
                        flag= true;
                        break;
                    }
                    for(int j=0;j<6;j++)
                    {
                        int nx = x+dir[j][0];
                        int ny = y+dir[j][1];
                        int nz = z+dir[j][2];
                        if(nx < 0 || ny <0 || nz <0 || nx >= c || ny >=r ||nz>=l || visit[nz][ny][nx] != -1 || arr[nz][ny][nx] == '#')
                            continue;

                        visit[nz][ny][nx] = visit[z][y][x] + 1;
                      
                        q.add(new POS(nx, ny, nz));
                    }
                }
                if(!flag)
                    System.out.println("Trapped!");

            }
        }

        private static class POS {
            int x, y, z;

            public POS(int x, int y, int z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }
    }