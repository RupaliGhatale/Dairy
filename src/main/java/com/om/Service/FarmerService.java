package com.om.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.Dao.FarmerDaoInterface;
import com.om.model.Farmer;
@Service
@Transactional
public class FarmerService implements ServiceInterface {
	@Autowired
	private FarmerDaoInterface fdoi;

	@Override
	public void addFarmerService(Farmer f) {
		// TODO Auto-generated method stub
		fdoi.AddFarmerInDao(f);
	}

	@Override
	public List<Farmer> getFarmer() {
		List<Farmer>list=fdoi.getFarmer();
		return list;
	}
	@Override
	public Farmer getFarmerById(Integer id) {
		// TODO Auto-generated method stub
		return fdoi.getFarmerById(id);
	}

	@Override
	public boolean updateFarmer(Farmer f) {
		// TODO Auto-generated method stub
		return fdoi.updateFamer(f);
	}

	@Override
	public void addFarmer(Farmer f) {
		fdoi.addFarmInDao(f);
		
	}

	@Override
	public boolean deletFarmer(Integer id) {
		return fdoi.deleteFarmer(id);
		
	}

	
	
}