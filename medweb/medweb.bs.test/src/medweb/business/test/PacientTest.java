package medweb.business.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import medweb.businessService.exceptions.BusinessSQLException;
import medweb.businessService.internal.BusinessServiceImpl;
import medweb.persitence.PersistenceService;
import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.CategorieAsigurat;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;

public class PacientTest {
  
	@Test
	public void testGetPacientByID1() throws  BusinessSQLException, SQLException {
	   	PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
		
          Pacient pacient=createDummyPatient(2, "Ion", "Vasile");
	   	  
	   	 Mockito.when(persistence.getPatientByID(2)).thenReturn(pacient);
	   	 Pacient result=bService.getPatientByID(2);
	   	  
	   	 Assert.assertEquals(pacient.getIdPacient(), result.getIdPacient());
	
	   
	}
	@Test(expected = BusinessSQLException.class) 
	public void testGetPacientByID2() throws SQLException, BusinessSQLException{
	   	PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
		
   
	   	 Mockito.doThrow(new SQLException()).when(persistence).getPatientByID(2);
	   	 bService.getPatientByID(2);
	 
	}
	@Test
	public void testGetInfoPacient1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	Pacient pacient=createDummyPatient(1, "Ion", "Vasile");
	   	String cnp="1234567891234";
	   	PacientInfo info=new PacientInfo();
	   	info.setCnp(cnp);
	   	
	   	Mockito.when(persistence.getInfoPacient(pacient)).thenReturn(info);
	   	PacientInfo result=bService.getInfoPacient(pacient);
	   	
