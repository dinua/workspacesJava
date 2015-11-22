package medweb.psconf.connection.internal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import medweb.psconf.connection.ConnectionI;



public class ConnectionImpl implements ConnectionI{

	private PreparedStatement statement;
	private Connection con;
	private ResultSet result;
	
	public ConnectionImpl(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medweb","root","root");
		    statement = con.prepareStatement("");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String table,String values){
		String sql="insert into "+table+ " values ( "+values+" )";
	   	try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insert(String query) {
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ResultSet selectAll(String table){
		try {
			result = statement.executeQuery("SELECT * FROM "+table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public ResultSet select(String query) {
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ResultSet select(String table,String elem){
		try {
			result = statement.executeQuery("select "+elem+" from "+table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ResultSet select(String table,String elem,String restiction){
		try {
			result = statement.executeQuery("select "+elem+" from "+table +" WHERE "+restiction);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public ResultSet selectAll(String table, String restiction) {
		try {
			result = statement.executeQuery("SELECT * FROM "+table +" WHERE "+restiction);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void update(String query) {
		
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update(String table,String setValues,String restirction){
		String sql= "UPDATE "+table+" SET "+setValues+" WHERE "+restirction+";";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAll(String table){
		String sql="DELETE FROM "+table;
	   	try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String table,String restiction){
		String sql="DELETE FROM "+table+ " WHERE "+restiction;
	   	try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	

	
}
