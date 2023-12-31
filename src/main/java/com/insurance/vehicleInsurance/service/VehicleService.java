package com.insurance.vehicleInsurance.service;

import java.util.List;
import java.util.Optional;

import com.insurance.vehicleInsurance.dto.VehicleDto;
import com.insurance.vehicleInsurance.entity.Vehicle;
import com.insurance.vehicleInsurance.exception.VehicleException;

public interface VehicleService {
	
	Vehicle addVehicle(VehicleDto newVehicle)throws VehicleException;
	
	Vehicle getVehicleByRegistrationNumber(String registrationNumber)throws VehicleException;
	
	Vehicle updateVehicle(VehicleDto newVehicle)throws VehicleException;
	
	Vehicle deleteVehicleById(String registrationNumber)throws VehicleException;
	
	Optional<Vehicle> findByVehicleRegNumber(String registrationNumber)throws VehicleException;
	
	List<Vehicle>getAllVehicle();
	

}
