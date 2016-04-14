package domain.person;


import domain.DomainException;
import org.apache.derby.client.am.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by filipve on 17/02/2016.
 */
@SuppressWarnings("JpaAttributeTypeInspection")
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=3,max=40)
    private String name;

    @NotNull
    @Size(min=3,max=40)
    private String familyName;

    //@Embedded
    //private Age dateOfBirth;

    @Enumerated(EnumType.STRING)
    private GenderPerson gender;

    private String sex;

    private boolean geslacht;

    private int dagGeboorte;

    /*
    @DateTimeFormat (pattern="dd/MM/yyyy")
    private LocalDate dob;

    public LocalDate getDob(){
        return dob;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getDagGeboorte() {
        return dagGeboorte;
    }

    public void setDagGeboorte(int dagGeboorte) {
        this.dagGeboorte = dagGeboorte;
    }

    public int getMaandGeboorte() {
        return maandGeboorte;
    }

    public void setMaandGeboorte(int maandGeboorte) {
        this.maandGeboorte = maandGeboorte;
    }

    public int getJaarGeboorte() {
        return jaarGeboorte;
    }

    public void setJaarGeboorte(int jaarGeboorte) {
        this.jaarGeboorte = jaarGeboorte;
    }

    private int maandGeboorte;
    private int jaarGeboorte;

    public Person(){

    }

    /*
    public Person(String name, String familyName, Age dateOfBirth, GenderPerson gender) {
        setName(name);
        setFamilyName(familyName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
    }*/

    public boolean isGeslacht() {
        return geslacht;
    }

    public void setGeslacht(boolean geslacht) {
        this.geslacht = geslacht;
    }

    //Als het geslacht true is, is het een man. Bij false een vrouw;
    public String manOfVrouw()
    {
        if(isGeslacht()){
            return "M";
        }
        return "V";
    }

    public Person(String name, String familyName, int dagGeboorte, int maandGeboorte, int jaarGeboorte, boolean geslacht){
        setName(name);
        setFamilyName(familyName);
        setJaarGeboorte(jaarGeboorte);
        setMaandGeboorte(maandGeboorte);
        setDagGeboorte(dagGeboorte);
        setGeslacht(geslacht);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String zetGeboorteDatumOmNaarTekst(int dagGeboorte, int maandGeboorte, int jaarGeboorte){
        String dagString = String.valueOf(dagGeboorte);
        String maandString = String.valueOf(maandGeboorte);
        String jaarString = String.valueOf(jaarGeboorte);

        return dagString + "/" + maandString + "/" + jaarString;
    }

    public String zetGeboorteDatumOmNaarTekst(){
        String dagString = String.valueOf(getDagGeboorte());
        String maandString = String.valueOf(getMaandGeboorte());
        String jaarString = String.valueOf(getJaarGeboorte());

        return dagString + "/" + maandString + "/" + jaarString;
    }

/*
    public Age getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dagGeboorte, int maandGeboorte, int jaarGeboorte) {
        Age age = new Age(dagGeboorte, maandGeboorte, jaarGeboorte);
        this.dateOfBirth = age;
    }
    */

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
     //   return getDateOfBirth().berekenLeeftijd();
        return 0;
    }

    public int berekenLeeftijd(){
        int leeftijd = 0;
        LocalDate dateNow = LocalDate.now();

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
                leeftijd = dateNow.getYear() - getJaarGeboorte();
                //4 < 6
            }else if(dateNow.getDayOfMonth() < getDagGeboorte()){
                leeftijd = dateNow.getYear() - getJaarGeboorte() - 1;
            }else if(dateNow.getDayOfMonth() > getDagGeboorte()){
                leeftijd = dateNow.getYear() - getJaarGeboorte();
            }
        }
        return leeftijd;
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














}
