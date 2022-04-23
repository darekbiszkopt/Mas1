import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

public class Client implements Serializable {
    protected Long clientNumber;
    protected String name;
    protected Long phoneNumber;
    protected Optional<String> email; // optional attribute
    protected LocalDate birthDate; // derived attribute
    protected int age;
    protected Address address; // composite attribute
    protected List<Long> cardNumbersList; // repeatable attribute

    public Client(){
    }

    public Client(Long clientNumber, String name, Long phoneNumber, int age, Address address, List<Long> cardNumbersList) {
        this.clientNumber = clientNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.birthDate = getBirthDate();
        this.address = address;
        this.cardNumbersList = cardNumbersList;
    }

    public int getAge() {

        LocalDate currentDate = LocalDate.now();

        return Period.between(this.birthDate, currentDate).getYears();
    }

    public Client show(int i) throws IOException, ClassNotFoundException {
        File file = new File("student.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Client> c1 = (List<Client>) ois.readObject();
        ois.close();

        return c1.get(i);
    };

    public String show(int i, String type) throws IOException, ClassNotFoundException {
        File file = new File("student.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Client> c1 = (List<Client>) ois.readObject();
        ois.close();

        String returnValue = "";

        switch (type) {
            case "age" -> {
                returnValue = "" + c1.get(i).age;
            }
            case "name" -> {
                returnValue =  c1.get(i).name;
            }
            case "address" -> {
                returnValue =  c1.get(i).address.toString();
            }
            case "cardNumbersList" -> {
                returnValue =  c1.get(i).cardNumbersList.toString();
            }
        }
        return returnValue;
    };

    public LocalDate getBirthDate() {

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate
                .of(currentDate.getYear() - this.age, currentDate.getMonth(), currentDate.getDayOfMonth());


        return birthDate;
    }

    @Override
    public String toString() {
        // Override
        return "Client { " +
                "clientNumber = " + clientNumber +
                " , phoneNumber = " + phoneNumber +
                " , email = " + email +
                " , birthDate = " + birthDate +
                " , age = " + age + "\n" +
                 address + "\n" +
                "CardNumbersList = " + cardNumbersList  +
                " }" + "\n";
    }
}
