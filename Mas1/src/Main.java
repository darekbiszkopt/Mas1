import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("student.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Client> c1 = (List<Client>) ois.readObject();
        ois.close();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello Masy");
        int menuNumber;
        int addClient;
        boolean menuOn = true;

        while (menuOn) {
            System.out.println("#########################      Menu     ###################################");
            System.out.println("###########################################################################");

            System.out.println(" Choose --> 1. Add client 2. Show list of clients 3. Delete client 4. Turn off app");
            menuNumber  = scan.nextInt();
            switch (menuNumber) {
                case 1 -> {

                    do {

                        System.out.println("###########################################################################");
                        System.out.println("############################      Add client:    ##########################");
                        System.out.println("###########################################################################");

                        System.out.println("Add clientNumber: ");
                        Long scanNumberL = scan.nextLong();

                        System.out.println("Add client name: ");
                        String breakx = scan.nextLine();
                        String name = scan.nextLine();

                        System.out.println("Add phoneNumber: xxx-xxx-xxx");
                        Long phoneNumberL = scan.nextLong();

                        System.out.println("Add age: ");
                        int age = scan.nextInt();

                        System.out.println("Add card: ");
                        List<Long> list = new ArrayList<>();
                        long cardL;
                        do {
                            cardL = scan.nextLong();
                            if (cardL != 1) {
                                list.add(cardL);
                            }
                        } while (cardL != 1);

                        System.out.println("Add address: ");
                        System.out.println("Add postCode: ");
                        String breakxx = scan.nextLine();
                        String postCode1 = scan.nextLine();

                        System.out.println("Add city: ");
                        String city = scan.nextLine();

                        System.out.println("Add street: ");
                        String street = scan.nextLine();

                        System.out.println("Add hauseNumber: ");
                        int houseNumber = scan.nextInt();

                        Address address = new Address(postCode1, city, street, houseNumber);
                        Client client1 = new Client(scanNumberL, name, phoneNumberL, age, address, list);
                        c1.add(client1);
                        System.out.println("Add client?? 1. Yes 2.No ");
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(c1);
                        oos.close();
                        addClient = scan.nextInt();

                    } while (addClient == 1);
                }
                case 2 -> {
                    System.out.println("############################################################################");
                    System.out.println("################    Show list of clients:      #############################");
                    System.out.println("############################################################################");
                    for (int i = 0; i < c1.size(); i++) {
                        System.out.println(c1.get(i));
                    }
                }
                case 3 -> {
                    System.out.println("############################################################################");
                    System.out.println("############################     Delete client:       ######################");
                    System.out.println("############################################################################");

                    for (int i = 0; i < c1.size(); i++) {
                        System.out.println("Choose number: " + i + " to delete");
                        System.out.println(c1.get(i));
                    }

                    int numberToDelete = scan.nextInt();
                    c1.remove(numberToDelete);

                    for (int i = 0; i < c1.size(); i++) {
                        System.out.println("Choose number: " + i + " to delete");
                        System.out.println(c1.get(i));
                    }
                }

                case 4 -> {
                    System.out.println("############################################################################");
                    System.out.println("##########################       Show client with id:      ################");
                    System.out.println("############################################################################");
                    Client client = new Client();

                    for (int i = 0; i < c1.size(); i++) {
                        System.out.println("Choose number: " + i + " to show client");
                        System.out.println(c1.get(i));
                    }
                    int choosenId = scan.nextInt();
                    client.show(choosenId);
                }

                case 5 -> {
                    System.out.println("############################################################################");
                    System.out.println("##########################       Show client with id and choose type name, address, age...:      ################");
                    System.out.println("############################################################################");
                    Client client = new Client();

                    for (int i = 0; i < c1.size(); i++) {
                        System.out.println("Choose number: " + i + " to show client");
                        System.out.println(c1.get(i));
                    }
                    System.out.println("Choose id");
                    int choosenId = scan.nextInt();
                    System.out.println("Choose type");
                    String breaks = scan.nextLine();
                    String choosenType = scan.nextLine();
                    client.show(choosenId);

                }

                case 6 -> {
                    System.out.println("############################################################################");
                    System.out.println("##########################       App is turning off...      ################");
                    System.out.println("############################################################################");
                    menuOn = false;
                }
            }
        }

        //To do przeciązone metody +  dodać scanner dodawanie usuwanie odczyt obiektów klasy Client za pomocą Scanner
    }
}
