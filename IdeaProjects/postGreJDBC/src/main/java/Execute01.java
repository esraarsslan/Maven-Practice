import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123456");

    Statement st = con.createStatement();

        System.out.println("Connection Success");

        /***
         * execute methodu DDL() ve DQL (create, drop. alter table) ve DQL (select) icin kullanailabilir.
         * 1) EGer execute methodu DDL icin kullanilirsa "false " return eder.
         * 2) EGer execute methodu DQL icin kullanilirsa  ResultSet alindiginda "True" aksi halde "false " return eder.
*/


        //1.Örnek: "workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.

        boolean sql1 = st.execute("CREATE TABLE workers (worker_id VARCHAR(20), worker_name VARCHAR(20), worker_salary INT)");
        System.out.println("sql1 = " + sql1);//false return eder çünkü data çağırmıyoruz.

        //2.Örnek: Table'a worker_address sütunu ekleyerek alter yapın.
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        //3.Örnek: workers table'ını silin.


        String sql3 = "Drop table workers";
         st.execute(sql3);

        //4. Adım: Query çalıştır.

        /*
        execute() methodu DDL(create, drop, alter table) ve DQL(select) için kullanılabilir.
        1) Eğer execute() methodu DDL için kullanılırsa 'false' return yapar.
        2) Eğer execute() methodu DQL için kullanılırsa ResultSet alındığında 'true' aksi hale 'false' verir.
         */

        //5. Adım: Bağlantı ve Statement'ı kapat.

        con.close();
        st.close();





    }
}
