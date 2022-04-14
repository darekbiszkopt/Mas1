import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Masy");
        LocalDate birthDate = LocalDate.of(1995, 5, 17);
        List<Long> list = new ArrayList<>();
        list.add(22222L);
        list.add(33222L);
        list.add(44222L);

        Address address = new Address("00-733", "Warsaw", "Dolna", 2);
        Client client1 = new Client(21522L, 531408726L, birthDate, address, list);
        System.out.println(client1.toString());

        //To do przeciązone metody +  dodać scanner dodawanie usuwanie odczyt obiektów klasy Client za pomocą Scanner
    }
}
