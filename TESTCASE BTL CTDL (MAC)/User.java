public class User {
    private int id;
    private String gender;
    private int age;
    private String occupation;
    private String zipCode;

    public User(int id, String gender, int age, String occupation, String zipCode) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("User[%d, %s, %d, %s, %s]", id, gender, age, occupation, zipCode);
    }
}
