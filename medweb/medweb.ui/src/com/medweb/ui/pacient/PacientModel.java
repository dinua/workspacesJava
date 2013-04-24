package com.medweb.ui.pacient;

import java.util.List;

import com.medweb.ui.medic.MedicModel;

import medweb.businessService.BusinessService;
import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.CategorieAsigurat;
import medweb.psconf.daos.Pacient;
import medweb.psconf.daos.PacientInfo;

public class PacientModel {

	private final BusinessService businessService;
    private static Pacient pacient=null;
    private static PacientInfo pacientInfo;
    private boolean newPatient=false;
    private MedicModel medicModel;
    
	public PacientModel(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}
	public List<Pacient> getAllLightPatients(){
		try {
			return this.businessService.getAllLightPatients();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<CasaAsigurari> getAllCasaAsigurari(){
		try {
			return this.businessService.getAllCasaAsigurari();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<CategorieAsigurat> getAllCategorieAsigurat(){
		try {
			return this.businessService.getAllCategorieAsigurat();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void getAllInfoForPatient(){
		
		Pacient p = null;
		PacientInfo info;
		try {
			p = this.businessService.getPatientByID(pacient.getIdPacient());
			info = businessService.getInfoPacient(pacient);
			setPacient(p);
			setPacientInfo(info);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void internalSave(){
	
		if(newPatient){
               int id_pacient;
				try {
					pacient.setMedicPrimar(medicModel.getMedicPrimar());
					pacient.getMedicPrimar().setIdMedicPrimar(medicModel.getIdMedicRezident());
					id_pacient = this.businessService.savePatient(pacient);
					 pacientInfo.getPacient().setIdPacient(id_pacient);
	                 this.businessService.savePatientInfo(pacientInfo);
				} catch (BusinessSQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
		}
		else{
			try {
				this.businessService.updatePatient(pacient);
				this.businessService.updatePatientInfo(pacientInfo);
			} catch (BusinessSQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * @return the pacient
	 */
	public  Pacient getPacient() {
		
		return pacient;
	}
	/**
	 * @param pacient the pacient to set
	 */
	public  void setPacient(Pacient pacient) {
		PacientModel.pacient = pacient;
	}
	/**
	 * @return the pacientInfo
	 */
	public  PacientInfo getPacientInfo() {
		return pacientInfo;
	}
	/**
	 * @param pacientInfo the pacientInfo to set
	 */
	public void setPacientInfo(PacientInfo pacientInfo) {
		PacientModel.pacientInfo = pacientInfo;
	}
	
	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
	}
	/**
	 * @return the newPatient
	 */
	public boolean isNewPatient() {
		return newPatient;
	}
	/**
	 * @param newPatient the newPatient to set
	 */
	public void setNewPatient(boolean newPatient) {
		this.newPatient = newPatient;
	}
	/**
	 * @return the medicModel
	 */
	public MedicModel getMedicModel() {
		return medicModel;
	}
	/**
	 * @param medicModel the medicModel to set
	 */
	public void setMedicModel(MedicModel medicModel) {
		this.medicModel = medicModel;
	}
	
	
}
