
/**
 * Write a description of PercolationStats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    double[] results;
    int size;
    
    public PercolationStats(int n, int trials) { // perform trials independent experiments on an n-by-n grid
        if (n <= 0) throw new IllegalArgumentException("n value is too low");
        if (trials <= 0) throw new IllegalArgumentException("trials value is too low");
        size = n;      
    }
   
    public double mean() { // sample mean of percolation threshold
        return StdStats.mean(results);
    }
   
    public double stddev() { // sample standard deviation of percolation threshold
        return StdStats.stddev(results);
    }
   
    public double confidenceLo() { // low  endpoint of 95% confidence interval
        return mean() - 1.96 * (stddev()/Math.sqrt(size));
    }
   
    public double confidenceHi() { // high endpoint of 95% confidence interval
        return mean() + 1.96 * (stddev()/Math.sqrt(size));
    }

   public static void main(String[] args) { // test client (described below)
    
    }
    
}
