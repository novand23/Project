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
//            statement.execute("INSERT INTO usrs(id, name) VALUES (5, 'Igor2');");
//            statement.execute("INSERT INTO usrs(id, name) VALUES (6, 'Igor3');");

//            int i = statement.executeUpdate("UPDATE usrs SET name='Igor1' WHERE id = 1;");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM usrs");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
