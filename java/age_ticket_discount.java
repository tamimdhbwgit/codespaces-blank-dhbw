class age_ticket_discount {
    public static void main(String[] args) {
        int age = 33;
        boolean isStudent = true;
        boolean isSenior = age >= 50;

        double price = 20.0;
        double percentageStudent = 0.03;
        double percentageSenior = 0.02;

        if (isSenior) {
            price = price * (1 - percentageSenior);
        } else if (isStudent) {
            if (age < 30) {
                price = price * (1 - percentageStudent);
            }
        } else {
            price = price; // no discount
        }

        System.out.println("Ticket price: " + price);
    }
}
