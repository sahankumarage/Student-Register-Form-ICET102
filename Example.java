import java.util.Scanner;
class Contact{
    private String contactId;
    private String name;
    private String phoneNumber;
    private String company;
    private double salary;
    private String birthday;


    public Contact(String contactId, String name, String phoneNumber, String company, double salary, String birthday) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

public class Example {
    public static Contact[] contacts = new Contact[0];
    private static int contactCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("               /$$ /$$$$$$$$ /$$$$$$$   /$$$$$$/$$$$$$$$ /$$   /$$  /$$$$$$$                                   ");
        System.out.println("               |_/| $$_____/| $$_  $$|_  $$/| $$_____/| $$$ |  $$| $$_   $$                              ");
        System.out.println("                /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$|  $$| $$  \\  $$                    ");
        System.out.println("               | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$  $$| $$  |  $$                    ");
        System.out.println("               | $$| $$_/   | $$_  $$  | $$  | $$__/   | $$   $$$$| $$  |  $$                   ");
        System.out.println("               | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\   $$$| $$  |  $$                 ");
        System.out.println("               | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\   $$| $$$$$$$/                         ");
        System.out.println("               |__/|__/      |__/  |__/|______/|________/|__/  \\__/|________/                                 ");
        System.out.println();
        System.out.println("    _____            _             _           ____                  _     ");
        System.out.println("   / ____|          | |           | |         / __ \\                (_)             ");
        System.out.println("  | |     ___  _ __ | |_ __ _  __| | ___   | |  | |_ __ __ _ _ __  _ ________ _ __               ");
        System.out.println("  | |    / _ \\| '_ \\| _/ _` |/ __| __/  _|  | |  | | '__/ _` | ' \\| |_  / _  \\ '__|                         ");
        System.out.println("  | |__| (_) | | | | || |_| | |__| |_\\_ \\  | |__| | | | |_| | | | | |/ /   __/ |             ");
        System.out.println("   \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/   \\____/|_|  \\__,_|_| |_|_/___\\____|_|                                                     ");
        System.out.println();
        System.out.println();
        System.out.println("=============================================================================================\n\n ");

        System.out.println("        [01] Add Contact");
        System.out.println("        [02] Update Contact");
        System.out.println("        [03] Delete Contact");
        System.out.println("        [04] Search Contact");
        System.out.println("        [05] List Contacts");
        System.out.println("        [06] Exit");

        System.out.print("\n\nEnter an option to continue -> ");
        String choice = scanner.nextLine();


        switch (choice) {
            case "1":
                clearConsole();
                System.out.println("+-----------------------------------+");
                System.out.println("|      Add Contact to the list      |");
                System.out.println("+-----------------------------------+");
                addContact();
                break;

            case "2":
                clearConsole();
                System.out.println("+-----------------------------------+");
                System.out.println("|           Update Contact          |");
                System.out.println("+-----------------------------------+");
                updateContact(scanner);
                break;

            case "3":
                clearConsole();
                System.out.println("+-----------------------------------+");
                System.out.println("|            Delete Contact         |");
                System.out.println("+-----------------------------------+");
                deleteContact(scanner);
                break;

            case "4":
                clearConsole();
                System.out.println("+-----------------------------------+");
                System.out.println("|            Search Contact         |");
                System.out.println("+-----------------------------------+");
                searchContact(scanner);
                break;

            case "5":
                clearConsole();
                listContacts(scanner);
                break;

            case "6":
                clearConsole();
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\tExiting");
                for (int i = 0; i < 8; i++) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);
                    } catch (Exception ex) {
                    }

                }
                System.out.println("\n\n\t\t\t\t\t\tGood Bye! Have a Nice day :)\n\n\n\n\n\n\n\n");
                System.exit(0);
                break;
        }


    }

    public static void extendsArrays() {
        Contact[] tempContacts = new Contact[contacts.length + 1];
        for (int i = 0; i < contacts.length; i++) {
            tempContacts[i] = contacts[i];
        }
        contacts = tempContacts;
    }

