public class Main {
    public static void main(String[] args) {

        // LOGIN FIRST
        LoginPage loginPage = new LoginPage();
        String username = loginPage.showLogin();

        System.out.println("Welcome, " + username + "! Starting your game...\n");

        Game game = new Game();
        game.start();
    }
}
