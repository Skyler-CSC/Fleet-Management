import java.io.Serializable;

/**
 * Represents a single boat in the clubs fleet.
 * Stores all information needed for the project.
 */

public class Boat implements Serializable {

    private BoatType type;
    private String name;
    private int year;
    private String makeModel;
    private int lengthFeet;
    private double purchasePrice;
    private double expenses;

    /**
     * Creates a new Boat with no expenses yet
     */

    public Boat (BoatType type, String name, int year, String makeModel, int lengthFeet, double purchasePrice) {

        this.type = type;
        this.name = name;
        this.year = year;
        this.makeModel = makeModel;
        this.lengthFeet = lengthFeet;
        this.purchasePrice = purchasePrice;
        this.expenses = 0.0;

    }// End of constructor

        /**
         * Creates a Boat from a CSV line
         * Format: TYPE, Name, Yeae, MakeModel, Length, Price
         */
        public static Boat fromCsv(String line) {
            String[] parts = line.split(",");

            BoatType type = BoatType.valueOf(parts[0].trim().toUpperCase());
            String name = parts[1].trim();
            int year = Integer.parseInt(parts[2].trim());
            String make = parts[3].trim();
            int len = Integer.parseInt(parts[4].trim());
            double price = Double.parseDouble(parts[5].trim());

            return new Boat(type, name, year, make, len, price);
        }// End of from CSV

    // Getters
    public BoatType getType() { return type; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public String getMakeModel() { return makeModel; }
    public int getLengthFeet() { return lengthFeet; }
    public double getPurchasePrice() { return purchasePrice; }
    public double getExpenses() { return expenses; }

    /**
     * Adds money to this boats expenses.
     */

    public void addExpense(double amount){
        expenses = expenses + amount;
    }// End of addExpenses

    /** Returns how much money can still be spent
     */
    public double remainingBudget() {
        return purchasePrice - expenses;
    }

    public String toString(){
        return String.format(
                "    %-7s %-20s %4d %-10s %3d' : Paid $ %9.2f : Spent $ %9.2f",
                type, name, year, makeModel, lengthFeet, purchasePrice, expenses );
    }//End of string
}// End of class