//---------------------------------------------------------------[01] ADD-------------------------------------------------------------------------------------------------

    public static void addContact() {
        Scanner scanner = new Scanner(System.in);

        String contactId = generateContactId();
        String name, phoneNumber, company;
        double salary;
        String birthday;
        extendsArrays();
        System.out.println("  |  ID : " + contactId + "  |");
        System.out.println("===================");

        System.out.println();

        System.out.print("Enter Name                  : ");
        name = scanner.nextLine();

        //System.out.println(Arrays.toString(names));

        System.out.print("Enter Phone Number          : ");
        phoneNumber = scanner.nextLine();
        while (!isValidPhoneNumber(phoneNumber)) {
            System.out.print("Invalid Phone Number! Enter a valid Phone Number : ");
            phoneNumber = scanner.nextLine();
        }

        //System.out.println(Arrays.toString(phoneNumbers));

        System.out.print("Enter Company               : ");
        company = scanner.nextLine();

        //System.out.println(Arrays.toString(companies));

        System.out.print("Enter Salary                : ");
        salary = Double.parseDouble(scanner.nextLine());
        while (salary <= 0) {
            System.out.print("Invalid Salary! Enter a positive Salary : ");
            salary = Double.parseDouble(scanner.nextLine());
        }

        //System.out.println(Arrays.toString(salaries));

        System.out.print("Enter Birthday (YYYY-MM-DD) : ");
        birthday = scanner.nextLine();
        while (!isValidDate(birthday)) {
            System.out.print("Invalid Birthday! Enter a valid Birthday (YYYY-MM-DD) : ");
            birthday = scanner.nextLine();
        }

        //System.out.println(Arrays.toString(birthdays));
        Contact contact = new Contact(contactId, name, phoneNumber, company, salary, birthday);
        contacts[contacts.length-1]=contact;
        contactCount++;

        System.out.println("\n\nContact added successfully! :)\n\n");
        System.out.print("Do you want to add another Contact (Y/N) : ");
        char conAdd = scanner.next().charAt(0);
        if (conAdd == 'y' || conAdd == 'Y') {
            clearConsole();
            System.out.println("+-----------------------------------+");
            System.out.println("|      Add Contact to the list      |");
            System.out.println("+-----------------------------------+");
            addContact();
        } else if (conAdd == 'n' || conAdd == 'N') {
            main(null);
        }
    }
	static int nextId;
    public static String generateContactId() {
        int nextContactId = contactCount + 1;
        nextId=nextContactId;
        return "C00" + nextContactId;
    }
    public static void regenrateCid(){
		String cLastId=contacts[contacts.length-1].getContactId();
		String numericValue = cLastId.substring(1); // Extract numeric portion of the string
        int intValue = Integer.parseInt(numericValue);
        contactCount=intValue; 
		}

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^0\\d{9}$");
    }

    public static boolean isValidDate(String date) {

        if (date.length() != 10) {
            return false;
        }

        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        if (year < 1900 || year > currentYear) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        return day >= 1 && day <= 31;
    }

