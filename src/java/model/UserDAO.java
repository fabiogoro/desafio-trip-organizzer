package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO {
    private DBCollection table;

    public UserDAO() {
        MongoClient mongo = MongoFactory.getConnection();
        DB teste = mongo.getDB("desafio-trip-organizzer");
        table = teste.getCollection("user");
    }
  
    public void insert(User u){
        BasicDBObject document = new BasicDBObject();
        document.put("name", u.getNome());
        document.put("email", u.getEmail());
        document.put("senha", u.getSenha());
        table.insert(document);
    }
    
    public void update(User u){
        BasicDBObject query = new BasicDBObject();
        query.put("name", u.getNome());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("email", u.getEmail());
        newDocument.put("senha", u.getSenha());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
    }
    
    public List<User> select(User u){
        List<User> res = new ArrayList<User>();
	BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.put("name", u.getNome());
 
	DBCursor cursor = table.find(searchQuery);
 
	while (cursor.hasNext()) {
            DBObject i = cursor.next();
            User newU = new User();
            newU.setNome((String) i.get("name"));
            newU.setEmail((String) i.get("email"));
            newU.setSenha((String) i.get("senha"));
            res.add(newU);
	}
        
        return res;
    }
    
    public void delete(User u){
        BasicDBObject searchQuery = new BasicDBObject();
	searchQuery.put("name", u.getNome());
 
	table.remove(searchQuery);
    }
}
