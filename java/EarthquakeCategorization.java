import java.util.Scanner;

public class EarthquakeCategorization {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter earthquake magnitude: ");
        double mag = in.nextDouble();

        // Bucket: 0 for <2, 2 for [2,4), 4 for [4,5), 5 for [5,6), 6 for [6,7), 7 for [7,8), 8 for >=8
        int bucket;
        if (mag < 2.0)       bucket = 0;
        else if (mag < 4.0)  bucket = 2;
        else if (mag < 5.0)  bucket = 4;
        else if (mag < 6.0)  bucket = 5;
        else if (mag < 7.0)  bucket = 6;
        else if (mag < 8.0)  bucket = 7;
        else                 bucket = 8;

        String description;

        switch (bucket) {
            case 0  -> description = "Micro: Magnitude < 2.0 (Detected only by seismographs)";
            case 2  -> description = "Minor: 2.0 ≤ Magnitude < 4.0 (Rarely felt, but recorded)";
            case 4  -> description = "Light: 4.0 ≤ Magnitude < 5.0 (Felt by people, minor damage)";
            case 5  -> description = "Moderate: 5.0 ≤ Magnitude < 6.0 (Can cause damage in populated areas)";
            case 6  -> description = "Strong: 6.0 ≤ Magnitude < 7.0 (Serious damage in areas up to 100 miles)";
            case 7  -> description = "Major: 7.0 ≤ Magnitude < 8.0 (Severe damage over large areas)";
            default -> description = "Great: Magnitude ≥ 8.0 (Massive destruction)";
        }

        System.out.println(description);
    }
}
