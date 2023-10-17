package com.om.Service;

import java.util.List;

import com.om.model.Farmer;

public interface ServiceInterface {

	void addFarmerService(Farmer f);

	void addFarmer(Farmer f);

	List<Farmer> getFarmer();
	Farmer getFarmerById(Integer id);

	boolean updateFarmer(Farmer f);

	boolean deletFarmer(Integer id);

}
