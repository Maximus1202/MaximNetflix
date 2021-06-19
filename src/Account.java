import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private String name, acc_name, password, formatedCreated, formatedMembershipEnd;
    private LocalDate created, membershipEnd;
    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private HashMap<Series, ArrayList<String>> series_watched;

    public Account() {}
    public Account(String name, String acc_name, String password, int monthsOfMembership) {
        this.name = name;
        this.acc_name = acc_name;
        this.password = password;
        this.created = LocalDate.now();
        this.formatedCreated = created.format(formater);
        this.membershipEnd = created.plusMonths(monthsOfMembership);
        this.formatedMembershipEnd = membershipEnd.format(formater);
        this.series_watched = new HashMap<Series, ArrayList<String>>();
    }


    public Account(Account account) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getU_name() {
        return acc_name;
    }

    public void setU_name(String u_name) {
        this.acc_name = u_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFormatedCreated() {
        return formatedCreated;
    }

    public void setFormatedCreated(String formatedCreated) {
        this.formatedCreated = formatedCreated;
    }

    public String getFormatedMembershipEnd() {
        return formatedMembershipEnd;
    }

    public void setFormatedMembershipEnd(String formatedMembershipEnd) {
        this.formatedMembershipEnd = formatedMembershipEnd;
    }

    public HashMap<Series, ArrayList<String>> getSeries_watched() {
        return series_watched;
    }


    public void printStartedToWatchSeries() {
        for (Series key : series_watched.keySet()) {
            System.out.println(key.getName());
            System.out.println("Last episode: " + series_watched.get(key).get(series_watched.get(key).size()-1));
            if ( key.getName() == null) {
                System.out.println("You did not started to watch any series");

            }
        }
    }

    public void printAccountInfo() {
        int totalShows = series_watched.size(), showsFinished = 0, totalEpisodes = 0;
        for (Series key : series_watched.keySet()) {
            ArrayList<String> a = series_watched.get(key);
            totalEpisodes += a.size();
            String lastEpisode = a.get(a.size()-1);
            if (key.getEpisodes().get(key.getEpisodes().size()-1).getName().equals(lastEpisode)) {
                showsFinished ++;
            }
        }

        System.out.println(toString());
        System.out.println("Total shows watched " + totalShows);
        System.out.println("Total episodes watched " + totalEpisodes);
        System.out.println("Total shows finished " + showsFinished);
        System.out.println();
    }

    public void add_to_watched(Series series, String episode) {
        if (!series_watched.containsKey(series)) {
            series_watched.put(series, new ArrayList<String>());
        }
        series_watched.get(series).add(episode);
    }

    public String toString() {
        return "Account Info:\n" +
                String.format("Name: %s\n", name) +
                String.format("User name: %s\n", acc_name) +
                String.format("Joined at: %s\n", formatedCreated) +
                String.format("Ending in: %s\n", formatedMembershipEnd) ;
    }

}
