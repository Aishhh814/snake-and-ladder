import java.util.Scanner;

public class LoginPage {

    public String showLogin() {
        Scanner sc = new Scanner(System.in);
        AuthSystem auth = new AuthSystem();

        while (true) {
            System.out.println("===== LOGIN PAGE =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Username: ");
                String user = sc.nextLine();
                System.out.print("Password: ");
                String pass = sc.nextLine();

                if (auth.login(user, pass)) {
                    System.out.println("\n✔ Login Successful!\n");
                    return user;
                } else {
                    System.out.println("❌ Invalid credentials!");
                }
            }

            else if (choice == 2) {
                System.out.print("Choose Username: ");
                String user = sc.nextLine();
                System.out.print("Choose Password: ");
                String pass = sc.nextLine();

                if (auth.register(user, pass)) {
                    System.out.println("✔ Registration successful! You can now login.\n");
                }
            }

            else if (choice == 3) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
