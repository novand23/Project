import java.sql.*;

public class Main {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "12345";


    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            /*statement.execute("INSERT INTO table1(id, name) VALUES (1, 'Andrew');");*/

//            statement.addBatch("INSERT INTO table1(id, name) VALUES (3, 'Andrew');");
//            statement.addBatch("INSERT INTO table1(id, name) VALUES (4, 'Andrew');");
//            statement.addBatch("INSERT INTO table1(id, name) VALUES (5, 'Andrew');");
//            statement.addBatch("INSERT INTO table1(id, name) VALUES (6, 'Andrew');");
//            statement.executeBatch();
//            statement.clearBatch();

            statement.execute("DELETE FROM table1 WHERE id = 2");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM table1");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            }

//            PreparedStatement ps = connection.prepareStatement("INSERT INTO table1(id, name) VALUES (?, ?);");
//            ps.setInt(1, 2);
//            ps.setString(2, "Alex");
//            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
