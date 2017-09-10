package ro.sci.carrental.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ivett on 26-Aug-17.
 */
public abstract class BaseRepository {
   void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

    }

    protected Connection newConnection() {
        String type="postgresql";
        String host="localhost";
        String port="5432";
        String dbName="grp7";
        String user="postgres";
        String pw="admin";

        loadDriver();
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be
        try {
            String url = new StringBuilder().append("jdbc:").append(type) // “mysql”
                    .append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
                    .append(user).append("&password=").append(pw).toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }
}
