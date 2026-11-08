import java.util.ArrayList;

public class DuplicateDetector {
	
	// Rule 1: Same vendor & invoice number & amount (Strong Match)
	
	public static boolean sameInvoice(Transaction t1, Transaction t2) {
		
		return t1.getVendor().equalsIgnoreCase(t2.getVendor())
				&& t1.getInvoiceNumber().equalsIgnoreCase(t2.getInvoiceNumber())
				&& t1.getAmount() == t2.getAmount();		
	}
	
	// Rule 2: Same vendor & amount & date (Possible duplicate payment)
	
	public static boolean sameDetails(Transaction t1, Transaction t2) {
		
		return t1.getVendor().equalsIgnoreCase(t2.getVendor())
				&& t1.getAmount() == t2.getAmount()
				&& t1.getDate().equalsIgnoreCase(t2.getDate());
		
	}
	
	// Rule 3: Same transaction ID
	public static boolean sameId(Transaction t1, Transaction t2) {

	    return t1.getId().equalsIgnoreCase(t2.getId());
	}
	
	// Detect and Output potential duplicate transactions
	
	public static void detect(ArrayList<Transaction> transactions) {
		
		System.out.println("=== Potential Duplicate Pairs ===");
		
		int count =0;
		for(int i=0; i<transactions.size(); i++) {
			for(int j=i+1; j<transactions.size(); j++) {
				
				Transaction t1 = transactions.get(i);
				Transaction t2 = transactions.get(j);
				
				if(sameInvoice(t1,t2) || sameDetails(t1,t2) || sameId(t1, t2)) {
					count++;
					System.out.println();
					System.out.println("Potential Duplicate Pair "+ count);
					System.out.println(t1);
					System.out.println(t2);
					if (sameInvoice(t1, t2)) {
					    System.out.println("Flag: Matching invoice");
					}

					if (sameDetails(t1, t2)) {
					    System.out.println("Flag: Matching transaction details");
					}
					if (sameId(t1, t2)) {
					    System.out.println("Flag: Matching ID");
					}
				}
				
			}
		}
		System.out.println();
		System.out.println("Total Potential Duplicate Pairs "+ count);
	}
	

}
