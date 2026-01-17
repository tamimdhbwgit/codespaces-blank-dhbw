public class for_loop{
    public static void main(String[] args) {
        
        System.out.println("x x x*");
        System.out.print("no newline:::");
        System.out.println("but this is followed by a newline");
        
        for (int i = 0; i < 4; i++) {
            System.out.println(i + "-:-");
        }
        
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
        }
    }
}