
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AuditApp {
	 public static void main(String[] args) throws FileNotFoundException {

	        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	        Scanner input = new Scanner(new File("data/transactions.csv"));

	        // Skip the header
	        if (input.hasNextLine()) {
	            input.nextLine();
	        }

	        // Read transactions
	        while (input.hasNextLine()) {

	            String line = input.nextLine();
	            String[] fields = line.split(",");

	            String id = fields[0];
	            String vendor = fields[1];
	            double amount = Double.parseDouble(fields[2]);
	            String date = fields[3];
	            String invoiceNumber = fields[4];

	            Transaction t = new Transaction(id, vendor, amount, date, invoiceNumber);

	            transactions.add(t);
	        }

	        input.close();

	        // Print transactions
	        System.out.println("===== AuditPrism =====");

	        for (Transaction t : transactions) {
	            System.out.println(t);
	        }

	        // Calculate summary statistics
	        double total = 0;
	        double max = 0;
	        double ave = 0;
	        int count = 0;
	        double amount = 5000.00;

	        for (Transaction t : transactions) {

	            total += t.getAmount();

	            if (t.getAmount() > max) {
	                max = t.getAmount();
	            }
	            
	            if (t.getAmount() > amount) {
	            	count++;
	            }
	            
	            ave = total / transactions.size();;
	        }

	        System.out.println();
	        System.out.println("=== Audit Summary ===");
	        System.out.println("Transactions: " + transactions.size());
	        System.out.println("Total Amount: $" + total);
	        System.out.println("Largest Transaction: $" + max);
	        System.out.println("Average Transaction: $" + ave);
	        System.out.println("Above $5000 Transaction: "+ count);
	  }

}
