package domain.person;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Created by filip on 18/02/2016.
 */
public class Age {



    private LocalDate dateOfBirth;
    private LocalDate dateNow = LocalDate.now();

    private int dagGeboorte;
    private int maandGeboorte;
    private int jaarGeboorte;

    public Age(int dagGeboorte, int maandGeboorte, int jaarGeboorte){
        setDagGeboorte(dagGeboorte);
        setMaandGeboorte(maandGeboorte);
        setJaarGeboorte(jaarGeboorte);
        dateNow = LocalDate.now();
    }

    public String zetGeboorteDatumOmNaarTekst(int dagGeboorte, int maandGeboorte, int jaarGeboorte){
        String dagString = String.valueOf(dagGeboorte);
        String maandString = String.valueOf(maandGeboorte);
        String jaarString = String.valueOf(jaarGeboorte);

        return dagString + "/" + maandString + "/" + jaarString;
    }

    public int getJaarGeboorteUitStringGeconverteerd(String geboorteDatumConverteren){

        String[] output = geboorteDatumConverteren.split("/");
        //int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

        return Integer.parseInt(output[0]);
    }

    public int getMaandGeboorteUitStringGeconverteerd(String geboorteDatumConverteren){
        String[] output = geboorteDatumConverteren.split("/");
        //int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

        return Integer.parseInt(output[1]);
    }

    public int getDagGeboorteUitStringGeconverteerd(String geboorteDatumConverteren){
        String[] output = geboorteDatumConverteren.split("/");
        //int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

        return Integer.parseInt(output[2]);
    }

    public Age(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
    }

    public int getJaarGeboorte() {
        return jaarGeboorte;
    }

    public void setJaarGeboorte(int jaarGeboorte) {
        this.jaarGeboorte = jaarGeboorte;
    }

    public int getMaandGeboorte() {
        return maandGeboorte;
    }

    public void setMaandGeboorte(int maandGeboorte) {
        this.maandGeboorte = maandGeboorte;
    }

    public int getDagGeboorte() {
        return dagGeboorte;
    }

    public void setDagGeboorte(int dagGeboorte) {
        this.dagGeboorte = dagGeboorte;
    }

    public int berekenLeeftijd(){
        int leeftijd = 0;

        //als de huidige maand vb. 5 > geboortemaand vb. 4, dan ben je al een jaar ouder geworden
        if(dateNow.getMonthValue() > getMaandGeboorte()){
            leeftijd = dateNow.getYear() - getJaarGeboorte();
        }
        //als de huidige maand vb. 5 < geboortemaand vb. 6, dan ben je nog niet verjaard.
        else if(dateNow.getMonthValue() < getMaandGeboorte()){
            leeftijd =  dateNow.getYear() - getJaarGeboorte() - 1;
        }else if(dateNow.getMonthValue() == getMaandGeboorte()){
            //als het dezelfde maand is.
            //vb. vandaag is het 4 april
            if(dateNow.getDayOfMonth() == getDagGeboorte()){
                System.out.println("je bent jarig");
                //4 < 6
            }else if(dateNow.getDayOfMonth() < getDagGeboorte()){
                leeftijd = dateNow.getYear() - getJaarGeboorte() - 1;
            }else if(dateNow.getDayOfMonth() > getDagGeboorte()){
                leeftijd = dateNow.getYear() - getJaarGeboorte();
            }
        }
        return leeftijd;
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
