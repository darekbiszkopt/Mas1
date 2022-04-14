import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public class Client {
    protected Long clientNumber;
    protected Long phoneNumber;
    protected Optional<String> email; // optional attribute
    protected LocalDate birthDate;
    protected int age; // derived attribute
    protected Address address; // composite attribute
    protected List<Long> cardNumbersList; // repeatable attribute

    public Client(Long clientNumber, Long phoneNumber, LocalDate  birthDate, Address address, List<Long> cardNumbersList) {
        this.clientNumber = clientNumber;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = this.getAge();
        this.address = address;
        this.cardNumbersList = cardNumbersList;
    }

    public int getAge() {

        LocalDate currentDate = LocalDate.now();

        return Period.between(this.birthDate, currentDate).getYears();
    }

    @Override
    public String toString() {
        // Override
        return "Client{" +
                "clientNumber=" + clientNumber +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", address=" + address +
                ", cardNumbersList=" + cardNumbersList +
                '}';
    }
}