//----------------------------------------------------------[02] UPDATE------------------------------------------------------------

    public static void updateContact(Scanner scanner) {
        System.out.print("\n\nEnter the Contact Name or Phone Number to search :- ");
        String searchTerm = scanner.nextLine();
        System.out.println();
        System.out.println();

        int foundIndex = findContactIndex(searchTerm);
        if (foundIndex == -1) {
            System.out.println("\t\tContact not found. :(\n\n");
        } else {

            System.out.println("    Contact ID        : " + contacts[foundIndex].getContactId());
            System.out.println("    Name              : " + contacts[foundIndex].getName());
            System.out.println("    Phone Number      : " + contacts[foundIndex].getPhoneNumber());
            System.out.println("    Company           : " + contacts[foundIndex].getCompany());
            System.out.println("    Salary            : " + contacts[foundIndex].getSalary());
            System.out.println("    Birthday          : " + contacts[foundIndex].getBirthday());
            System.out.println("\n\nWhat do you want to update...\n");
            System.out.println("            [01] Name");
            System.out.println("            [02] Phone Number");
            System.out.println("            [03] Company");
            System.out.println("            [04] Salary");
            System.out.println("            [05] Go back to main menu");
            System.out.print("\n\nEnter an option to continue -> ");
            String choice = scanner.nextLine();
            System.out.println();
            switch (choice) {
                case "1":
                    System.out.print("Enter new Name : ");
                    String name= scanner.nextLine();
                    contacts[foundIndex].setName(name);
                    System.out.println("            Name updated successfully!          ");
                    break;
                case "2":
                    System.out.print("Enter new Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    while (!isValidPhoneNumber(newPhoneNumber)) {
                        System.out.print("Invalid Phone Number! Enter a valid Phone Number: ");
                        newPhoneNumber = scanner.nextLine();
                    }
                    contacts[foundIndex].setPhoneNumber(newPhoneNumber);
                    System.out.println("Phone Number updated successfully!");
                    break;
                case "3":
                    System.out.print("Enter new Company: ");
                    String company= scanner.nextLine();
                    contacts[foundIndex].setCompany(company);
                    System.out.println("Company updated successfully!");
                    break;
                case "4":
                    System.out.print("Enter new Salary: ");
                    double newSalary = Double.parseDouble(scanner.nextLine());
                    while (newSalary <= 0) {
                        System.out.print("Invalid Salary! Enter a positive Salary: ");
                        newSalary = Double.parseDouble(scanner.nextLine());
                    }
                    contacts[foundIndex].setSalary(newSalary);
                    System.out.println("Salary updated successfully!");
                    break;
                case "5":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Returning to main menu...");
                    break;
            }
        }
        System.out.print("Do you want to Update another Contact (Y/N) : ");
        char conUp = scanner.next().charAt(0);

        if (conUp == 'y' || conUp == 'Y') {
            clearConsole();
            System.out.println("+-----------------------------------+");
            System.out.println("|           Update Contact          |");
            System.out.println("+-----------------------------------+");
            updateContact(scanner);
        } else if (conUp == 'n' || conUp == 'N') {
            main(null);
        } else {
            main(null);
        }
    }

//------------------------------------------------------------[03] DELETE---------------------------------------------------------------------

    public static void deleteContact(Scanner scanner) {
        System.out.print("\n\nEnter the Contact Name or Phone Number to delete -> ");
        String searchTerm = scanner.nextLine();

        int foundIndex = findContactIndex(searchTerm);
        if (foundIndex == -1) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Contact ID    : " + contacts[foundIndex].getContactId());
            System.out.println("Name          : " + contacts[foundIndex].getName());
            System.out.println("Phone Number  : " + contacts[foundIndex].getPhoneNumber());
            System.out.println("Company       : " + contacts[foundIndex].getCompany());
            System.out.println("Salary        : " + contacts[foundIndex].getSalary());
            System.out.println("Birthday      : " + contacts[foundIndex].getBirthday());

            System.out.print("\nAre you sure you want to delete this contact? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equals("Y") || confirmation.equals("y")) {
				
				Contact [] con=deleteElementByIndex(contacts,foundIndex);
				
                
                if (contacts!=null){
					System.out.println("            Contact deleted successfully!");
					contacts=con;
					regenrateCid();
					contactCount--;
				}
            } else {
                System.out.println("            Contact deletion cancelled :(");
            }
            
        }
        System.out.print("\n\n\tDo you want to Delete another Contact (Y/N) : ");
        char conDe = scanner.next().charAt(0);

        if (conDe == 'y' || conDe == 'Y') {
            clearConsole();
            System.out.println("+-----------------------------------+");
            System.out.println("|            Delete Contact         |");
            System.out.println("+-----------------------------------+");
            deleteContact(scanner);
        } else if (conDe == 'n' || conDe == 'N') {
            main(null);

        }
    }
     public static Contact[] deleteElementByIndex(Contact [] array, int index) {
        if (index >= 0 && index < array.length) {
            Contact [] newArray = new Contact[array.length - 1];
            int newArrayIndex = 0;

            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[newArrayIndex] = array[i];
                    newArrayIndex++;
                }
            }

            return newArray;
        } else {
            return null; // Return null if the index is invalid
        }
    }
