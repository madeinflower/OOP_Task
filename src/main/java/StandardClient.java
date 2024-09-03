import java.time.LocalDate;

class StandardClient extends Client {
    private boolean wasOnceInactive;

    public StandardClient(String name, String surname, LocalDate birthDate, Address address) {
        super(name, surname, birthDate, address, ClientType.STANDARD);
        this.wasOnceInactive = false;
    }

    public void setWasOnceInactive(boolean wasOnceInactive) {
        this.wasOnceInactive = wasOnceInactive;
    }

    @Override
    public int calculateClientPresent() {
        return wasOnceInactive ? 50 : 100;
    }
}