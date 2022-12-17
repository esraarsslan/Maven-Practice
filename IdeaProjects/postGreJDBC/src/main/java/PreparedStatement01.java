import java.nio.channels.IllegalBlockingModeException;
import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
        Statement st = con.createStatement();

        /**
         * PreparedStatement01 interface' birden cok kez calistirilabilen onceden derlenmis bir sql kodunu temsil eder.
         * Parametrelendirilmis SQL sorgulari ||(query) ile calisir.
         */

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin...
        // 1.adim : PreparedStatement query' sini olustur.

        String sql1= "UPDATE companies, SET number_of_employees= ? WHERE company = ?";

        // 2. ADIM:  PreparedStatement objesini olustur.

        PreparedStatement pst1 = con.prepareStatement(sql1);

        // 3. ADIM: setInt (),  setString(), ... methodlarini kullanarak soru isareleri yerine deger gir.

        pst1.setInt(1, 9999);

        pst1.setString(2, "IBM");

        // 4. ADIM: Query'i calistir.

        int guncellenenSAtirSayisi =  pst1.executeUpdate();

        System.out.println("guncellenenSAtirSayisi = " + guncellenenSAtirSayisi);
    }

}
