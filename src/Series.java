import java.util.ArrayList;

public class Series {
    private String name;
    private ArrayList<Episode> episodes;


    public Series(String name) {
        this.name = name;
        this.episodes = new ArrayList<Episode>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void add_episode(String name, String brief, int day, int month, int year) {
        episodes.add(new Episode(name, brief, day, month, year));
    }

    public void view_episodes() {
        for (Episode episode : episodes) {
            System.out.println(episode);
        }
    }
    public boolean check_ep_exist(String ep_name) {
        for (int i = 0; i < episodes.size(); i++) {
            if (episodes.get(i).getName().equals(ep_name)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "TvShow{" +
                "name='" + name + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof Series) {
            if (((Series)obj).getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }


}
