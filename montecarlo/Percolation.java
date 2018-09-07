
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
           if (row <= 0 || row > max) throw new IndexOutOfBoundsException("row index i out of bounds");
           if (col <= 0 || col > max) throw new IndexOutOfBoundsException("col index i out of bounds");
           
           int curSite = xyToIndex(row, col);
           
           if(!isOpen(row, col)) {
               grid[curSite]=true;
               numOpen++;
               if(row > 1 && isOpen(row-1, col)) { //look up
                   uf.union(curSite, xyToIndex((row-1), col));
               }
               if(row < max && isOpen(row+1, col)) { //look down
                   uf.union(curSite, xyToIndex((row+1), col));
               }
               if(col > 1 && isOpen(row, col-1)) { //look left
                   uf.union(xyToIndex(row, (col-1)), curSite);
               }
               if(col < max && isOpen(row, col+1)) { //look right
                   uf.union(xyToIndex(row, (col+1)), curSite);
               }
           }
       }
       
       public boolean isOpen(int row, int col) {
           return grid[xyToIndex(row, col)];
       }
       
       public boolean isFull(int row, int col)  {
           return isOpen(row, col) && uf.connected(0, (xyToIndex(row, col)));
       }
       
       public int numberOfOpenSites() {
           return numOpen;
       }
       
       public boolean percolates() {
           return uf.connected(0, virtExit);
       }
       private int xyToIndex(int row, int col) {
           return (row - 1) * max + col;
        }
}

