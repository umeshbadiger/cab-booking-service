package com.thinkify.cabbookingservice.model;

public abstract class Vehicle {
	private String modelName;
	private String vehicleNo;

	public Vehicle(String modelName, String vehicleNo) {
		this.modelName = modelName;
		this.vehicleNo = vehicleNo;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
}
