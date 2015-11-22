package medweb.psconf.connection;

import java.sql.ResultSet;

public interface ConnectionI {

	 void insert(String table,String values);
	 void insert(String query);
	 ResultSet select(String query);
	 ResultSet selectAll(String table);
	 ResultSet select(String table,String elem);
	 ResultSet select(String table,String elem,String restiction);
	 ResultSet selectAll(String table,String restiction);
	 void update(String query);
	 void update(String table,String setValues,String restirction);
	 void deleteAll(String table);
	 void delete(String table,String restiction);
}