	   	Assert.assertEquals(info.getCnp(), result.getCnp());
	}
	
	@Test(expected = BusinessSQLException.class) 
	public void testGetInfoPacient2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
		
	   	Pacient pacient=createDummyPatient(1, "Ion", "Vasile");
	    Mockito.doThrow(new SQLException()).when(persistence).getInfoPacient(pacient);
	    bService.getInfoPacient(pacient);
	   	
	}
	@Test
	public void testGetAllLightPatients1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	List<Pacient> list=new ArrayList<Pacient>();
	   	list.add(createDummyPatient(1, "name1", "vorname1"));
	   	list.add(createDummyPatient(2, "name2", "vorname2"));
	   	
	   	Mockito.when(persistence.getAllPatientsLight()).thenReturn(list);
	   	List<Pacient>result=bService.getAllLightPatients();
	   	
	   	Assert.assertEquals(list.size(), result.size());
	   	
	   	  	
	}
	@Test(expected = BusinessSQLException.class) 
	public void testGetAllLightPatients2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	    
	   	Mockito.doThrow(new SQLException()).when(persistence).getAllPatientsLight();
	   	bService.getAllLightPatients();
	}
	@Test
	public void testGetAllActivPatientsForMedic1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
		List<Pacient> list=new ArrayList<Pacient>();
	   	list.add(createDummyPatient(1, "name1", "vorname1"));
	   	list.add(createDummyPatient(2, "name2", "vorname2"));
	   	
	   	Mockito.when(persistence.getAllActivPatientsForMedic(1)).thenReturn(list);
	   	List<Pacient> result=bService.getAllActivPatientsForMedic(1);
	   	
	   	Assert.assertEquals(list.size(), result.size());
	   	
	}
	@Test(expected = BusinessSQLException.class) 
	public void testGetAllActivPatientsForMedic2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	Mockito.doThrow(new SQLException()).when(persistence).getAllActivPatientsForMedic(1);
	   bService.getAllActivPatientsForMedic(1);
	   	
	}
	
	@Test
	public void testGetAllInactivPatientsForMedic1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
		List<Pacient> list=new ArrayList<Pacient>();
	   	list.add(createDummyPatient(1, "name1", "vorname1"));
	   	list.add(createDummyPatient(2, "name2", "vorname2"));
	   	
	   	Mockito.when(persistence.getAllInactivPatientsForMedic(1)).thenReturn(list);
	   	List<Pacient> result=bService.getAllInactivPatientsForMedic(1);
	   	
	   	Assert.assertEquals(list.size(), result.size());
	   	
	}
	@Test(expected = BusinessSQLException.class) 
	public void testGetAllInactivPatientsForMedic2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	Mockito.doThrow(new SQLException()).when(persistence).getAllInactivPatientsForMedic(1);
	   bService.getAllInactivPatientsForMedic(1);
	   	
	}
	
	@Test
	public void testSavePacient1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	 	Pacient pacient=createDummyPatient(1, "Ion", "Vasile");
	 	CategorieAsigurat categorie=new CategorieAsigurat();
	 	categorie.setNume("nameCat");
	 	CasaAsigurari casa=new CasaAsigurari();
	 	casa.setNume("nameCasa");
	 	pacient.setCasaAsigurari(casa);
	 	pacient.setCategorieAsigurat(categorie);
	 	
	 	Mockito.when(persistence.getCategorieAsiguratByName(categorie.getNume())).thenReturn(categorie);
	 	Mockito.when(persistence.getCasaAsigurariByName(casa.getNume())).thenReturn(casa);
	 	Mockito.when(persistence.savePatient(pacient)).thenReturn(pacient.getIdPacient());
	   	
	 	int result=bService.savePatient(pacient);
	 	Assert.assertEquals(pacient.getIdPacient(), result);
	}
	@Test(expected = BusinessSQLException.class)
	public void testSavePacient2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	Pacient pacient=createDummyPatient(1, "Ion", "Vasile");
	   	CategorieAsigurat categorie=new CategorieAsigurat();
	 	categorie.setNume("nameCat");
	 	CasaAsigurari casa=new CasaAsigurari();
	 	casa.setNume("nameCasa");
	 	pacient.setCasaAsigurari(casa);
	 	pacient.setCategorieAsigurat(categorie);
	 	
	 	Mockito.when(persistence.getCategorieAsiguratByName(categorie.getNume())).thenReturn(categorie);
	 	Mockito.when(persistence.getCasaAsigurariByName(casa.getNume())).thenReturn(casa);
		Mockito.doThrow(new SQLException()).when(persistence).savePatient(pacient);
		bService.savePatient(pacient);
	}
	@Test
	public void testUpdatePacient1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	Pacient pacient=createDummyPatient(1, "Ion", "Vasile");
	   	CategorieAsigurat categorie=new CategorieAsigurat();
	 	categorie.setNume("nameCat");
	 	CasaAsigurari casa=new CasaAsigurari();
	 	casa.setNume("nameCasa");
	 	pacient.setCasaAsigurari(casa);
	 	pacient.setCategorieAsigurat(categorie);
	 	
	 	Mockito.when(persistence.getCategorieAsiguratByName(categorie.getNume())).thenReturn(categorie);
	 	Mockito.when(persistence.getCasaAsigurariByName(casa.getNume())).thenReturn(casa);
	   	Mockito.when(persistence.updatePatient(pacient)).thenReturn(pacient.getIdPacient());
	   	int result=bService.updatePatient(pacient);
	   	
	   	Assert.assertEquals(pacient.getIdPacient(), result);
	   	
	}
	
	@Test(expected = BusinessSQLException.class)
	public void testUpdatePacient2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	Pacient pacient=createDummyPatient(1, "Ion", "Vasile");
	   	CategorieAsigurat categorie=new CategorieAsigurat();
	 	categorie.setNume("nameCat");
	 	CasaAsigurari casa=new CasaAsigurari();
	 	casa.setNume("nameCasa");
	 	pacient.setCasaAsigurari(casa);
	 	pacient.setCategorieAsigurat(categorie);
	 	
	 	Mockito.when(persistence.getCategorieAsiguratByName(categorie.getNume())).thenReturn(categorie);
	 	Mockito.when(persistence.getCasaAsigurariByName(casa.getNume())).thenReturn(casa);
		Mockito.doThrow(new SQLException()).when(persistence).updatePatient(pacient);
		bService.updatePatient(pacient);
	}
	@Test
	public void testSavePacientInfo1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	
	   	String cnp="1234567891234";
	   	PacientInfo info=new PacientInfo();
	   	info.setCnp(cnp);
	   	
	   	Mockito.when(persistence.savePatientInfo(info)).thenReturn(1);
	   	int result=bService.savePatientInfo(info);
	   	Assert.assertEquals(1, result);
	}
	@Test(expected = BusinessSQLException.class)
	public void testSavePacientInfo2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
		
	   	String cnp="1234567891234";
	   	PacientInfo info=new PacientInfo();
	   	info.setCnp(cnp);
	   	Mockito.doThrow(new SQLException()).when(persistence).savePatientInfo(info);
	   	bService.savePatientInfo(info);
	} 	
	@Test
	public void testUpdatePacientInfo1() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	String cnp="1234567891234";
	   	PacientInfo info=new PacientInfo();
	   	info.setCnp(cnp);
	   	
	   	Mockito.when(persistence.updatePatientInfo(info)).thenReturn(1);
	   	int result=bService.updatePatientInfo(info);
	   	Assert.assertEquals(1, result);
	   	
	}
	@Test(expected = BusinessSQLException.class)
	public void testUpdatePacientInfo2() throws SQLException, BusinessSQLException{
		PersistenceService persistence=Mockito.mock(PersistenceService.class); 
	   	BusinessServiceImpl bService=new BusinessServiceImpl(persistence);
	   	String cnp="1234567891234";
	   	PacientInfo info=new PacientInfo();
	   	info.setCnp(cnp);
	   	
	   	Mockito.doThrow(new SQLException()).when(persistence).updatePatientInfo(info);
	   	bService.updatePatientInfo(info);
	   	
	}
	
	
	/////////////////////////////////////////
	private Pacient createDummyPatient(int id,String nume,String prenume){
		Pacient pacient=new Pacient();
		pacient.setIdPacient(id);
		pacient.setNume(nume);
		pacient.setPrenume(prenume);
		
		return pacient;
	}

	
}
