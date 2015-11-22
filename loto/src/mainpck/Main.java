package mainpck;

import java.util.Iterator;

import loto.bs.LotoBusinessService;
import loto.psconf.Extragere6;
import loto.psconf.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		select();
	}

	public static void select(){
		 Session session = null;

		  try{
		  
			  session = HibernateUtil.getSessionFactory().openSession();
		 
		  //Create Select Clause HQL
		 String SQL_QUERY ="Select ex from Extragere6 ex";
		 Query query = session.createQuery(SQL_QUERY);
		 Iterator<Extragere6> ita=query.iterate();
		 while(ita.hasNext()){
			 Extragere6 e=ita.next();
			 System.out.println(e.toString());
		 }
		
		 
		  session.close();
		  }catch(Exception e){
		  System.out.println(e.getMessage());
		  }finally{
		  }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Main();
	}

}
