public class employ {
    private String name;
    private String gender;
    private String ID;
    private String dateOfBirth;
    private String phoneNumber;
    private String position;
    public employ() {
    }

    public employ(String name, String gender, String ID, String dateOfBirth, String phoneNumber, String position) {
        this.name = name;
        this.gender = gender;
        this.ID = ID;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}

