import java.util.Scanner;

public class Tracker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your buying price per share: ");
        double buyingPrice = input.nextDouble();

        double[] weeklyEarnings = new double[7];

        for (int i = 0; i < weeklyEarnings.length; i++) {
            System.out.printf("Enter the closing price for day %d: ", i + 1);
            double closingPrice = input.nextDouble();
            double earnings = closingPrice - buyingPrice;
            weeklyEarnings[i] = earnings;
        }

        input.close();

        System.out.println("\nEarnings summary:");
        for (int i = 0; i < weeklyEarnings.length; i++) {
            System.out.printf("Day %d: %s $%.2f per share%n", i + 1,
                    (weeklyEarnings[i] >= 0 ? "Gain" : "Loss"),
                    Math.abs(weeklyEarnings[i]));
        }

        double lastDayEarnings = weeklyEarnings[weeklyEarnings.length - 1];
        System.out.println();
        if (lastDayEarnings > 0) {
            System.out.printf("After day %d, you have gained $%.2f per share since yesterday.%n",
                    weeklyEarnings.length, lastDayEarnings);
        } else if (lastDayEarnings < 0) {
            System.out.printf("After day %d, you have lost $%.2f per share since yesterday.%n",
                    weeklyEarnings.length, Math.abs(lastDayEarnings));
        } else {
            System.out.printf("After day %d, you have no earnings per share since yesterday.%n",
                    weeklyEarnings.length);
        }
    }
}
