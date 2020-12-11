package kata5persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kata5model.Mail;

public class MailDatabaseReader {

    public static List<Mail> read(String databaseName) throws SQLException, ClassNotFoundException {
        List<Mail> list = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/" + databaseName);
                Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery("SELECT * FROM people");
            while(set.next()) {
                String email = set.getString("email");
                if (email == null) break;
                if(Mail.isMail(email)) {
                    list.add(new Mail(email));
                }
            }
        }
        return list;
 
    }
   
}
