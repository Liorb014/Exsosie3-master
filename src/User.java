public class User {
    final private String userName;
    final private String password;
    final private String phoneNumber;
    final private boolean isBrokers;

    public User(String userName, String password, String phoneNumber, boolean isBrokers) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isBrokers = isBrokers;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean getIsBrokers() {
        return this.isBrokers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
