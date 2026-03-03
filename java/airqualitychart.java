import org.jfree.data.category.DefaultCategoryDataset;
//    └─ This tells Java: "Look in the JFreeChart library for this class"
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import javax.swing.*;
import java.util.*;
public class airqualitychart {
    public static void main(String[] args){
     String [] weekdays = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thurs", "Fri"};
     Double [] PM = {1.2, 2.2, 3.2, 4.2, 5.2, 6.2, 7.2};
     // This is just an example:
     ArrayList<String> days = new ArrayList<>();
     days.add("Saturday");
     days.add("Sunday");
     days.add("Monday");
     days.add("Tuesday");
     days.add("Wednesday");
     days.add("Thursday");
     days.add("Friday");
     DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
     
    }
}
