import java.time.LocalDate;
import java.util.Map;

class DebtService {
    public boolean isDebtorByCard(PaidCard paidCard) {
        LocalDate now = LocalDate.now();
        for (LocalDate date : paidCard.getPaidMoney().keySet()) {
            if (paidCard.getPaidMoney().get(date) > 0 && date.isAfter(now.minusDays(90))) {
                return false;
            }
        }
        return true;
    }

    public boolean cancelDebts(Client client) {
        Map<LocalDate, Integer> payments = client.paidCard.getPaidMoney();
        LocalDate lastPaymentDate = null;
        int lastPaymentAmount = 0;

        for (LocalDate date : payments.keySet()) {
            if (lastPaymentDate == null || date.isAfter(lastPaymentDate)) {
                lastPaymentDate = date;
                lastPaymentAmount = payments.get(date);
            }
        }

        if (lastPaymentDate != null) {
            for (LocalDate date : payments.keySet()) {
                if (date.isBefore(lastPaymentDate) && payments.get(date) * 2 <= lastPaymentAmount) {
                    return true;
                }
            }
        }
        return false;
    }
}
