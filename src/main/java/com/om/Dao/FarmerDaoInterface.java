package com.om.Dao;

import java.util.List;

import com.om.model.Farmer;

public interface FarmerDaoInterface {

	void AddFarmerInDao(Farmer f);

	List<Farmer> getFarmer();

	Farmer getFarmerById(Integer id);

	boolean updateFamer(Farmer f);

	void addFarmInDao(Farmer f);

	boolean deleteFarmer(Integer id);

	
}
