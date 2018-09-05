
/**
 * Write a description of Percolation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Percolation {
    
       public Percolation(int n) {
           //make an int[][] with all values set to n*n+1 (make a class field for this value)
       }
       public void open(int row, int col)  {
           //check isOpen, if not, set to row*col, then check if surrounding
           // are open. handle exception. if open, connect
       }
       public boolean isOpen(int row, int col) {
           //reuturn the opposite of grid[][] == n*n + 1
       }
       public boolean isFull(int row, int col)  {
           //not really used, maybe do a loop to see if site is connected to top row?
       }
       public int numberOfOpenSites() {
           //make a class field to keep track of this
       }
       public boolean percolates() {
           //double loop to check if bottom row is connected to top row
       }
    
       public static void main(String[] args) {
       
       }
}
