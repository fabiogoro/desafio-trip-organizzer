package model;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class MongoFactory {
    
    public static MongoClient getConnection() {
        try {
            String textUri = "mongodb://trip-organizzer:1234@ds049568.mongolab.com:49568/desafio-trip-organizzer";
            MongoClientURI uri = new MongoClientURI(textUri);
            MongoClient m = new MongoClient(uri);
            return m;
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
