
package getlandestate.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    // Connection: Veritabanına bağlanmak için kullanılır
    private static Connection connection;
    // Statement: Sorgu yazmak için kullanılır
    private static Statement statement;
    // ResultSet: Veritabanı işlemleri yapmak, belirli satırlara gitmek, verileri almak için kullanılır
    private static ResultSet resultSet;

    /**
     * Belirtilen veritabanına bağlantı sağlar.
     *
     * @return Veritabanı bağlantısı
     *
     * Kullanım:
     * Connection conn = DBUtils.connectToDatabase();
     */
    public static Connection connectToDatabase() {
        String url = "jdbc:postgresql://64.227.123.49:5432/prettierhomes";
        String username = "techprotester";
        String password = "myPassword";
        /*
        String url = "jdbc:postgresql://medunna.com:5432/medunna_db_v2";
        String username = "select_user";
        String password = "Medunna_pass_@6";

         */
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



    public static void createConnection() {
        String url = "jdbc:postgresql://64.227.123.49:5432/prettierhomes";
        String user = "techprotester";
        String password = "myPassword";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Veritabanı bağlantısı üzerinden bir Statement nesnesi oluşturur.
     *
     * @return Oluşturulan Statement nesnesi
     */
    public static Statement createStatement() {
        try {
            statement = connectToDatabase().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    /**
     * Belirtilen SQL sorgusunu çalıştırır ve sonucu ResultSet olarak döner.
     *
     * @param sql Çalıştırılacak SQL sorgusu
     * @return Sorgu sonucu ResultSet nesnesi
     */
    public static ResultSet executeQuery(String sql) {
        try {
            resultSet = createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * Veritabanı bağlantısını, Statement ve ResultSet nesnelerini kapatır.
     */
    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Veritabanındaki bir tablodaki satır sayısını döner.
     *
     * @return Satır sayısı
     * @throws Exception
     *
     * Kullanım:
     * int rowCount = DBUtils.getRowCount();
     */
    public static int getRowCount() throws Exception {
        resultSet.last();
        int rowCount = resultSet.getRow();
        return rowCount;
    }

    /**
     * Verilen sorgunun tek bir hücre değerini döner. Sorgu birden fazla satır ve/veya
     * sütun sonucu döndürse bile, yalnızca ilk satırın ilk sütunu döner.
     *
     * @param query Çalıştırılacak sorgu
     * @return Tek bir hücre değeri
     *
     * Kullanım:
     * Object cellValue = DBUtils.getCellValue("SELECT column_name FROM table_name");
     */
    public static Object getCellValue(String query) {
        return getQueryResultList(query).get(0).get(0);
    }

    /**
     * Verilen sorgunun ilk satırını döner. Sorgu birden fazla satır ve/veya sütun
     * sonucu döndürse bile, yalnızca ilk satır döner.
     *
     * @param query Çalıştırılacak sorgu
     * @return İlk satırın verileri
     *
     * Kullanım:
     * List<Object> rowList = DBUtils.getRowList("SELECT * FROM table_name");
     */
    public static List<Object> getRowList(String query) {
        return getQueryResultList(query).get(0);
    }

    /**
     * Verilen sorgunun ilk satırını bir map olarak döner. Map'in anahtarları sütun
     * isimleri, değerleri ise hücre değerleridir. Sorgu birden fazla satır ve/veya
     * sütun sonucu döndürse bile, yalnızca ilk satır döner.
     *
     * @param query Çalıştırılacak sorgu
     * @return İlk satırın verilerini içeren map
     *
     * Kullanım:
     * Map<String, Object> rowMap = DBUtils.getRowMap("SELECT * FROM table_name");
     */
    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }

    /**
     * Verilen sorgunun sonucunu liste içinde liste olarak döner. Dış liste satırları,
     * iç listeler ise tek bir satırı temsil eder.
     *
     * @param query Çalıştırılacak sorgu
     * @return Sorgu sonucunu içeren liste
     *
     * Kullanım:
     * List<List<Object>> queryResultList = DBUtils.getQueryResultList("SELECT * FROM table_name");
     */
    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    /**
     * Verilen sorgunun sonucunda belirtilen sütunun verilerini liste olarak döner.
     *
     * @param query Çalıştırılacak sorgu
     * @param column Sütun ismi
     * @return Sütun verilerini içeren liste
     *
     * Kullanım:
     * List<Object> columnData = DBUtils.getColumnData("SELECT * FROM table_name", "column_name");
     */
    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    /**
     * Verilen sorgunun sonucunu liste içinde map olarak döner. Liste satırları,
     * map ise sütun isimleri ve değerlerini temsil eder.
     *
     * @param query Çalıştırılacak sorgu
     * @return Sorgu sonucunu içeren liste
     *
     * Kullanım:
     * List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("SELECT * FROM table_name");
     */
    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    /**
     * Sorgu sonucunda dönen sütun isimlerinin listesini döner.
     *
     * @param query Çalıştırılacak sorgu
     * @return Sütun isimlerini içeren liste
     *
     * Kullanım:
     * List<String> columnNames = DBUtils.getColumnNames("SELECT * FROM table_name");
     */
    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }


    //  Veritabanındaki tablo isimlerini döner.

    /**
     * This method returns the list of table names in the "public" schema.
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, "public", "%", new String[] { "TABLE" });
            while (tables.next()) {
                tableNames.add(tables.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableNames;
    }

    /**
     * Belirtilen SQL güncelleme sorgusunu çalıştırır ve etkilenen satır sayısını döner.
     *
     * @param sql Çalıştırılacak SQL sorgusu
     * @return Etkilenen satır sayısı
     */
    public static int executeUpdate(String sql) {
        int affectedRows = 0;
        try {
            statement = connection.createStatement();
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(statement, resultSet);
        }
        return affectedRows;
    }

    // Close resources method
    private static void closeResources(Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        //Mukaddes ekledi .Aciklamayi chatgbt ye sordum
    /**
     * ResultSet'ten bir satırdaki tüm sütun verilerini alır ve bir liste olarak döner.
     *
     * @param resultSet Verilerin alındığı ResultSet nesnesi
     * @param columnCount Satırdaki sütun sayısı
     * @return Satırdaki sütun verilerini içeren liste
     * @throws SQLException Eğer ResultSet'ten veri alınırken bir hata oluşursa
     */

    public static List<String> getRowData(ResultSet resultSet, int columnCount) throws SQLException {
        List<String> row = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            row.add(resultSet.getString(i));
        }
        return row;
    }

    /**
     * Bu metot, verilen ResultSet nesnesindeki sütun sayısını döndürür.
     *
     * @param resultSet Sütun sayısının alınacağı ResultSet nesnesi
     * @return ResultSet'teki sütun sayısı
     */

    public static int getColumnCount(ResultSet resultSet) {
        int columnCount = 0;
        try {
            columnCount = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnCount;
    }
}

