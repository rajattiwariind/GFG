class Solution
{
    public int minStepToReachTarget(int K[], int T[], int N)
    {
        if(K[0]==T[0] && K[1]==T[1]) return 0;
        
        int[][] vis = new int[N][N];
        Queue<Pos> q = new ArrayDeque<>();
        
        int[][] moves = {{1,2},{2,1},{-1,-2},{-2,-1},
                        {-1,2},{1,-2},{2,-1},{-2,1}};
        
        q.add(new Pos(K[0]-1, K[1]-1, 1));
        vis[K[0]-1][K[1]-1] = 1;
        
        while(q.size() > 0) {
            Pos rem = q.remove();
            
            if(rem.x==T[0]-1 && rem.y==T[1]-1) {
                return vis[rem.x][rem.y] - 1;
            }
            
            for(int[] move : moves) {
                int nx = rem.x + move[0];
                int ny = rem.y + move[1];
                
                if(isValid(nx,ny,N) && vis[nx][ny]==0) {
                    q.add(new Pos(nx,ny,rem.level + 1));
                    vis[nx][ny] = rem.level + 1;
                }
            }
            
        }
        
        return -1;
        
    }
    
    boolean isValid(int i, int j, int N) {
        if(i<0 || j<0 || i>=N || j>=N) return false;
        
        return true;
    } 
    
    class Pos {
        int x;
        int y;
        int level;
        
        Pos(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}
