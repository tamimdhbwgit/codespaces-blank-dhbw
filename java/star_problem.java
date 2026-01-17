public class star_problem{
    public static void main(String[] args) {
    //to make a increasing
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
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
    }
}