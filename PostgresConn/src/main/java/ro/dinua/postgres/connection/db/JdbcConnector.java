package main.java.ro.dinua.postgres.connection.db;

/**
 * Created by adrian.dinu on 11/22/2015.
 */

        import java.sql.*;

/**
 * Created by adrian.dinu on 11/22/2015.
 */
public class JdbcConnector {

    public static void main(String[] argv) throws SQLException {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.99.100:5432/dabbawala", "postgres",
                    "pentaho");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        // EXTRA TEXT MASTER

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM test_table where id_int=1");
        while (rs.next()) {
            System.out.println(rs.getInt(1)+"    " + rs.getFloat(2)+"     "+rs.getString(3)+"       "+rs.getDate(4));
        }

        // New Text in branch 1

        rs.close();
        st.close();

        ///EXTRA TEXT IN BRANCH
    }
}


