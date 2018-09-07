
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
    int times;
    
    public PercolationStats(int n, int trials) { // perform trials independent experiments on an n-by-n grid
        if (n <= 0) throw new IllegalArgumentException("n value is too low");
        if (trials <= 0) throw new IllegalArgumentException("trials value is too low");
        size = n;
        times = trials;
        results = new double[trials];
        
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            int sitesOpen = 0;
            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                    sitesOpen++;
                }
            }
            results[i] = (double) sitesOpen / (n*n);
        }
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
       int n = Integer.parseInt(args[0]);
       int trials = Integer.parseInt(args[1]);
       
       PercolationStats ps = new PercolationStats(n, trials);
       
       System.out.println("Grid size: " + ps.size + " Trials: " + ps.times);
       System.out.println("mean\t\t\t" + ps.mean());
       System.out.println("stddev\t\t\t" + ps.stddev());
       System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() +"]");
    }
    
}
