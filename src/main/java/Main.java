import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // VipClient creation
        Address vipAddress = new Address(City.BERLIN, 10);
        VipClient vipClient = new VipClient("Alice", "Smith", LocalDate.of(1965, 4, 23), vipAddress);

        // StandardClient creation
        Address standardAddress1 = new Address(City.PARIS, 5);
        StandardClient standardClient1 = new StandardClient("Bob", "Johnson", LocalDate.of(1980, 6, 15), standardAddress1);

        Address standardAddress2 = new Address(City.LONDON, 15);
        StandardClient standardClient2 = new StandardClient("Carol", "White", LocalDate.of(1975, 3, 10), standardAddress2);

        // Payment for client
        vipClient.paidCard.payMoney(1000, LocalDate.of(2024, 1,1));
        vipClient.paidCard.payMoney(1000, LocalDate.of(2024, 3, 15));

        standardClient1.paidCard.payMoney(500, LocalDate.of(2022, 12, 15));
        standardClient1.paidCard.payMoney(500, LocalDate.of(2022, 12, 19));

        // Calculate gift amount for VipClient
        double giftAmount = vipClient.calculateClientPresent();
        System.out.println("Gift amount for VipClient: " + giftAmount);

        // Debtors check
        DebtService debtService = new DebtService();
        System.out.println("Is VipClient a debtor: " + debtService.isDebtorByCard(vipClient.paidCard));
        System.out.println("Is StandardClient a debtor: " + debtService.isDebtorByCard(standardClient1.paidCard));

        // Debts cancel check
        System.out.println("Can cancel VipClient debts: " + debtService.cancelDebts(vipClient));
        System.out.println("Can cancel StandardClient debts: " + debtService.cancelDebts(standardClient1));

        // Employee creation and medical insurance needs check
        Employee employee = new Employee("Dave", "Brown", vipAddress, LocalDate.of(1980, 7, 20));
        System.out.println("Does employee need medical insurance: " + employee.needMedicalInsurance());

        // Medical insurance needs check
        System.out.println("Does VipClient need medical insurance: " + vipClient.needMedicalInsurance());
        System.out.println("Does StandardClient need medical insurance: " + standardClient1.needMedicalInsurance());
    }
}