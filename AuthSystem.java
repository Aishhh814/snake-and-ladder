import java.io.*;
import java.util.*;

public class AuthSystem {
    private static final String FILE_NAME = "users.txt";

    public AuthSystem() {
        File file = new File(FILE_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error initializing user file.");
        }
    }

    public boolean register(String username, String password) {
        if (userExists(username)) {
            System.out.println("Username already exists!");
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            return true;
        } catch (Exception e) {
            System.out.println("Error saving user.");
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading user file.");
        }
        return false;
    }

    private boolean userExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(username)) return true;
            }
        } catch (Exception ignored) {}
        return false;
    }
}
