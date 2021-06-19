import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Netflix netflix = new Netflix();
        netflix.addSeries();
        Account account = authentication(netflix);
        if (account == null) {
            return;
        }
        menu(netflix, account);
    }

    public static Account authentication(Netflix netflix) {
        int userOption;
        String acc_name, password;
        Account account = new Account();
            while (true) {
                try {
                    System.out.println("____WELCOME TO THE NETFLIX PROGRAM!____\n");
                    System.out.println("1.If you have an account ---> Sign-in");
                    System.out.println("2.If you want to create a new account ---> Sign-up");
                    System.out.println("Enter you choice --> ");
                    userOption = scanner.nextInt();
                    switch (userOption) {

                        case 1:
                            System.out.print("Please insert user name: ");
                            acc_name = scanner.next();
                            System.out.print("Please insert password: ");
                            password = scanner.next();
                            account = netflix.login(acc_name, password);
                            if (account != null) {
                                return account;
                            }
                            System.out.println("User name or password is incorrect, please try again.");
                            break;

                        case 2:
                            System.out.print("Please insert user name: ");
                            acc_name = scanner.next();
                            if (netflix.check_u_name(acc_name)) {
                                account = Input.sign_up(acc_name);
                                return account;
                            }
                            break;
                        default:
                            break;
                    }
                } catch (Exception exception) {
                    System.out.println("Please choose only 1 or 2");
                    scanner.nextLine();
                }
            }
    }

    public static void menu(Netflix netflix, Account account) {
        int choice;
        boolean runMenu = true;
        while(runMenu) {
            try {
                System.out.println("1.Print all series");
                System.out.println("2.Print all series you started watching");
                System.out.println("3.Print account info");
                System.out.println("4.Choose series you want to watch");
                System.out.println("5.Log out");
                choice = scanner.nextInt();
                switch (choice) {
                    case Options.PRINT_ALL_SERIES:
                        netflix.printAllSeries();
                        break;

                    case Options.PRINT_STARTED_WATCHING_SERIES:
                        account.printStartedToWatchSeries();
                        break;

                    case Options.PRINT_ACCOUNT_INFO:
                        account.printAccountInfo();
                        break;

                    case Options.PRINT_SERIES_TO_WATCH:
                        System.out.println("Enter series you want to watch:");
                        String seriesName = scanner.next();
                        netflix.watchSeries(seriesName, account);
                        break;

                    case Options.LOGOUT:
                        runMenu = false;
                        break;

                    default:
                        break;
                }
            } catch (Exception exception) {
                System.out.println("Please enter only numbers 1-5");
                scanner.nextLine();
            }
        }
    }

}