//----------------------------------------------------------[04] SEARCH CONTACT-----------------------------------------------------------

    public static void searchContact(Scanner scanner) {
        System.out.print("\n\nEnter the Contact Name or Phone Number to search: ");
        String searchTerm = scanner.nextLine();

        int foundIndex = findContactIndex(searchTerm);
        if (foundIndex == -1) {
            System.out.println("Contact not found.");
        } else {

            System.out.println("\n\nContact Details:");
            System.out.println("================\n");
            System.out.println("Contact ID     : " + contacts[foundIndex].getContactId());
            System.out.println("Name           : " + contacts[foundIndex].getName());
            System.out.println("Phone Number   : " + contacts[foundIndex].getPhoneNumber());
            System.out.println("Company        : " + contacts[foundIndex].getCompany());
            System.out.println("Salary         : " + contacts[foundIndex].getSalary());
            System.out.println("Birthday       : " + contacts[foundIndex].getBirthday());
        }
        System.out.print("\n\nDo you want to Search another Contact (Y/N) : ");
        char conSe = scanner.next().charAt(0);

        if (conSe == 'y' || conSe == 'Y') {
            clearConsole();
            System.out.println("+-----------------------------------+");
            System.out.println("|            Search Contact         |");
            System.out.println("+-----------------------------------+");
            searchContact(scanner);
        } else if (conSe == 'n' || conSe == 'N') {
            main(null);

        }

    }

    //----------------------------------------------------------[05] LIST CONTACT-----------------------------------------------------------

    public static void listContacts(Scanner scanner) {
        System.out.println("+-----------------------------------+");
        System.out.println("|            List Contacts          |");
        System.out.println("+-----------------------------------+");
        System.out.println();
        System.out.println();
        System.out.println("        [01] Shorting by Name");
        System.out.println("        [02] Shorting by Salary");
        System.out.println("        [03] Shorting by Birthday");
        System.out.println();
        System.out.println();

        System.out.print("Enter an option to continue -> ");
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                sortContactsByName(scanner);
                break;
            case 2:
                sortContactsBySalary(scanner);
                break;
            case 3:
                sortContactsByBirthday(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu...");
                listContacts(null);
                return;
        }

        System.out.println("\n\nContact Listing:");
        for (int i = 0; i < contactCount; i++) {
            System.out.println("Contact ID    : " + contacts[i].getContactId());
            System.out.println("Name          : " + contacts[i].getName());
            System.out.println("Phone Number  : " + contacts[i].getPhoneNumber());
            System.out.println("Company       : " + contacts[i].getCompany());
            System.out.println("Salary        : " + contacts[i].getSalary());
            System.out.println("Birthday      : " + contacts[i].getBirthday());
            System.out.println("---------------------------\n\n");
        }
    }

    public static int findContactIndex(String searchTerm) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getName().equals(searchTerm) || contacts[i].getPhoneNumber().equals(searchTerm)) {
                return i;
            }
        }
        return -1;
    }


    public static void sortContactsByName(Scanner scanner) {


        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getName().compareToIgnoreCase(contacts[j + 1].getName()) > 0) {

                    Contact temp =contacts[j];
                    contacts[j]=contacts[j+1];
                    contacts[j+1]=temp;

                }
            }
        }
        clearConsole();
        System.out.println("                  +----------------------------------------------------+");
        System.out.println("                  |                 List Contact by Name               |");
        System.out.println("                  +----------------------------------------------------+\n\n");
        System.out.println("\n+----------------------------------------------------------------------------------------------+");
        System.out.println("| Contact ID  |      Name      |  Phone Number  |    Company    |     Salary    |   Birthday   |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        for (int i = 0; i < contactCount; i++) {
            System.out.printf("| %-12s| %-15s|   %-13s|  %-13s|   %-12s|  %-12s|\n", contacts[i].getContactId(), contacts[i].getName(),
                    contacts[i].getPhoneNumber(), contacts[i].getCompany(), contacts[i].getSalary(), contacts[i].getBirthday());

        }
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.print("\n\nDo you want to Sort another Contact (Y/N) : ");
        char conSo = scanner.next().charAt(0);

        if (conSo == 'y' || conSo == 'Y') {
            clearConsole();
            listContacts(scanner);
        } else if (conSo == 'n' || conSo == 'N') {
            main(null);

        }
    }

    public static void sortContactsBySalary(Scanner scanner) {
        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getSalary() > contacts[j + 1].getSalary()) {

                    Contact temp =contacts[j];
                    contacts[j]=contacts[j+1];
                    contacts[j+1]=temp;
                }
            }
        }
        clearConsole();
        System.out.println("                  +----------------------------------------------------+");
        System.out.println("                  |                 List Contact by Salary             |");
        System.out.println("                  +----------------------------------------------------+\n\n");
        System.out.println("\n+----------------------------------------------------------------------------------------------+");
        System.out.println("| Contact ID  |      Name      |  Phone Number  |    Company    |     Salary    |   Birthday   |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        for (int i = 0; i < contactCount; i++) {
            System.out.printf("| %-12s| %-15s|   %-13s|  %-13s|   %-12s|  %-12s|\n", contacts[i].getContactId(), contacts[i].getName(),
                    contacts[i].getPhoneNumber(), contacts[i].getCompany(), contacts[i].getSalary(), contacts[i].getBirthday());

        }
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.print("\n\nDo you want to Sort another Contact (Y/N) : ");
        char conSo = scanner.next().charAt(0);

        if (conSo == 'y' || conSo == 'Y') {
            clearConsole();
            listContacts(scanner);
        } else if (conSo == 'n' || conSo == 'N') {
            main(null);

        }

    }

    public static void sortContactsByBirthday(Scanner scanner) {
        for (int i = 0; i < contactCount - 1; i++) {
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (contacts[j].getBirthday().compareTo(contacts[j + 1].getBirthday()) > 0) {

                    Contact temp =contacts[j];
                    contacts[j]=contacts[j+1];
                    contacts[j+1]=temp;
                }
            }
        }
        clearConsole();
        System.out.println("                  +----------------------------------------------------+");
        System.out.println("                  |                 List Contact by Birthday           |");
        System.out.println("                  +----------------------------------------------------+\n\n");
        System.out.println("\n+----------------------------------------------------------------------------------------------+");
        System.out.println("| Contact ID  |      Name      |  Phone Number  |    Company    |     Salary    |   Birthday   |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        for (int i = 0; i < contactCount; i++) {
            System.out.printf("| %-12s| %-15s|   %-13s|  %-13s|   %-12s|  %-12s|\n", contacts[i].getContactId(), contacts[i].getName(),
                    contacts[i].getPhoneNumber(), contacts[i].getCompany(), contacts[i].getSalary(), contacts[i].getBirthday());

        }
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.print("\n\nDo you want to Sort another Contact (Y/N) : ");
        char conSo = scanner.next().charAt(0);

        if (conSo == 'y' || conSo == 'Y') {
            clearConsole();
            listContacts(scanner);
        } else if (conSo == 'n' || conSo == 'N') {
            main(null);

        }
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
// Handle any exceptions.
        }
    }
}
