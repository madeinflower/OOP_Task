class Address {
    private City city;
    private int houseNumber;

    public Address(City city, int houseNumber) {
        this.city = city;
        this.houseNumber = houseNumber;
    }

    public City getCity() {
        return city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return city + ", " + houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && city == address.city;
    }

    @Override
    public int hashCode() {
        return city.hashCode() * 31 + houseNumber;
    }
}