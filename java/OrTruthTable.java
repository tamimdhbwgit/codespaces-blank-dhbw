public class OrTruthTable {
    public static void main(String[] args) {
        System.out.println("p\tq\tp OR q");

        boolean[] values = {false, true};

        for (boolean p : values) {
            for (boolean q : values) {
                boolean result = p || q;
                System.out.println(p + "\t" + q + "\t" + result);
            }
        }
    }
}