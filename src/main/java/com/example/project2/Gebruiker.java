import java.util.*;

public class Gebruiker {
    private String naam;
    private String wachtwoord;
    private boolean isAdmin;
    private ArrayList<Ritten> ritten = new ArrayList<rit>();
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
    


    public Gebruiker(String naam, Integer gebruikerNummer, String wachtwoord, boolean isAdmin){
        this.naam = naam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;

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

    public Boolean getIsAdmin() {return isAdmin;}

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
                "IsAdmin = " + isAdmin + "\n";
    }
}