
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
       public int[] grid;
       public int numOpen;
       public int closedValue;
       
       public Percolation(int n) {
           closedValue = n * n + 1; //this value signifies that a site hasn't been opened yet
           grid = new int[n*n];
           for (int i = 0; i < n; i++) {
               grid[i] = i +1;
            }
           }
       }
       
       public void open(int row, int col)  {
           //check isOpen, if not, set to row*col, then check if surrounding
           // are open. handle exception. if open, connect
       }
       
       public boolean isOpen(int row, int col) {
           return grid[row][col] != closedValue;
       }
       
       public boolean isFull(int row, int col)  {
           for (int i = 0; i < grid.length; i++) {
               if (connected(grid[row][col], grid[0][i])) {
                   return true;
               }
           }
           return false;
       }
       
       public int numberOfOpenSites() {
           return numOpen;
       }
       public boolean percolates() {
           //double loop to check if bottom row is connected to top row
       }
    
       public static void main(String[] args) {
       
       }
}
