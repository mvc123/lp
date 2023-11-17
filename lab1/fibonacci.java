package lab1;
// Used recursion
// class fibonacci{
//     static int n1=0,n2=1,n3;
//     static void print(int count){
//         if(count>0){
//             n3=n1+n2;
//             n1=n2;
//             n2=n3;
//             System.out.print(" "+n3);
//             print(count-1);
//         }
//     }
//     public static void main(String[] args) {
//         int count = 10;
//         System.out.print(n1+" "+n2);
//         print(count-2);
//     }
// }

// Without Recursion
class fibonacci{
    public static void main(String[] args) {
        int n1=0,n2=1,n3,i,count=10;
        System.out.print(n1+" "+n2);
        for(i=2;i<count;i++){
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

}