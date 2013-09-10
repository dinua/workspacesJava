package loto.ps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import loto.psconf.Extragere6;
import loto.psconf.HibernateUtil;

public class LotoPersistenceService {

	public List<Extragere6> selectAllExtrageri6(){
		List<Extragere6> list=new ArrayList<Extragere6>(); 
		Session session = null;
		  try{
			  session = HibernateUtil.getSessionFactory().openSession();
		  //Create Select Clause HQL
		 String SQL_QUERY ="Select ex from Extragere6 ex order by data asc";
		 Query query = session.createQuery(SQL_QUERY);
		 
		 list=(List<Extragere6>) query.list();
		  session.close();
		  }catch(Exception e){
		  System.out.println(e.getMessage());
		  }finally{
		  }
		  return list;
	}
}
