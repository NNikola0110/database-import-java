package model.utility;

import model.*;
import model.base.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    private static Connection connection=null;

    public static void connect(){
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/svemir", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Korisnik> selectAllFromKorisnik() {
        List<Korisnik> korisnici = new ArrayList<>();
        String query = "select * from korisnik";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int korisnik_id = resultSet.getInt(1);
                String ime_korisnika = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                String username = resultSet.getString(4);
                String pasword = resultSet.getString(5);
                Korisnik korisnik = new Korisnik(korisnik_id, ime_korisnika, prezime, username,pasword);
                korisnici.add(korisnik);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return korisnici;
    }


    public static List<Korisnik> selectFromKorisnik(String username, String password){
        List<Korisnik> oldPeople = selectAllFromKorisnik();
        Server.SERVER.setKorisnici(oldPeople);
        List<Korisnik> korisnici = new ArrayList<>();
        for (Korisnik oldPerson : oldPeople) {
            /*if (yearOfBirth == null || yearOfBirth.length() != 4) {
                if (oldPerson.getFirstName().toLowerCase().contains(firstName.toLowerCase())
                        && oldPerson.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                    people.add(oldPerson);
                continue;
            }
            if (oldPerson.getFirstName().toLowerCase().contains(firstName.toLowerCase())
                    && oldPerson.getLastName().toLowerCase().contains(lastName.toLowerCase())
                    && oldPerson.getDateOfBirth().getYear() == Integer.parseInt(yearOfBirth))
                people.add(oldPerson);*/
        }
        return korisnici;
    }

    public static void insertIntoKorisnik(String ime_korisnika, String prezime, String username, String pasword) {
        String query = "insert into korisnik (ime_korisnika, prezime, username, pasword)" +
                "values (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, ime_korisnika);
            statement.setString(2, prezime);
            statement.setString(3, username);
            statement.setString(4,pasword);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public static boolean proveriKorisnika(String username, String password) {
            String query = "SELECT * FROM Korisnik WHERE username = ? AND pasword = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        // Method to fetch all habitable planets
        public static List<Planeta> getHabitablePlanets() {
            List<Planeta> planets = new ArrayList<>();
            String query = "SELECT * FROM Planeta WHERE nastanjivost = TRUE";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Planeta planeta = new Planeta(
                            rs.getInt("planeta_id"),
                            rs.getString("ime_planete"),
                            rs.getFloat("udaljenost_od_zvezde"),
                            rs.getFloat("min_temperatura"),
                            rs.getFloat("max_temperatura"),
                            rs.getFloat("procenat_kiseonika"),
                            rs.getFloat("procenat_gasa"),
                            rs.getFloat("max_grav"),
                            rs.getFloat("brzina_orbitiranja"),
                            rs.getInt("smrtnost"),
                            rs.getBoolean("nastanjivost")
                    );
                    planets.add(planeta);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return planets;
        }

        /*public static List<Misija> getMissionsByPlanetId(int planetaId) {
            List<Misija> missions = new ArrayList<>();
            String query = "SELECT * FROM Misija WHERE planeta_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, planetaId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Misija misija = new Misija(
                            rs.getInt("misija_id"),
                            rs.getInt("planeta_id"),
                            rs.getDate("datum_misije"),
                            rs.getString("opis")
                    );
                    missions.add(misija);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return missions;
        }*/


        public static List<Objekat> getObjectsByPlanetId(int planetaId) {
            List<Objekat> objects = new ArrayList<>();
            String query = "SELECT * FROM Objekat WHERE planeta_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, planetaId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Objekat objekat = new Objekat(
                            rs.getInt("objekat_id"),
                            rs.getInt("planeta_id"),
                            rs.getString("adresa"),
                            rs.getInt("kapacitet"),
                            rs.getFloat("cena")
                    );
                    objects.add(objekat);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return objects;
        }

        public static void registerPurchase(int korisnikId, int objekatId, Date datumKupovine) {
            String query = "INSERT INTO Kupovina (korisnik_id, objekat_id, datum_kupovine) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, korisnikId);
                pstmt.setInt(2, objekatId);
                pstmt.setDate(3, datumKupovine);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to register a trip
        public static void registerTrip(int kupovinaId, Date datumPolaska, String sifra) {
            String query = "INSERT INTO Putovanje (kupovina_id, datum_polaska, sifra) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, kupovinaId);
                pstmt.setDate(2, datumPolaska);
                pstmt.setString(3, sifra);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to fetch purchases by user ID
        public static List<Kupovina> getPurchasesByUserId(int korisnikId) {
            List<Kupovina> purchases = new ArrayList<>();
            String query = "SELECT * FROM Kupovina WHERE korisnik_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, korisnikId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Kupovina kupovina = new Kupovina(
                            rs.getInt("kupovina_id"),
                            rs.getInt("korisnik_id"),
                            rs.getInt("objekat_id"),
                            rs.getDate("datum_kupovine").toLocalDate()
                    );
                    purchases.add(kupovina);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return purchases;
        }

        // Method to fetch trips by purchase ID
        public static List<Putovanje> getTripsByPurchaseId(int kupovinaId) {
            List<Putovanje> trips = new ArrayList<>();
            String query = "SELECT * FROM Putovanje WHERE kupovina_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, kupovinaId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Putovanje putovanje = new Putovanje(
                            rs.getInt("putovanje_id"),
                            rs.getInt("kupovina_id"),
                            rs.getDate("datum_polaska").toLocalDate(),
                            rs.getString("sifra")
                    );
                    trips.add(putovanje);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return trips;
        }





    private JDBCUtils() {
    }
}
