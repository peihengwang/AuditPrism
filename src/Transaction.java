
public class Transaction {
	
	private String id;
    private String vendor;
    private double amount;
    private String date;
    private String invoiceNumber;

    public Transaction(String id, String vendor, double amount, String date, String invoiceNumber) {

        this.id = id;
        this.vendor = vendor;
        this.amount = amount;
        this.date = date;
        this.invoiceNumber = invoiceNumber;
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

    public String toString() {
        return id + " | " + vendor + " | $" + amount + " | " + date + " | " + invoiceNumber;
    }

}
