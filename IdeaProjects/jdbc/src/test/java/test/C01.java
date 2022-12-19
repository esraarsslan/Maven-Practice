package test;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C01 {

    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


    @Test
    public void test01() throws SQLException {

        String hostname = "localhost";
        String dbIsim = "Databasetesting";
        String username= "postgres";
        String password = "123456";

       // 1.ADM;;; connection olusturcaz

        DBUtils.connectionOlustur(hostname, dbIsim, username, password);

       // 2.ADIM::: statenment olusturma

        Statement st = DBUtils.statementOlustur();
        // 3.ADIM:: query olustur

        String query = "SELECt isim from ogrenciler;";

        // 4.ADIM: query calistir

        ResultSet rs = st.executeQuery(query);
        List<String> isimler = new ArrayList<>();

        while (rs.next()){
            isimler.add(rs.getString(1));
        }
        Assert.assertTrue(isimler.contains("Merve Gul"));
    }
}
