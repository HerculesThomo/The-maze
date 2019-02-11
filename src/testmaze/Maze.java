package testmaze;
public class Maze{
   private char[][]grid;
   public Maze(char[][]grid){
       this.grid=grid;
   }
   public boolean initializeStartingPoint(){
       boolean flag=false;
       for (char[] grid1 : grid) {
           for (int j = 0; j<grid[0].length; j++) {
               if (grid1[j] == 'S') {
                   return true;
               }
           }
       }
       if(flag)
        System.out.println("There is no starting point:");
       else
           System.out.println("There is no starting point");
       return flag;
   }
      public boolean initializeEndingPoint(){
       boolean flag=false;
       for (char[] grid1 : grid) {
           for (int j = 0; j<grid[0].length; j++) {
               if (grid1[j] == 'T') {
                   return true;
               }
           }
       }
       if(flag)
        System.out.println("There is Ending point found at position: ");
       else
           System.out.println("There is no Ending point");
       return flag;
   }
   public int [] getStartingPoint(){
       int StartX=0;
       int StartY=0;
       if(initializeStartingPoint()==true){
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]=='S'){
                   StartX=i;
                   StartY=j;}
           }
        }
       }
        return new int[]{StartX,StartY};}
   public boolean solve(int r,int c){
       if(r>=0 && c>=0 && r<grid.length && c<grid[0].length){
           if(grid[r][c]=='T'){
               grid[r][c]='E';
               return true;
           }
           if (grid[r][c]=='*' || grid[r][c]=='S') {
                grid[r][c]='_';
                if(solve(r+1,c))
                    return true;
                if(solve(r,c+1))
                    return true;
                if(solve(r-1,c))
                    return true;
                if(solve(r,c-1))
                    return true;
                grid[r][c]='X';
                    return false;
           }
       }
       return false;
   }
   public void printMaze(){
       for (char[] row : grid){
           for(char col:row){
            System.out.print(col);
           }
           System.out.println();
       }
   }
}
