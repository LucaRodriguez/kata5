package kata5;
import java.sql.*;
import kata5View.HistogramDisplay;
import kata5View.MailHistogramBuilder;
import kata5persistence.MailDatabaseReader;
import kata5model.Histogram;
import kata5model.Mail;
import java.util.List;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String databaseName = "US500.db";
        List<Mail> mailList = MailDatabaseReader.read(databaseName);

        Histogram<String> histogram = MailHistogramBuilder.build(mailList);

        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM", histogram);
        histogramDisplay.execute(); 
        
        
    }
    
}
