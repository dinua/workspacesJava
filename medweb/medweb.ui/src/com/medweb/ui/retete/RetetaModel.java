package com.medweb.ui.retete;

import com.medweb.ui.medic.MedicModel;
import com.medweb.ui.pacient.PacientModel;

import medweb.businessService.BusinessService;
import medweb.psconf.daos.Fisa;

public class RetetaModel {

	private final BusinessService businessService;
	private MedicModel medicModel;
	private PacientModel patientModel;
	private static Fisa fisa;
	
	public RetetaModel(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}

	/**
	 * @return the businessService
	 */
	public BusinessService getBusinessService() {
		return businessService;
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

	/**
	 * @return the patientModel
	 */
	public PacientModel getPatientModel() {
		return patientModel;
	}

	/**
	 * @param patientModel the patientModel to set
	 */
	public void setPatientModel(PacientModel patientModel) {
		this.patientModel = patientModel;
	}

	/**
	 * @return the fisa
	 */
	public  Fisa getFisa() {
		return fisa;
	}

	/**
	 * @param fisa the fisa to set
	 */
	public  void setFisa(Fisa fisa) {
		RetetaModel.fisa = fisa;
	}

	
}
