package com.medweb.ui.medic;

import java.util.List;

import medweb.businessService.BusinessService;
import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;
import medweb.psconf.daos.Orar;
import medweb.psconf.daos.User;

public class MedicModel {
	private final BusinessService businessService;
	private static MedicPrimar medicPrimar =null;
	private static MedicPrimarInfo medicPrimarInfo =null;
	private static User user;
	private static int idMedicRezident;
	private static boolean restricted;
	
	public MedicModel(BusinessService businessService) {
		super();
		this.businessService = businessService;
		
		//**********************************
		//MedicPrimar m=this.getBusinessService().getMedicPrimarByID(2);
		//setMedicPrimar(m);
		//MedicPrimarInfo mpi=this.getBusinessService().getInfoMedicPrimar(m);
		//setMedicPrimarInfo(mpi);
		//***********************************
	}
	
	public List<CasaAsigurari> getAllCasaAsigurari(){
		try {
			return this.getBusinessService().getAllCasaAsigurari();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected void internalSave(){
		  try {
			this.businessService.updateMedicPrimarInfo(medicPrimarInfo);
		    this.businessService.updateMedicPrimar(medicPrimar);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public Orar getOrarMedic(){
		try {
			return this.businessService.getOrarMedic(medicPrimar);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @return the medicPrimar
	 */
	public MedicPrimar getMedicPrimar() {
		return medicPrimar;
	}
	/**
	 * @param medicPrimar the medicPrimar to set
	 */
	public void setMedicPrimar(MedicPrimar medicPrimar) {
		MedicModel.medicPrimar = medicPrimar;
	}

	/**
	 * @return the medicPrimarInfo
	 */
	public  MedicPrimarInfo getMedicPrimarInfo() {
		try {
			return this.getBusinessService().getInfoMedicPrimar(medicPrimar);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param medicPrimarInfo the medicPrimarInfo to set
	 */
	public  void setMedicPrimarInfo(MedicPrimarInfo medicPrimarInfo) {
		MedicModel.medicPrimarInfo = medicPrimarInfo;
	}

	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
	}

	/**
	 * @return the user
	 */
	public  User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public  void setUser(User user) {
		MedicModel.user = user;
	}

	/**
	 * @return the idMedicRezident
	 */
	public  int getIdMedicRezident() {
		return idMedicRezident;
	}

	/**
	 * @param idMedicRezident the idMedicRezident to set
	 */
	public  void setIdMedicRezident(int idMedicRezident) {
		MedicModel.idMedicRezident = idMedicRezident;
	}

	/**
	 * @return the restricted
	 */
	public  boolean isRestricted() {
		return restricted;
	}

	/**
	 * @param restricted the restricted to set
	 */
	public  void setRestricted(boolean restricted) {
		MedicModel.restricted = restricted;
	}

	
	
}
