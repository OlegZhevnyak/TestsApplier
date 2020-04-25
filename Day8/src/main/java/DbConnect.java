import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.exceptions.MySQLTimeoutException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnect {

    static Properties properties = getProperties();

    public static void main(String[] args) throws SQLException {
        Properties prop = getProperties();
        prop.forEach((k, v) -> System.out.println(v.toString()));
        String query = "SHOW TABLES";
        executeStatement(query);
    }

    private static Properties getProperties() {

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("Day8/src/main/resources/db.properties")) {

            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    private static MysqlDataSource getDatasource(Properties Drop) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(getProperties().getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(getProperties().getProperty("PORT")));
        dataSource.setUser(getProperties().getProperty("USER"));
        dataSource.setPassword(getProperties().getProperty("PWD"));
        dataSource.setDatabaseName(getProperties().getProperty("DBNAME"));
        return dataSource;
    }

    private static void executeStatement(String query) throws SQLException {
        try {
            Connection connection = getDatasource(properties).getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
