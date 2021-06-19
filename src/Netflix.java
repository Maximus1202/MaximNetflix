import java.util.ArrayList;
import java.util.Scanner;

public class Netflix {
    private ArrayList<Account> accounts;
    private ArrayList<Series> series;
    private Scanner scanner = new Scanner(System.in);
    public Netflix() {
        accounts = new ArrayList<Account>();
        series = new ArrayList<Series>();
    }
    public void addAccount(String acc_name , String pass) {
        login(acc_name , pass);
    }


    public Account login(String acc_name, String pass) {
        Account a = null;
        for (Account account : accounts) {
            if (account.getU_name().equals(acc_name) && account.getPassword().equals(pass)) {
                a = account;
                a = new Account(account);

                break;
            }
        }
        return a;
    }

    public void addSeries() {
        String ep_name, brief;
        int day, month, year, choice;
        Series account1 = new Series("Friends");
        account1.add_episode("1 - The Pilot" ,"Monica and the gang introduce Rachel to the \"real world\" after she leaves her fiancé at the altar. Ross struggles with his rediscovered feelings for Rachel." ,29,9,1994);
        account1.add_episode("2 - The one with the Sonogram at the end" ,"Ross finds out his estranged lesbian wife and her life partner are going to have his baby." ,12,10,1994);
        account1.add_episode("3 - The One With The Thumb" ,"Phoebe discovers a human thumb floating in her can of soda and gets compensation of $7,000. Chandler starts smoking again." ,15,10,1994);
        series.add(account1);
        Series account2 = new Series("ThePeakyBlinders");
        account2.add_episode("1 - ep1" , "In 1919 following the Great War, the Peaky Blinders, led by Thomas \"Tommy\" Shelby, a decorated former sergeant major, appropriate a consignment of guns from the local arms factory.",12,9,2013);
        account2.add_episode("2 - ep2"  , "Tommy, Arthur and John meet with a rival Irish gang, the Lees, to look at a horse for the next race." , 15,9,2013);
        account2.add_episode("3 - ep3" ,"Ada and Freddie marry; Aunt Polly gives them money to leave the country." , 20,9,2013);
        series.add(account2);
        Series account3 = new Series("BreakingBad");
        account3.add_episode("1 - Pilot" ,"Walter White, a 50-year-old high school chemistry teacher facing a midlife crisis, finds out he has Stage 3, inoperable lung cancer." ,20,1,2008);
        account3.add_episode("2 - Cat's in the bag" ,"Walt and Jesse try to dispose of the two bodies in the RV, which becomes increasingly complicated when one of them, Krazy-8, wakes up." , 24,1,2008);
        account3.add_episode("3 - And the bags in the river" , "Walt cannot decide whether to kill Krazy-8 or release him." , 27,1,2008);
        series.add(account3);

    }

    public boolean check_u_name(String u_name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getU_name().equals(u_name)) {
                return false;
            }
        }
        return true;
    }

    public void printAllSeries() {
        for (Series series : series) {
            System.out.println(series.getName());
            System.out.println();
        }
    }

    public void watchSeries(String seriesName, Account account) {
        Series t = null;
        for (Series series : series) {
            if (series.getName().equals(seriesName)) {
                t = series;
                if (account.getSeries_watched().containsKey(series.getName())) {
                    ArrayList<String> a = account.getSeries_watched().get(series.getName());
                    System.out.printf("You watched episode %s", a.get(a.size()-1));
                }
                series.view_episodes();
            }
        }
        if (t == null) {
            System.out.println("Series does not exist");
            return;
        }
        System.out.println("Please enter the name of episode you want to watch");
        String ep_name = scanner.next();
        if (t.check_ep_exist(ep_name)) {
            account.add_to_watched(t, ep_name);
        }
    }









}
