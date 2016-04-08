package domain.person;


import domain.DomainException;

import javax.persistence.*;

/**
 * Created by filipve on 17/02/2016.
 */
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String familyName;
    private Age dateOfBirth;
    private GenderPerson gender;

    public Person(){

    }

    public Person(String name, String familyName, Age dateOfBirth, GenderPerson gender) {
        setName(name);
        setFamilyName(familyName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Age getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Age dateOfBirth) {
        if (dateOfBirth == null) {
            throw new DomainException("DateOfBirth cannot be empty");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.isEmpty()) {
            throw new DomainException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {

        if (familyName == null || familyName.isEmpty()) {
            throw new DomainException("familyname cannot be empty");
        }
        this.familyName = familyName;
    }

    public GenderPerson getGender() {
        return gender;
    }

    public void setGender(GenderPerson gender) {

        if (gender == null) {
            throw new DomainException("gender cannot be empty");
        }
        this.gender = gender;
    }

    public int berekenAantalJaarOud() {
        return getDateOfBirth().getAantalJarenOud();
    }
}
