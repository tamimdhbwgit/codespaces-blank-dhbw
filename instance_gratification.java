/**
 * InstanceGratification.java
 *
 * When an instance of this class is created it "gratifies" by printing
 * a greeting to stdout.
 */
public class instance_gratification {

    // Constructor prints the greeting when a new instance is created
    public instance_gratification() {
        System.out.println("Hello everyone!");
    }

    // Optional instance method that also prints the greeting
    public void greet() {
        System.out.println("Hello everyone!");
    }

    // Example usage: create an instance (which prints the greeting),
    // and call the instance method.
    public static void main(String[] args) {
        // Creating an instance — the constructor prints "Hello everyone!"
        instance_gratification ig = new instance_gratification();

        // Calling an instance method that prints the same greeting again
        ig.greet();
    }
}