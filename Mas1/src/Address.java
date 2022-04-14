public class Address {
    protected String postCode;
    protected static String country = "Poland";  // class attribute
    protected String city;
    protected String street;
    protected int houseNumber;

    public Address(String postCode, String city, String street, int houseNumber) {
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
