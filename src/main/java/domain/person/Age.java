package domain.person;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Created by filip on 18/02/2016.
 */
public class Age {

    private LocalDate dateOfBirth;

    public Age(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {


        this.dateOfBirth = dateOfBirth;
    }

    public Month getMaandVanGeboorteInTekst() {
        return getDateOfBirth().getMonth();
    }

    public int getMaandVanGeboorteInGetal() {
        return getDateOfBirth().getMonthValue();
    }

    public int getYearVanGeboorte() {
        return getDateOfBirth().getYear();
    }

    public Period getLeeftijd() {
        return Period.between(getDateOfBirth(), LocalDate.now());
    }

    public int getAantalJarenOud() {
        return getLeeftijd().getYears();
    }

    @Override
    public String toString() {
        return getDateOfBirth().getDayOfMonth() + "/" +
                getDateOfBirth().getMonth() + "/"
                + getDateOfBirth().getYear();
    }
}
