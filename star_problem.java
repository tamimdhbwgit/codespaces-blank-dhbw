public class star_problem{
    public static void main(String[] args) {
        
        
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "-:-");
        }
        
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}