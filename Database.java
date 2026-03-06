package Algoritmafinal;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection baglan() {
        try {
            // "localhost" senin bilgisayarın, "1433" SQL portu
            // "sa" kullanıcı adın, "Sifre123" SQL kurulumunda belirlediğin şifre
            String url = "jdbc:sqlserver://localhost:1433;databaseName=PoliceMDC;encrypt=true;trustServerCertificate=true;";
            return DriverManager.getConnection(url, "sa", "Sifre123"); 
        } catch (Exception e) {
            System.out.println("Bağlantı Hatası: " + e.getMessage());
            return null;
        }
    }
}