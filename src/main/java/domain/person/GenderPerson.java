package domain.person;

/**
 * Created by filipve on 17/02/2016.
 */
public enum GenderPerson {

    MALE("M"),
    FEMALE("F");

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;


    GenderPerson(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return getGender().toString();
    }
}
