public class PhoneBook {
    String phoneNumber;
    String group;
    String name;
    String gender;
    String address;
    String emailAddress;

    public PhoneBook(String phoneNumber, String group, String name, String gender, String address, String emailAddress) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "PhoneBook {" +
                "phoneNumber='" + phoneNumber + '\'' +
                "| group='" + group + '\'' +
                "| name='" + name + '\'' +
                "| gender='" + gender + '\'' +
                "| emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
