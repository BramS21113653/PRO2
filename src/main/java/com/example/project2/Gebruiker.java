import java.util.*;
import java.sql.*;

public class Gebruiker {
    private Integer id;
    private String naam;
    private String wachtwoord;
    private boolean isAdmin;
    private ArrayList<Ritten> ritten = new ArrayList<rit>();
    public static ArrayList<Gebruiker> gebruikerslijst = new ArrayList<Gebruiker>();
    


    public Gebruiker(Integer id, String naam, String wachtwoord, boolean isAdmin){
        //vvvv idk of dit nodig is vvvv\\
        // this.id = id;
        // this.naam = naam;
        // this.wachtwoord = wachtwoord;
        // this.isAdmin = isAdmin;
        //^^^^ idk of dit nodig is ^^^^\\
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/betabit";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        //gegevens invoeren in database
        // the mysql insert statement
        String query = " insert into gebruiker (id, naam, wachtwoord, isadmin)"
                + " values (?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (2, naam);
        preparedStmt.setString   (3, wachtwoord);
        preparedStmt.setInt(4, isAdmin);

        preparedStmt.execute();

        conn.close();
        refreshGebruikerslijst()
    }


    public void refreshGebruikerslijst(){
        //gebruikerslijst legen
        //database tabellen inlezen
        //gebruikers maken van database gegevens
        //gebruikerslijst invullen
    }

    public static ArrayList<Gebruiker> getGebruikersLijst() {
        return gebruikerslijst;
    }

    public String getNaam() {
        return naam;
    }

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