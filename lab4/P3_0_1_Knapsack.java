
/*
 *    Theory -> https://www.youtube.com/watch?v=GqOmJHQZivw&ab_channel=takeUforward
 *    Code -> https://takeuforward.org/data-structure/0-1-knapsack-dp-19/
 * 
 *    Time Complexity: O(N*W)
 *    Space Complexity: O(W)
 */


// class P3_0_1_Knapsack {
//     // Function to solve the 0/1 Knapsack problem using dynamic programming
//     static int knapsack(int[] wt, int[] val, int n, int W) {
//         // Create an array to store the maximum value for each capacity (previous row)
//         int prev[] = new int[W + 1];

//         // Base Condition: Initialize the first row of the array
//         for (int i = wt[0]; i <= W; i++) {
//             prev[i] = val[0];
//         }

//         // Iterate through each item and capacity
//         for (int ind = 1; ind < n; ind++) {
//             for (int cap = W; cap >= 0; cap--) {
//                 // Calculate the maximum value when the current item is not taken
//                 int notTaken = prev[cap];

//                 // Calculate the maximum value when the current item is taken
//                 int taken = Integer.MIN_VALUE;
//                 if (wt[ind] <= cap) {
//                     taken = val[ind] + prev[cap - wt[ind]];
//                 }

//                 // Update the array with the maximum value for the current capacity
//                 prev[cap] = Math.max(notTaken, taken);
//             }
//         }

//         // The result is stored in the last element of the array
//         return prev[W];
//     }

//     public static void main(String args[]) {
//         int wt[] = {1, 2, 4, 5};
//         int val[] = {5, 4, 8, 6};
//         int W = 5;
//         int n = wt.length;

//         // Calculate and print the maximum value of items the thief can steal
//         System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));
//     }
// }
import java.io.*; 
  
// class P3_0_1_Knapsack{ 
  
//     // A utility function that returns 
//     // maximum of two integers 
//     static int max(int a, int b) { return (a > b) ? a : b; } 
  
//     // Returns the maximum value that can 
//     // be put in a knapsack of capacity W 
//     static int knapSack(int W, int wt[], int val[], int n) 
//     { 
//         int i, w; 
//         int K[][] = new int[n + 1][W + 1]; //2D array
  
//         // Build table K[][] in bottom up manner 
//         for (i = 0; i <= n; i++) { 
//             for (w = 0; w <= W; w++) { 
//                 if (i == 0 || w == 0) 
//                     K[i][w] = 0; 
//                 else if (wt[i - 1] <= w) 
//                     K[i][w] 
//                         = max(val[i - 1] 
//                                   + K[i - 1][w - wt[i - 1]], 
//                               K[i - 1][w]); 
//                 else
//                     K[i][w] = K[i - 1][w]; 
//             } 
//         } 
  
//         return K[n][W]; 
//     } 
  
//     // Driver code 
//     public static void main(String args[]) 
//     { 
//         int profit[] = new int[] { 60, 100, 120 }; 
//         int weight[] = new int[] { 10, 20, 30 }; 
//         int W = 50; 
//         int n = profit.length; 
//         System.out.println(knapSack(W, weight, profit, n)); 
//     } 
// } 
class P3_0_1_Knapsack{
static int max(int a,int b){
    return (a>b)? a: b;
}
static int knapsack(int W,int wt[],int val[],int n){
    int i,w;
    int K[][] = new int[n+1][W+1];
    for(i=0;i<=n;i++){
        for(w=0;w<=W;w++){
            if(i==0 || w==0)
                K[i][w]=0;
            
            else if(wt[i-1]<=w)
                K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]],K[i-1][w]);
            
            else
                K[i][w]=K[i-1][w];
            
            }

        }
        return K[n][W];
    }
    public static void main(String args[]){
        int profit[] = new int[] {60,100,120};
        int weight[] = new int[] {10,20,30};
        int n =profit.length;
        int W = 50;
        System.out.println(knapsack(W, weight, profit, n));
    }
}


