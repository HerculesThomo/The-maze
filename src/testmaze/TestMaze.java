package testmaze;
import java.io.*;
public class TestMaze {
    public static void main(String[] args) throws Exception{
        BufferedReader br=null;
        try
        {
          FileReader file=new FileReader("C:\\Users\\herth\\OneDrive\\Έγγραφα\\maze.txt");
          br=new BufferedReader(file);
          String line=br.readLine();
          String []a=line.split("");
          int n=Integer.parseInt(a[0]);
          int m=Integer.parseInt(a[1]);
          char [][]maze=new char[n][m];
          for(int i=0;i<n;i++){
              line=br.readLine();
              for(int j=0;j<m;j++){
                  maze[i][j]=line.charAt(j);
                  System.out.print(maze[i][j]);}
              System.out.println();
          }
          Maze Array=new Maze(maze);
          int [] value=Array.getStartingPoint();
          Array.initializeEndingPoint();
          if(Array.solve(value[0],value[1])){
                  System.out.println("The maze starts from position:"+value[0]+","+value[1]);
                  System.out.println("The maze solved!!");
                  Array.printMaze();}
              else{
                  System.out.println("There is no valid path");}   
          }
        catch(FileNotFoundException fnot){
            System.out.println("THe file does not exist..");}
        catch(StringIndexOutOfBoundsException Sb){
            System.out.println("String index  out of range!!");}
        catch(NumberFormatException e){
            System.out.println("You can not convert a string into a number!!!");}
        catch(IOException iox){
            System.out.println("We can not read the file.");
        }
        catch(Exception ex){
            System.out.println("An a Exception has been made.");
        }
        finally{
            if (br != null) {
                br.close();}  
        }
    }
}
