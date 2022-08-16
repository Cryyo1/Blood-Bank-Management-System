package System_Classes;

public class Profile {

    private Preference preference;
    private User user;

    public Profile(Preference preference, User user) {
        this.preference = preference;
        this.user = user;
    }
    //getters and setters

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
