
/**
 * Write a description of Percolation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.princeton.cs.algs4.CollisionSystem;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Random;

public class Percolation {
       public boolean[] grid;
       public int numOpen;
       public WeightedQuickUnionUF uf;
       public int max; 
       public int virtExit;
       
       public Percolation(int n) {
           max = n;
           virtExit = n*n+2;
           grid = new boolean[virtExit];
           uf = new WeightedQuickUnionUF(virtExit);
           virtExit--;
           numOpen = 0;
           for (int i = 1; i <= n; i++) { //connect the top row to the virtual source (0)
               uf.union(0, i);
           }
           for (int i = virtExit - (n+1); i < virtExit; i++) { //connect the bottom row to the virtual exit (0)
               uf.union(virtExit, i);
           }
           grid[0]=true;
           grid[virtExit]=true;
       }
       
       public void open(int row, int col)  {
           int curSite = row*col;
           if(!isOpen(row, col)) {
               grid[curSite]=true;
               numOpen++;
               if(row > 1 && isOpen(row-1, col)) { //look up
                   uf.union(curSite, (row-1)*col);
               }
               if(row < max && isOpen(row+1, col)) { //look down
                   uf.union(curSite, (row+1)*col);
               }
               if(col > 1 && isOpen(row, col-1)) { //look left
                   uf.union(row*(col-1), curSite);
               }
               if(col < max && isOpen(row, col+1)) { //look right
                   uf.union(row*(col+1), curSite);
               }
           }
       }
       
       public boolean isOpen(int row, int col) {
           return grid[row*col];
       }
       
       public boolean isFull(int row, int col)  {
           return uf.connected(0, (row*col));
       }
       
       public int numberOfOpenSites() {
           return numOpen;
       }
       
       public boolean percolates() {
           return uf.connected(0, virtExit);
       }
    
       public void tester() {
           Random rand = new Random();
           int n = 5;
           boolean readyToPercolate = true;
           
           while (readyToPercolate) {
               int changeTrack = numOpen;
               int col = rand.nextInt(n) + 1;
               int row = rand.nextInt(n) + 1;
               open(row, col);
               if (changeTrack != numOpen) {
                   if (percolates()) {
                       break;
                   }
                   
               }
               for (int i = 1; i <=n*n; i++) {
               if (grid[i] && !uf.connected(0, i)) {
                   System.out.print(" O ");
               } else if (grid[i] && uf.connected(0, i)) {
                   System.out.print(" 0 ");
               } else {
                   System.out.print(" - ");
               }
               if (i%n==0) {
                   System.out.print("\n");
               }
           }
           
           System.out.println("___________________");
           }
           
           System.out.println(numOpen + " sites were open when it started percolating. This is about " + ((float) numOpen/(n*n)));
           int row = 1;
           int col = 1;
           for (int i = 1; i <=n*n; i++) {
               if (grid[i] && !uf.connected(0, i)) {
                   System.out.print(" O ");
               } else if (grid[i] && uf.connected(0, i)) {
                   System.out.print(" 0 ");
               } else {
                   System.out.print(" - ");
               }
               if (i%n==0) {
                   System.out.print("\n");
               }
           }
       }
    }

