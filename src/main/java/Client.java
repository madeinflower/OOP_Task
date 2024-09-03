import java.time.LocalDate;

abstract class Client implements HumanResources {
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private boolean active;
    protected Address address;
    protected PaidCard paidCard;

    public Client(String name, String surname, LocalDate birthDate, Address address, ClientType clientType) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.active = true;
        this.paidCard = new PaidCard(clientType);
    }

    public abstract int calculateClientPresent();

    @Override
    public boolean needMedicalInsurance() {
        int age = LocalDate.now().getYear() - birthDate.getYear();
        return (active && age > 55 && address.getCity() == City.BERLIN);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", born on " + birthDate + ", address: " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) && surname.equals(client.surname) && birthDate.equals(client.birthDate);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + surname.hashCode() * 31 + birthDate.hashCode();
    }
}