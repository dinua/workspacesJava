package com.medweb.ui.medicamente;

import medweb.businessService.BusinessService;
import medweb.businessService.exceptions.BusinessSQLException;
import medweb.psconf.daos.Medicament;
import medweb.psconf.daos.MedicamentInfo;

public class MedicamneteModel {
	private final BusinessService businessService;
	private static Medicament medicament;
	private static MedicamentInfo medicamentInfo;
	
	public MedicamneteModel(final BusinessService bService){
		super();
		this.businessService=bService;
	}

	public void setInfoToMedicament(){
		MedicamentInfo info = null;
		try {
			info = this.businessService.getMedicamentInfoById(medicament.getIdMedicament());
		} catch (BusinessSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMedicamentInfo(info);
	}
	
	
	/**
	 * @return the medicament
	 */
	public  Medicament getMedicament() {
		return medicament;
	}

	/**
	 * @param medicament the medicament to set
	 */
	public void setMedicament(Medicament medicament) {
		MedicamneteModel.medicament = medicament;
	}

	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
	}

	/**
	 * @return the medicamentInfo
	 */
	public  MedicamentInfo getMedicamentInfo() {
		return medicamentInfo;
	}

	/**
	 * @param medicamentInfo the medicamentInfo to set
	 */
	public  void setMedicamentInfo(MedicamentInfo medicamentInfo) {
		MedicamneteModel.medicamentInfo = medicamentInfo;
	}
	
	
}
