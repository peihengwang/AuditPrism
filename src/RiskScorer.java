import java.util.ArrayList;
public class RiskScorer {
	public static void calculateScores(
            ArrayList<Transaction> transactions) {

        // Step 1: Reset all risk scores
        for (Transaction t : transactions) {
            t.setRiskScore(0);
        }

        // Step 2: Calculate risk score for each transaction
        for (int i = 0; i < transactions.size(); i++) {
        	 Transaction t1 = transactions.get(i);
             boolean invoiceRisk = false;
             boolean detailsRisk = false;
             boolean idRisk = false;             
             // Compare t1 with all other transactions
            for (int j = 0; j < transactions.size(); j++) {
            	 if (i == j) {
                     continue;
                 }
            	Transaction t2 = transactions.get(j);
                if (DuplicateDetector.sameInvoice(t1, t2)) {
                	invoiceRisk = true;
                }
                if (DuplicateDetector.sameDetails(t1, t2)) {
                	detailsRisk = true;
                }
                if (DuplicateDetector.sameId(t1, t2)) {
                	idRisk = true;
                }
                // Step 3: Add points once for each rule
                int score = 0;
                if (invoiceRisk) {
                    score += 40;
                }
                if (detailsRisk) {
                    score += 30;
                }
                if (idRisk) {
                    score += 20;
                }
                if (t1.getAmount() > 5000) {
                    score += 10;
                }
                t1.setRiskScore(score);
            }
        }
    }
	
	public static String getRiskLevel(Transaction t) {

	    int score = t.getRiskScore();

	    if (score >= 60) {
	        return "HIGH";
	    } else if (score >= 30) {
	        return "MEDIUM";
	    } else {
	        return "LOW";
	    }
	}
}
