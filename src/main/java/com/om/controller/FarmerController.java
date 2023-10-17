package com.om.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.om.Service.ServiceInterface;
import com.om.model.Farmer;
import com.om.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;
@Controller
public class FarmerController {
		@Autowired
		private ServiceInterface sf;
		@RequestMapping("home")
		public String OpenHomePage()
		{
			System.out.println("opening home page");
			return "home";
		
		}
		@RequestMapping("login")
		public String OpenLoginPage() {
			System.out.println("opening Login page");
			return "login";	
		}
		@RequestMapping("checkLogin")
		public ModelAndView checkLogin(HttpServletRequest request,Model model)
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if (username.equals("Rupali") && password.equals("Rupali123") ){
				System.out.println("Login Successfully");
				return new ModelAndView("home");
				}else{
					model.addAttribute("errorMsg", "Incorrest Username or Password");
					return new ModelAndView("login");
				}	
		
		}
		
		@RequestMapping(method = RequestMethod.POST, value="addFarmer")
		public ModelAndView addFarmer(HttpServletRequest request,HttpServletResponse response)
		{
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			Farmer f=new Farmer();
			f.setName(name);
			f.setAddress(address);
			f.setPhone(phone);
			System.out.println(f);
			sf.addFarmerService(f);
			sf.addFarmer(f);
			return new ModelAndView("home");
		}
		@RequestMapping("/aboutpage")
		public ModelAndView showData() {
			List<Farmer>list=sf.getFarmer();
			System.out.println(list);
			ModelAndView model=new ModelAndView();
			model.addObject("list",list);
			model.setViewName("about");
			return model;
		}
		
		@RequestMapping("/updateFarmer")
		
		public ModelAndView openUpdateFarmerPage(HttpServletRequest req) {
			Integer id = Integer.parseInt(req.getParameter("id"));
			Farmer obj = sf.getFarmerById(id);
			ModelAndView model = new ModelAndView("update");
			model.addObject("Farmer", obj);
			
			return model;
		}
		
		@RequestMapping(value = "updateFarmer", method = RequestMethod.POST)
		public ModelAndView updateFarmer(@ModelAttribute Farmer f) {
			sf.updateFarmer(f);
			List<Farmer> list = sf.getFarmer();
			System.out.println(list);
			ModelAndView model = new ModelAndView();
			model.addObject("list", list);
			model.setViewName("about");
			return model;
		}
		
		@RequestMapping(value="AllStudentReport")
		public String AllStudentReport(HttpServletRequest request, HttpSession httpSession,
				HttpServletResponse response) throws JRException, NamingException, SQLException, IOException
		{
			System.out.println("opening AllStudentReport");
			
			String filename = "report2";
			HashMap<String, Object> hm = new HashMap<String, Object>();
			PrintJasperReport.printreport(filename, request, response, hm);
			
			return "home";
		}
		@RequestMapping(value="deleteFarmer")
		public ModelAndView deleteFarmer(HttpServletRequest req) {
			Integer id = Integer.parseInt(req.getParameter("id"));
			sf.deletFarmer(id);
			List<Farmer>list=sf.getFarmer();
			System.out.println(list);
			ModelAndView model = new ModelAndView();
			model.addObject("list", list);
			model.setViewName("about");
			return model;
		}
		
}
