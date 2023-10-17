package com.om.Dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.model.Farmer;
@Repository
@Component
public class FarmerDaw implements FarmerDaoInterface{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Farmer> getFarmer() {
		// TODO Auto-generated method stub
		
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		List<Farmer> list=(List<Farmer>)session.createQuery("From Farmer").list();
		 trans.commit();
		return list;
	}
	public Farmer getFarmerById(Integer id)
	{
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		 Farmer obj=(Farmer)session.get(Farmer.class, id);
	
		 trans.commit();
		return obj;	
	}

	@Override
	public void AddFarmerInDao(Farmer f) {
		// TODO Auto-generated method stub
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		 session.save(f);
		   trans.commit();
	}

	@Override
	public boolean updateFamer(Farmer f) {
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		session.saveOrUpdate(f);
		 trans.commit();
		return true;
	}

	@Override
	public void addFarmInDao(Farmer f) {
		// TODO Auto-generated method stub

		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		 session.save(f);
		   trans.commit();
	}
	@Override
	public boolean deleteFarmer(Integer id) {
		// TODO Auto-generated method stub
		{
			Session session=(Session)sessionFactory.getCurrentSession();
			 Transaction trans=session.beginTransaction();
			 Farmer fs=(Farmer)session.get(Farmer.class, id);
		session.delete(fs);
			 trans.commit();
			return true;
		}

}
}
