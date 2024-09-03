import java.time.LocalDate;

class Employee implements HumanResources {
    private final String name;
    private final String surname;
    private Address homeAddress;
    private LocalDate birthday;

    public Employee(String name, String surname, Address homeAddress, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.homeAddress = homeAddress;
        this.birthday = birthday;
    }

    @Override
    public boolean needMedicalInsurance() {
        int age = LocalDate.now().getYear() - birthday.getYear();
        return age > 35;
    }
}