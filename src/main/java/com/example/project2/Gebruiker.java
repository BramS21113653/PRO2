import java.util.*;

public class Gebruiker {
    private String naam;
    private String wachtwoord;
    private boolean isadmin;
    private ArrayList<Ritten> ritten = new ArrayList<rit>();
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
    


    public Gebruiker(String naam, Integer gebruikerNummer, String wachtwoord, boolean admin){
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.admin = admin;

        gebruikerslijst.add(this);
    }

    public Gebruiker(){}

//    public void removeGebruiker(Gebruiker gebruiker){ --ADMIN TOOL
//        gebruikerslijst.remove(gebruiker);
//    }

    public static ArrayList<Gebruiker> getGebruikersLijst() {
        return gebruikerslijst;
    }

    public String getNaam() {
        return naam;
    }

// public String getWachtwoord() {return wachtwoord;} --ADMIN TOOL

    public Boolean getAdmin() {return admin;}

    public void addRit(Rit rit) {
        this.Ritten.add(rit);
    }

// public Gebruiker getGebruikerOnName(String naam) { -- MOGELIJK BRUIKBAAR
//     Gebruiker match = null;
//     for (Gebruiker gebruiker : gebruikerslijst){
//         if (gebruiker.getNaam().contentEquals(naam)) {
//             match = gebruiker;
//         }
//     }
//     return match;
// }

    @Override
    public String toString() {
        return  "Naam = " + naam + "\n" +
                "Ritten = " + ritten + "\n" +
                "Admin = " + admin + "\n";
    }
}