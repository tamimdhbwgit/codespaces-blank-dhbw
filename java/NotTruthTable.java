public class NotTruthTable {
    public static void main(String[] args) {
        System.out.println("p\t\tNOT p");

        boolean[] values = {false, true};

        for (boolean p : values) {
            boolean result = !p;
            System.out.println(p + "\t" + result);
        }
    }
}
