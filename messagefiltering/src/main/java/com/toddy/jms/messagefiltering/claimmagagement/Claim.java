package com.toddy.jms.messagefiltering.claimmagagement;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Claim implements Serializable {

	private int hostpitalID;
	private String doctorType;
	private String doctorName;
	private String insuranceProvider;
	private double claimAmount;

	public Claim(String docName, int hostpitalID, String doctorType, String insuranceProvider, double claimAmount) {
		this.hostpitalID = hostpitalID;
		this.doctorType = doctorType;
		this.insuranceProvider = insuranceProvider;
		this.claimAmount = claimAmount;
		this.setDoctorName(docName);
	}

	public int getHostpitalID() {
		return this.hostpitalID;
	}

	public void setHostpitalID(int hostpitalID) {
		this.hostpitalID = hostpitalID;
	}

	public String getDoctorType() {
		return this.doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getInsuranceProvider() {
		return this.insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public double getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Override
	public String toString() {
		return "Claim [getHostpitalID()=" + getHostpitalID() + ", getDoctorType()=" + getDoctorType()
				+ ", getInsuranceProvider()=" + getInsuranceProvider() + ", getClaimAmount()=" + getClaimAmount()
				+ ", getDoctorName()=" + getDoctorName() + "]";
	}

}
