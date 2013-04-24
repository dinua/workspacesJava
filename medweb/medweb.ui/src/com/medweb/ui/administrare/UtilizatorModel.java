package com.medweb.ui.administrare;

import java.util.List;

import medweb.businessService.BusinessService;
import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.CasaAsigurari;
import medweb.psconf.daos.MedicPrimar;
import medweb.psconf.daos.MedicPrimarInfo;
import medweb.psconf.daos.UserType;

public class UtilizatorModel {
	private final BusinessService businessService;
	private static MedicPrimar medicPrimar;
    private static MedicPrimarInfo medicInfo;
	
	public UtilizatorModel(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}
	
	public void getMedicPrimarInfo(){
		MedicPrimarInfo info=null;
		 try {
			info=this.businessService.getInfoMedicPrimar(medicPrimar);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		setMedicInfo(info);
	}
	public List<UserType> getUserTypes(){
		List<UserType> list=null;
		 try {
			list=this.businessService.getAllUserTypes();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}
	protected void internalSave(){
		  try {
			this.businessService.updateMedicPrimarInfo(medicInfo);
		    this.businessService.updateMedicPrimar(medicPrimar);
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
	}


	/**
	 * @return the medicPrimar
	 */
	public  MedicPrimar getMedicPrimar() {
		return medicPrimar;
	}


	/**
	 * @param medicPrimar the medicPrimar to set
	 */
	public  void setMedicPrimar(MedicPrimar medicPrimar) {
		UtilizatorModel.medicPrimar = medicPrimar;
	}

	public List<CasaAsigurari> getAllCasaAsigurari() {
		List<CasaAsigurari> list=null;
		
		try {
			list=this.businessService.getAllCasaAsigurari();
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @return the medicInfo
	 */
	public  MedicPrimarInfo getMedicInfo() {
		return medicInfo;
	}

	/**
	 * @param medicInfo the medicInfo to set
	 */
	public  void setMedicInfo(MedicPrimarInfo medicInfo) {
		UtilizatorModel.medicInfo = medicInfo;
	}

	
	
}
