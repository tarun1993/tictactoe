package com.cars;

import android.graphics.Bitmap;

public class RowItem {
	private Bitmap imageId;
	private String name, brand, price, mileage, engCapacity,
			noOfCylinders, valves, maxPower, maxTorque, fuelType, gndClearance,
			powSteering, adjSteering, seatingCapacity, abs, transmissionType,
			noOfAirbags, alloyWheels, bodyStyle, bluetooth, colors,
			electricOVRM, fogLights, powerWindows, rearAC, rearWiper;

	public RowItem(Bitmap bitmap, String name, String brand,
			String price, String mileage, String engCapacity,
			String noOfCylinders, String valves, String maxPower,
			String maxTorque, String fuelType, String gndClearance,
			String powSteering, String adjSteering, String seatingCapacity,
			String abs, String transmissionType, String noOfAirbags,
			String alloyWheels, String bodyStyle, String bluetooth,
			String colors, String electricOVRM, String fogLights,
			String powerWindows, String rearAC, String rearWiper) {
		// TODO Auto-generated constructor stub

		
		this.imageId = bitmap;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.mileage = mileage;
		this.engCapacity = engCapacity;
		this.noOfCylinders = noOfCylinders;
		this.valves = valves;
		this.maxPower = maxPower;
		this.maxTorque = maxTorque;
		this.fuelType = fuelType;
		this.gndClearance = gndClearance;
		this.powSteering = powSteering;
		this.adjSteering = adjSteering;
		this.seatingCapacity = seatingCapacity;
		this.abs = abs;
		this.transmissionType = transmissionType;
		this.noOfAirbags = noOfAirbags;
		this.alloyWheels = alloyWheels;
		this.bodyStyle = bodyStyle;
		this.bluetooth = bluetooth;
		this.colors = colors;
		this.electricOVRM = electricOVRM;
		this.fogLights = fogLights;
		this.powerWindows = powerWindows;
		this.rearAC = rearAC;
		this.rearWiper = rearWiper;

	}

	public Bitmap getImageId() {
		return imageId;
	}

	public void setImageId(Bitmap imageId) {
		this.imageId = imageId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getEngCapacity() {
		return engCapacity;
	}

	public void setEngCapacity(String engCapacity) {
		this.engCapacity = engCapacity;
	}

	public String getNoOfCylinders() {
		return noOfCylinders;
	}

	public void setNoOfCylinders(String noOfCylinders) {
		this.noOfCylinders = noOfCylinders;
	}

	public String getValves() {
		return valves;
	}

	public void setValves(String valves) {
		this.valves = valves;
	}

	public String getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(String maxPower) {
		this.maxPower = maxPower;
	}

	public String getMaxTorque() {
		return maxTorque;
	}

	public void setMaxTorque(String maxTorque) {
		this.maxTorque = maxTorque;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getGndClearance() {
		return gndClearance;
	}

	public void setGndClearance(String gndClearance) {
		this.gndClearance = gndClearance;
	}

	public String getPowSteering() {
		return powSteering;
	}

	public void setPowSteering(String powSteering) {
		this.powSteering = powSteering;
	}

	public String getAdjSteering() {
		return adjSteering;
	}

	public void setAdjSteering(String adjSteering) {
		this.adjSteering = adjSteering;
	}

	public String getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getNoOfAirbags() {
		return noOfAirbags;
	}

	public void setNoOfAirbags(String noOfAirbags) {
		this.noOfAirbags = noOfAirbags;
	}

	public String getAlloyWheels() {
		return alloyWheels;
	}

	public void setAlloyWheels(String alloyWheels) {
		this.alloyWheels = alloyWheels;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public String getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getElectricOVRM() {
		return electricOVRM;
	}

	public void setElectricOVRM(String electricOVRM) {
		this.electricOVRM = electricOVRM;
	}

	public String getFogLights() {
		return fogLights;
	}

	public void setFogLights(String fogLights) {
		this.fogLights = fogLights;
	}

	public String getPowerWindows() {
		return powerWindows;
	}

	public void setPowerWindows(String powerWindows) {
		this.powerWindows = powerWindows;
	}

	public String getRearAC() {
		return rearAC;
	}

	public void setRearAC(String rearAC) {
		this.rearAC = rearAC;
	}

	public String getRearWiper() {
		return rearWiper;
	}

	public void setRearWiper(String rearWiper) {
		this.rearWiper = rearWiper;
	}
}