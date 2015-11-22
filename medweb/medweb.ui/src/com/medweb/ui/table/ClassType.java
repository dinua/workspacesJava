package com.medweb.ui.table;



import com.medweb.ui.administrare.UtilizatorMessages;
import com.medweb.ui.administrare.UtilizatorRow;
import com.medweb.ui.medic.MedicRowInformation;
import com.medweb.ui.medicamente.MedicamenteMessages;
import com.medweb.ui.pacient.PacientMessages;
import com.medweb.ui.pacient.PatientRowInformation;
import com.medweb.ui.retete.RetetaMessages;
import com.medweb.ui.retete.RowReteta;

import medweb.psconf.daos.Consult;
import medweb.psconf.daos.Medicament;
import medweb.psconf.daos.Pacient;

	public class ClassType {
		private String column;
		private String value;

 /**
  * Constructor used to get the value
  * @param element the object
  * @param column the column for the object
  * 
  */
		public ClassType(Object element,String column){
			super();
			this.column=column;
			if(element instanceof Test){
				Test test=(Test)element;
				setValue(getTextFromTest(test));
		       } 
			if(element instanceof Pacient){
				Pacient pacient=(Pacient)element;
				setValue(getTextFromPacient(pacient));
		       }
			if(element instanceof PatientRowInformation){
				PatientRowInformation patientRowInformation=(PatientRowInformation)element;
				setValue(getTextFromPatientRowInformation(patientRowInformation));
		       }
			if(element instanceof MedicRowInformation){
				MedicRowInformation medicRowInformation=(MedicRowInformation)element;
				setValue(getTextFromMedicRowInformation(medicRowInformation));
		       }
			if(element instanceof RowReteta){
				RowReteta rowReteta=(RowReteta)element;
				setValue(getTextFromRowReteta(rowReteta));
		       }
			if(element instanceof Consult){
				Consult consult=(Consult)element;
				setValue(getTextFromConsult(consult));
		       }
			if(element instanceof Medicament){
				Medicament medicament=(Medicament)element;
				setValue(getTextFromMedicament(medicament));
		       }
			if(element instanceof UtilizatorRow){
				UtilizatorRow utilizatorRow=(UtilizatorRow)element;
				setValue(getTextFromUtilizatorRow(utilizatorRow));
		       }
	}
		/**
		 * Constructor used to set a value
		 * @param element the object
		 * @param column the column 
		 * @param value the new value
		 */
		public ClassType(Object element,String column,String value){
			super();
			this.column=column;
			this.value=value;
				if(element instanceof Test){
					Test test=(Test)element;
					setTextToTest(test);
				}
				if(element instanceof Pacient){
					Pacient pacient=(Pacient)element;
					setTextToPacient(pacient);
				}
				if(element instanceof PatientRowInformation){
					PatientRowInformation patientRowInformation=(PatientRowInformation)element;
					setTextToPatientRowInformation(patientRowInformation);
				}
				if(element instanceof MedicRowInformation){
					MedicRowInformation medicRowInformation=(MedicRowInformation)element;
					setTextToMedicRowInformation(medicRowInformation);
				}
				if(element instanceof RowReteta){
					RowReteta rowReteta=(RowReteta)element;
					setTextToRowReteta(rowReteta);
				}
		}
	  
	private String getTextFromTest(Test test){
		  if(column.equals("Labell")){
	
			  return test.getText1();
			  }
		  if(column.equals("Value"))
			  return test.getText2();
		  if(column.equals("Valu2e"))
			  return test.getText3();
		  return "";
	  }	
	  private void setTextToTest(Test test){
		  if(column.equals("Labell"))
			  test.setText1(value);
		  if(column.equals("Value"))
			   test.setText2(value);
		  if(column.equals("Valu2e"))
			   test.setText3(value);
		 
	  }
//...................Pacinet..................................................
	private String getTextFromPacient(Pacient pacient){
		if(column.equals("Nume"))
			return pacient.getNume();
		if(column.equals("Prenume"))
			return pacient.getPrenume();
		if(column.equals("Asigurat")){
			if(pacient.isAsigurat())
				return "da";
			else
				return "nu";
			//return ""+pacient.isAsigurat();
		}
		return "";
	}
   
	private void setTextToPacient(Pacient pacient){
		if(column.equals("Nume"))
			 pacient.setNume(value);
		if(column.equals("Prenume"))
			 pacient.setPrenume(value);
		if(column.equals("Asigurat"))
		{
			if(value.equals("true") || value.equals("1"))
				            pacient.setAsigurat(true);
			else
				pacient.setAsigurat(false);
		}
	}
 //..............PacinetRowInformation......................................
		private String getTextFromPatientRowInformation(PatientRowInformation patientRowInformation){
			  if(column.equals(TableMessages.EDIT_INFO.getMessage()))
				  return patientRowInformation.getRowName();
			  if(column.equals("Value"))
				  return patientRowInformation.getValue();
			  return "";
		  }	
		private void setTextToPatientRowInformation(PatientRowInformation patientRowInformation){
			  if(column.equals(TableMessages.EDIT_INFO.getMessage()))
				  patientRowInformation.setRowName(value);
			  if(column.equals(TableMessages.EDIT_VALUE.getMessage()))
				  patientRowInformation.setValue(value);
			 
			 
		  }
//.......................RowReteta.......................................................
		
		private String getTextFromRowReteta(RowReteta row){
			  if(column.equals(RetetaMessages.EDIT_COLUMN1_NAME.getMessage()))
				  return row.getCod();
			  if(column.equals(RetetaMessages.EDIT_COLUMN2_NAME.getMessage()))
				  return row.getNume();
			  if(column.equals(RetetaMessages.EDIT_COLUMN3_NAME.getMessage()))
				  return row.getCantitate();
			  if(column.equals(RetetaMessages.EDIT_COLUMN4_NAME.getMessage()))
				  return row.getAdministrare();
			  return "";
		  }	
		private void setTextToRowReteta(RowReteta row){
			 if(column.equals(RetetaMessages.EDIT_COLUMN1_NAME.getMessage()))
				  row.setCod(value);
			  if(column.equals(RetetaMessages.EDIT_COLUMN2_NAME.getMessage()))
				   row.setNume(value);
			  if(column.equals(RetetaMessages.EDIT_COLUMN3_NAME.getMessage()))
				   row.setCantitate(value);
			  if(column.equals(RetetaMessages.EDIT_COLUMN4_NAME.getMessage()))
				  row.setAdministrare(value);  
						 
		  }
		//..............MedicRowInformation......................................
				private String getTextFromMedicRowInformation(MedicRowInformation medicRowInformation){
					  if(column.equals(TableMessages.EDIT_INFO.getMessage()))
						  return medicRowInformation.getRowName();
					  if(column.equals(TableMessages.EDIT_VALUE.getMessage()))
						  return medicRowInformation.getValue();
					  return "";
				  }	
				private void setTextToMedicRowInformation(MedicRowInformation medicRowInformation){
					  if(column.equals(TableMessages.EDIT_INFO.getMessage()))
						  medicRowInformation.setRowName(value);
					  if(column.equals(TableMessages.EDIT_VALUE.getMessage()))
						  medicRowInformation.setValue(value);
					 
					 
				  }
//..............MedicRowInformation......................................
				private String getTextFromConsult(Consult consult){
					  if(column.equals(PacientMessages.EDIT_COLUMN_DATE.getMessage()))
						  return consult.getDataConsult();
					  else if(column.equals(PacientMessages.EDIT_COLUMN_NUME.getMessage()))
						  return consult.getFisa().getPacient().getNume();
					  else if(column.equals(PacientMessages.EDIT_COLUMN_PRENUME.getMessage()))
						  return consult.getFisa().getPacient().getPrenume();
					  else if(column.equals(PacientMessages.EDIT_COLUMN_OBS.getMessage()))
						  return consult.getObservatii();
					  return "";
				  }	
//......................Medicament...................................................
				private String getTextFromMedicament(Medicament medicamnet){
					if(column.equals(MedicamenteMessages.EDIT_COLUMN1_NAME.getMessage()))
						return medicamnet.getCodAtc();
					else if(column.equals(MedicamenteMessages.EDIT_COLUMN2_NAME.getMessage()))
						return medicamnet.getDenumireInternationala();
					else if(column.equals(MedicamenteMessages.EDIT_COLUMN3_NAME.getMessage()))
						return medicamnet.getDenumireComerciala();
					else if(column.equals(MedicamenteMessages.EDIT_COLUMN4_NAME.getMessage()))
						return medicamnet.getFormaF();
					else if(column.equals(MedicamenteMessages.EDIT_COLUMN5_NAME.getMessage()))
						return medicamnet.getConcentratie();
					else if(column.equals(MedicamenteMessages.EDIT_COLUMN6_NAME.getMessage()))
						return medicamnet.getCantAmbalaj();
					
					return "";
				}
	//...............UtilizatorRow..........................................			
	private String getTextFromUtilizatorRow(UtilizatorRow row){
		if(column.equals(UtilizatorMessages.COLUMN_USERNAME.getMessage()))
		           return row.getUsername();
		else if(column.equals(UtilizatorMessages.COLUMN_NUME.getMessage()))
	           return row.getNume();
		else if(column.equals(UtilizatorMessages.COLUMN_PRENUME.getMessage()))
	           return row.getPrenume();
		else if(column.equals(UtilizatorMessages.COLUMN_TIP.getMessage()))
	           return row.getTip();
		return "";
	}
	///////////////////////////////////////////////////////////////////////	
		
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
