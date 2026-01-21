public class star_problem{
    public static void main(String[] args) {
    //to make a increasing
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        System.out.println("............... ");
        //to make a decreasing 
        for (int i = 1; i<6; i++){
            for (int j = i; j<6; j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        //to make a tree 
        for (int i = 1; i<6; i++){
            for (int j = i; j<6; j++){
                System.out.print(" ");
            }
            for (int j = 1; j<= i; j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        //to make a pattern like diamond
        int n = 6;
        for (int i = 0; i<=n; i++){
           for (int j = i; j<6; j++){
                System.out.print(" ");
            }
            for(int j =0; j<=i; j++){
              System.out.print("* ");  
            }
            System.out.println();
        }
        for (int i = n; i>=0; i--){
           for (int j = n; j>i; j--){
                System.out.print(" ");
            }
            for(int k =0; k<=i; k++){
              System.out.print("* ");  
            }
            System.out.println();
        }


    }
}