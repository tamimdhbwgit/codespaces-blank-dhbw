public class practice {
    public static void main(String[] args) {
        for (int i=0; i<2; i++){
            for (int j = 0; j<5; j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        System.out.println("..................... ");
        for (int i=0; i<=5; i++){
            for (int k = 0; k<=5-i-1; k++){
                System.out.print(" ");
            }
            for (int j = 0; j<=i*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int l = 0; l<=2; l++){
           for (int k = 0; k<=3; k++){
                System.out.print(" ");
            }
              System.out.print("***");
              System.out.println();
        }
        for (int i=5; i>=0; i--){
            for (int k = 0; k<=5-i-1; k++){
                System.out.print(" ");
            }
            for (int j = 0; j<=i*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=5; i>=0; i--){
            for (int j = 0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}