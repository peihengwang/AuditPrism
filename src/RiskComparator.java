import java.util.Comparator;
public class RiskComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction t1, Transaction t2) {

        return Integer.compare(t2.getRiskScore(), t1.getRiskScore());
    }
}
