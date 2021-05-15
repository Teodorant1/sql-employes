package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SqlMinion {





        static String IP = "localhost";
        static String USER = "root";
        static String PASS = "root";
        static String DB_URL = "jdbc:mysql://localhost:3306/sonoo";

        public SqlMinion() {
        }

        // Podaci koje je potrebno čuvati su: ime, broj godina, adresa i visina dohotka.
    // Potrebno je omogućiti snimanje, čitanje, izmenu i brisanje podataka o zaposlenima.
    //
    //Neophodno je da aplikacija ima sledeće funkcionalnosti:
    //
    //unos novog zaposlenog u bazu;
    //izmena podataka o zaposlenom na osnovu ID-ja;
    //brisanje zaposlenog na osnovu ID-ja;
    //prikaz svih zaposlenih iz baze;
    //prikaz samo određenih zaposlenih iz baze po nekom od kriterijuma koji nije ID (npr. po imenu, broju godina, adresi ili visini dohotka).

        public void insertworker(String name, int age, String adress, int income) throws SQLException {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement bullet1 = conn.prepareStatement("INSERT INTO employees (name, age, adress, income) VALUES (?, ?, ?, ?)");
            bullet1.setString(1, name);
            bullet1.setString(2, String.valueOf(age));
            bullet1.setString(3, adress);
            bullet1.setString(4, String.valueOf(income));

            bullet1.executeUpdate();
            System.out.println("Uploading the thing");
            conn.close();
            System.out.println("Thing uploaded!");
        }

    public void changeworker(int id , String target, String payload) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        PreparedStatement bullet1 = null ;
        if (target.equals("age")) {bullet1 = conn.prepareStatement("UPDATE EMPLOYEES SET age = ? WHERE id = ? ");}
        else if (target.equals("adress")){bullet1 = conn.prepareStatement("UPDATE EMPLOYEES SET adress = ? WHERE id = ? ");}
        else if (target.equals("name")){bullet1 = conn.prepareStatement("UPDATE EMPLOYEES SET name = ? WHERE id = ? ");}
        else if (target.equals("income")){bullet1 = conn.prepareStatement("UPDATE EMPLOYEES SET income = ? WHERE id = ? ");}
        bullet1.setString(1, payload);
        bullet1.setString(2, String.valueOf(id));
        bullet1.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");
    }
public void deleteemployee (int id) throws SQLException { Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

    PreparedStatement bullet1 = conn.prepareStatement("DELETE FROM EMPLOYEES WHERE id = ?");
    bullet1.setString(1, String.valueOf(id));

    bullet1.executeUpdate();
    System.out.println("Uploading the thing");
    conn.close();
    System.out.println("Thing uploaded!"); }

    public String pullEveryone() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        PreparedStatement bullet1 = conn.prepareStatement("SELECT * FROM EMPLOYEES ");
        ResultSet rs = bullet1.executeQuery();
        ArrayList<worker> arrayList1 = new ArrayList();

        while (rs.next())
        {
            arrayList1.add( new worker(rs.getString("name"), String.valueOf(rs.getInt("age")), rs.getString("adress"), String.valueOf(rs.getInt("income")) ));}

        conn.close();
//        return arrayList1.get(0);

        StringBuilder endgamepaloki = new StringBuilder(" ");
        if ( arrayList1.size() > 0) {
            for (int i = 0; i < arrayList1.size(); i++) {
                endgamepaloki.append(" " + arrayList1.get(i).cannibalclown() +  " ");
            }
        }

        return String.valueOf(endgamepaloki);
    }

    public String pullsomeone( String filter, String criteria  ) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        String select = "SELECT * FROM EMPLOYEES";
        PreparedStatement bullet1 = conn.prepareStatement(select);
        ResultSet rs = bullet1.executeQuery();
        ArrayList<worker> arrayList1 = new ArrayList();

        while (rs.next())
        {
            arrayList1.add( new worker(rs.getString("name"), String.valueOf(rs.getInt("age")), rs.getString("adress"), String.valueOf(rs.getInt("income")) ));}

        conn.close();

        //     public worker(String name, String age, String adress, String income)

        StringBuilder endgamepaloki = new StringBuilder(" ");
        if ( arrayList1.size() > 0) {
            for (int i = 0; i < arrayList1.size(); i++) {
                if (filter.equals("name"))
                { if (criteria.equals(arrayList1.get(i).getName()))
                { endgamepaloki.append(" " + arrayList1.get(i).getName());}}

               else if (filter.equals("age"))
                { if (criteria.equals(arrayList1.get(i).getAge()))
                { endgamepaloki.append(" " + arrayList1.get(i).getAge());}}

               else if (filter.equals("adress"))
                { if (criteria.equals(arrayList1.get(i).getAdress()))
                { endgamepaloki.append(" " + arrayList1.get(i).getAdress());}}

               else if (filter.equals("income"))
                { if (criteria.equals(arrayList1.get(i).getIncome()))
                { endgamepaloki.append(" " + arrayList1.get(i).getIncome());}}
            }
        }
        return String.valueOf(endgamepaloki);
    }
}
