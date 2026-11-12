
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
	            // Skip empty lines
	            if (line.trim().isEmpty()) {
	                continue;
	            }
	            String[] fields = line.split(",");
	            // Skip incomplete records
	            if (fields.length != 5) {
	                System.out.println("Skipping invalid record: " + line);
	                continue;
	            }

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
	        System.out.printf("Total Amount: $%.2f%n", total);
	        System.out.printf("Largest Transaction: $%.2f%n", max);
	        System.out.printf("Average Transaction: $%.2f%n", ave);
	        System.out.println("Above $5000 Transaction: "+ count);
	        // V0.2
	        System.out.println();
	        DuplicateDetector.detect(transactions);
	        
	        // v0.3: Calculate audit risk scores
	        RiskScorer.calculateScores(transactions);
	        // Create a copy to preserve original transaction order
	        ArrayList<Transaction> sortedTransactions =
	                new ArrayList<Transaction>(transactions);

	        // Sort by risk score (descending)
	        sortedTransactions.sort(new RiskComparator());
	        
	        System.out.println();
	        System.out.println("=== Audit Risk Reports ===");
	        System.out.printf(
	        	    "%-10s %-22s %12s %8s %10s%n",
	        	    "ID", "Vendor", "Amount", "Score", "Risk"
	        	);
	        
	        for (Transaction t : sortedTransactions) {
	            // Print transaction information
	        	 String level = RiskScorer.getRiskLevel(t);

	        	    System.out.printf(
	        	        "%-10s %-22s $%11.2f %8d %10s%n",
	        	        t.getId(),
	        	        t.getVendor(),
	        	        t.getAmount(),
	        	        t.getRiskScore(),
	        	        level
	        	    );
	        }
	     
	     // v0.3: Risk summary
	        int highCount = 0;
	        int mediumCount = 0;
	        int lowCount = 0;

	        for (Transaction t : transactions) {

	            String level = RiskScorer.getRiskLevel(t);

	            if (level.equals("HIGH")) {
	                highCount++;
	            } else if (level.equals("MEDIUM")) {
	                mediumCount++;
	            } else {
	                lowCount++;
	            }
	        }

	        System.out.println();
	        System.out.println("=== Audit Risk Summary ===");

	        System.out.println("Total Transactions: "
	                           + transactions.size());

	        System.out.println("High Risk: " + highCount);
	        System.out.println("Medium Risk: " + mediumCount);
	        System.out.println("Low Risk: " + lowCount);
	  }

}
