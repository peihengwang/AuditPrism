
public class Transaction {
	
	private String id;
    private String vendor;
    private double amount;
    private String date;
    private String invoiceNumber;
    // v0.3: Audit risk score
    private int riskScore;

    public Transaction(String id, String vendor, double amount, String date, String invoiceNumber) {

        this.id = id;
        this.vendor = vendor;
        this.amount = amount;
        this.date = date;
        this.invoiceNumber = invoiceNumber;
        this.riskScore = 0;    
        }

    public String getId() {
        return id;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    
    // v0.3: Read risk score
    public int getRiskScore() {
        return riskScore;
    }
    
    // v0.3: Update risk score
    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
    
    public String toString() {
        return id + " | " + vendor + " | $" + amount + " | " + date + " | " + invoiceNumber;
    }

}
