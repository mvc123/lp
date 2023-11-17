package lab3;
// Code from manual written:
// public class fractionalknapsack {
//     public static void main(String[] args) {
//         int MaxWeight = 10;
//         int[] weight = {3,3,2,5,1};
//         int[] profit = {10,15,10,12,8};
//         int pw[] = new int [weight.length];
//         for(int i=0;i<weight.length;i++){
//             pw[i] = profit[i]/weight[i];
//         }
//         for(int i=0;i<pw.length-1;i++){
//             for(int j=i+1;j<pw.length;j++){
//                 if(pw[i]>pw[j]){
//                     int temp1 = pw[i];
//                     pw[i] = pw[j];
//                     pw[j]=temp1;
//                     int temp2 = weight[i];
//                     weight[i]=weight[j];
//                     weight[j]=temp2;
//                     int temp3 = profit[i];
//                     profit[i]=profit[j];
//                     profit[j]=temp3;                    
//                 }
//             }
            
//         }
//         int weight_sum=0;
//         int profitSum=0;
//         for(int i=pw.length-1;i>=0;i--){
//             if(weight_sum + weight[i]==MaxWeight){
//                 break;
//             }
//             else if(weight_sum+weight[i]>=MaxWeight){
//                 int req=MaxWeight-weight_sum;
//                 int div = req/weight[i];
//                 profitSum = div*profit[i];
//                 break;
//             }
//             System.out.println("Max Profit: "+ profitSum);
//         }
//     }

// }

// Code from Web:
// public class fractionalknapsack{
//    static int n = 5;
//    static int p[] = {3, 3, 2, 5, 1};
//    static int w[] = {10, 15, 10, 12, 8};
//    static int W = 10;
//    public static void main(String args[]) {
//       int cur_w;
//       float tot_v = 0;
//       int i, maxi;
//       int used[] = new int[10];
//       for (i = 0; i < n; ++i)
//          used[i] = 0;
//       cur_w = W;
//       while (cur_w > 0) {
//          maxi = -1;
//          for (i = 0; i < n; ++i)
//             if ((used[i] == 0) &&
//                   ((maxi == -1) || ((float)w[i]/p[i] > (float)w[maxi]/p[maxi])))
//                maxi = i;
//          used[maxi] = 1;
//          cur_w -= p[maxi];
//          tot_v += w[maxi];
//          if (cur_w >= 0)
//             System.out.println("Added object " + maxi + 1 + " (" + w[maxi] + "," + p[maxi] + ") completely in the bag. Space left: " + cur_w);
//          else {
//             System.out.println("Added " + ((int)((1 + (float)cur_w/p[maxi]) * 100)) + "% (" + w[maxi] + "," + p[maxi] + ") of object " + (maxi + 1) + " in the bag.");
//             tot_v -= w[maxi];
//             tot_v += (1 + (float)cur_w/p[maxi]) * w[maxi];
//          }
//       }
//       System.out.println("Filled the bag with objects worth " + tot_v);
//    }
// }
// chatgpt enhanced code
// public class fractionalknapsack {
//     static int n = 5;
//     static int[] p = {3, 3, 2, 5, 1};
//     static int[] w = {10, 15, 10, 12, 8};
//     static int W = 10;

//     public static void main(String[] args) {
//         int cur_w = W;
//         float tot_v = 0;
//         int[] used = new int[n];

//         for (int i = 0; i < n; ++i)
//             used[i] = 0;

//         while (cur_w > 0) {
//             int maxi = -1;

//             // Find the item with the maximum value-to-weight ratio
//             for (int i = 0; i < n; ++i) {
//                 if (used[i] == 0 &&
//                         (maxi == -1 || ((float) w[i] / p[i] > (float) w[maxi] / p[maxi])))
//                     maxi = i;
//             }

//             used[maxi] = 1;
//             cur_w -= p[maxi];
//             tot_v += w[maxi];

//             if (cur_w >= 0) {
//                 System.out.println("Added object " + (maxi + 1) + " (" + w[maxi] + "," + p[maxi] +
//                         ") completely in the bag. Space left: " + cur_w);
//             } else {
//                 // Add a fraction of the item to fill the remaining space
//                 float fraction = 1 + (float) cur_w / p[maxi];
//                 System.out.println("Added " + ((int) (fraction * 100)) + "% (" + w[maxi] + "," + p[maxi] +
//                         ") of object " + (maxi + 1) + " in the bag.");
//                 tot_v -= w[maxi];
//                 tot_v += fraction * w[maxi];
//             }
//         }
//         System.out.println("Filled the bag with objects worth " + tot_v);
//     }
// }



//code enhanced by chatgpt from manual
public class fractionalknapsack {
    public static void main(String[] args) {
        int maxWeight = 10;
        int[] weight = {3, 3, 2, 5, 1};
        int[] profit = {10, 15, 10, 12, 8};
        float[] pw = new float[weight.length]; // Use float for the ratio

        // Calculate profit-to-weight ratio
        for (int i = 0; i < weight.length; i++) {
            pw[i] = (float) profit[i] / weight[i];
        }

        // Sort arrays based on the profit-to-weight ratio
        for (int i = 0; i < pw.length - 1; i++) {
            for (int j = i + 1; j < pw.length; j++) {
                if (pw[i] > pw[j]) {
                    // Swap ratios, weights, and profits
                    float temp1 = pw[i];
                    pw[i] = pw[j];
                    pw[j] = temp1;

                    int temp2 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp2;

                    int temp3 = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp3;
                }
            }
        }

        int weightSum = 0;
        int profitSum = 0;

        // Fill the knapsack
        for (int i = pw.length - 1; i >= 0; i--) {
            if (weightSum + weight[i] <= maxWeight) {
                weightSum += weight[i];
                profitSum += profit[i];
            } else {
                // Calculate profit for the remaining fraction
                int remainingWeight = maxWeight - weightSum;
                float fraction = (float) remainingWeight / weight[i];
                profitSum += (int) (fraction * profit[i]);
                break;
            }
        }

        System.out.println("Max Profit: " + profitSum);
    }
}