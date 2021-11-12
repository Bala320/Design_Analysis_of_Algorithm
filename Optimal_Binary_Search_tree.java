import java.util.*;

public class Main
{
    static int sum(int freq[], int left_idx, int right_idx)
    {
        int sum = 0;
        for (int i=left_idx; i <= right_idx; ++i)
        {
            sum += freq[i];
        }
        return sum;
    }
    static int Min_Total_Cost(int freq[], int i, int j)
    {
        if (i > j) 
            return 0;
        
        int min_total_cost = Integer.MAX_VALUE;
        
        for (int k = i; k <= j; ++k)
        {
            int total_cost = ( Min_Total_Cost(freq, i, k-1) 
                             + Min_Total_Cost(freq, k+1, j)
                             + sum(freq, i, j));
            
            if (total_cost < min_total_cost)
                min_total_cost = total_cost;
        
        }
        return min_total_cost;
        
    }
    static int getTotalCostOfOptimalBST(int keys[], int freq[], int num_keys)
    {
        return Min_Total_Cost(freq, 0, num_keys-1);
    }
    public static void main (String[] args) 
    {
        int keys[] = {0, 1, 2};
        int freq[] = {34, 8, 50};
        int n = keys.length;
    
        System.out.println("Total cost of Optimal BST:" + 
                            getTotalCostOfOptimalBST(keys, freq, n));
    }
}
