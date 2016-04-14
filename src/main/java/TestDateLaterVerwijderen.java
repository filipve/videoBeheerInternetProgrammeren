import java.time.LocalDate;

/**
 * Created by filip on 9/04/2016.
 */
public class TestDateLaterVerwijderen {

    public static void main(String[] args) {
        int dagvoorvandaag = 6;
        int dagverjaardag = 20;
        int dagnaverjaardag = 26;

        int maandvoorvandaag = 2;
        int maandverjaardag = 4;
        int maandnaverjaardag = 6;

        int jaarverjaardag = 1994;

        TestDateLaterVerwijderen agevoorvandaag = new TestDateLaterVerwijderen(dagvoorvandaag,maandvoorvandaag,jaarverjaardag);
        TestDateLaterVerwijderen ageverjaardag = new TestDateLaterVerwijderen(dagverjaardag,maandverjaardag,jaarverjaardag);
        TestDateLaterVerwijderen agenaverjaardag = new TestDateLaterVerwijderen(dagnaverjaardag,maandnaverjaardag,jaarverjaardag);

        String convertToIntVoorVandaag = agevoorvandaag.zetGeboorteDatumOmNaarTekst(dagvoorvandaag,maandvoorvandaag,jaarverjaardag);
        String convertToIntverjaardag = ageverjaardag.zetGeboorteDatumOmNaarTekst(dagverjaardag,maandverjaardag,jaarverjaardag);
        String convertToIntNaVerjaardag = agenaverjaardag.zetGeboorteDatumOmNaarTekst(dagnaverjaardag,maandnaverjaardag,jaarverjaardag);

        System.out.println("Alles voor de agevoorvandaag : " + convertToIntVoorVandaag );

        System.out.println("de maand nu is : " + agevoorvandaag.dateNow.getMonthValue() + " -> : " + agevoorvandaag.dateNow.getMonth().toString());

        System.out.println("het jaar van geboorte uit string is : " + agevoorvandaag.getJaarGeboorteUitStringGeconverteerd(convertToIntVoorVandaag));

        System.out.println("de maand van geboorte uit string is : " + agevoorvandaag.getMaandGeboorteUitStringGeconverteerd(convertToIntVoorVandaag));

        System.out.println("de dag van geboorte uit string is : " + agevoorvandaag.getDagGeboorteUitStringGeconverteerd(convertToIntVoorVandaag));

        System.out.println("de leeftijd is nu : " + agevoorvandaag.berekenLeeftijd());

        System.out.println( " ------------------------------------------------------------- ");

        System.out.println(" Alles voor de ageverjaardag : " + convertToIntverjaardag);

        System.out.println("de maand nu is : " + ageverjaardag.dateNow.getMonthValue() + " -> : " + ageverjaardag.dateNow.getMonth().toString());

        System.out.println("het jaar van geboorte uit string is : " + ageverjaardag.getJaarGeboorteUitStringGeconverteerd(convertToIntverjaardag));

        System.out.println("de maand van geboorte uit string is : " + ageverjaardag.getMaandGeboorteUitStringGeconverteerd(convertToIntverjaardag));

        System.out.println("de dag van geboorte uit string is : " + ageverjaardag.getDagGeboorteUitStringGeconverteerd(convertToIntverjaardag));

        System.out.println("de leeftijd is nu : " + ageverjaardag.berekenLeeftijd());

        System.out.println( " ------------------------------------------------------------- ");

        System.out.println("Alles voor de ageNaVerjaardag : " + convertToIntNaVerjaardag);

        System.out.println("de maand nu is : " + agenaverjaardag.dateNow.getMonthValue() + " -> : " + agenaverjaardag.dateNow.getMonth().toString());

        System.out.println("het jaar van geboorte uit string is : " + agenaverjaardag.getJaarGeboorteUitStringGeconverteerd(convertToIntNaVerjaardag));

        System.out.println("de maand van geboorte uit string is : " + agenaverjaardag.getMaandGeboorteUitStringGeconverteerd(convertToIntNaVerjaardag));

        System.out.println("de dag van geboorte uit string is : " + agenaverjaardag.getDagGeboorteUitStringGeconverteerd(convertToIntNaVerjaardag));

        System.out.println("de leeftijd is nu : " + agenaverjaardag.berekenLeeftijd());
//22jaar



    }

    private LocalDate dateNow = LocalDate.now();

    private int dagGeboorte;
    private int maandGeboorte;
    private int jaarGeboorte;

    public TestDateLaterVerwijderen(int dagGeboorte, int maandGeboorte, int jaarGeboorte){
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
/*
Plaats 0: dag,
Plaats 1: maand,
Plaats 2: jaar
 */
        String[] output = geboorteDatumConverteren.split("/");
        //int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

        return Integer.parseInt(output[2]);
    }

    public int getMaandGeboorteUitStringGeconverteerd(String geboorteDatumConverteren){
        String[] output = geboorteDatumConverteren.split("/");
        //int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

        return Integer.parseInt(output[1]);
    }

    public int getDagGeboorteUitStringGeconverteerd(String geboorteDatumConverteren){
        String[] output = geboorteDatumConverteren.split("/");
        //int dagInt = Integer.parseInt(geboorteDatumConverteren.split("/"));

        return Integer.parseInt(output[0]);
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

        //als de huidige maand vb. 4 > geboortemaand vb. 2, dan ben je al een jaar ouder geworden
        if(dateNow.getMonthValue() > getMaandGeboorte()){
            leeftijd = dateNow.getYear() - getJaarGeboorte();
        }
        //als de huidige maand vb. 4 < geboortemaand vb. 5, dan ben je nog niet verjaard.
        else if(dateNow.getMonthValue() < getMaandGeboorte()){
            leeftijd =  dateNow.getYear() - getJaarGeboorte() - 1;
            //als de huidige maand hetzelfde is als uw geboortemaand
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
}
