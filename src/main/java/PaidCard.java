import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class PaidCard {
    private Map<LocalDate, Integer> paidMoney = new HashMap<>();
    private ClientType clientType;

    public PaidCard(ClientType clientType) {
        this.clientType = clientType;
    }

    public void payMoney(int sum, LocalDate of) {
        if ((clientType == ClientType.VIP && sum >= 1000) || (clientType == ClientType.STANDARD && sum >= 500)) {
            paidMoney.put(LocalDate.now(), sum);
        } else {
            System.out.println("Payment not sufficient for the client type");
        }
    }

    public Map<LocalDate, Integer> getPaidMoney() {
        return paidMoney;
    }

    @Override
    public String toString() {
        return "PaidCard{" +
                "paidMoney=" + paidMoney +
                ", clientType=" + clientType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaidCard paidCard = (PaidCard) o;
        return paidMoney.equals(paidCard.paidMoney) && clientType == paidCard.clientType;
    }

    @Override
    public int hashCode() {
        return paidMoney.hashCode() * 31 + clientType.hashCode();
    }
}
