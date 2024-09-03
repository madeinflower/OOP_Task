import java.time.LocalDate;

class VipClient extends Client {
    private boolean satisfied;

    public VipClient(String name, String surname, LocalDate birthDate, Address address) {
        super(name, surname, birthDate, address, ClientType.VIP);
        this.satisfied = true; // Default state
    }

    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

    @Override
    public int calculateClientPresent() {
        return satisfied ? 0 : 200;
    }
}