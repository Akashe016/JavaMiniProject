package com.example.StudentRecords.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.StudentRecords.DAO.UserDAO;
import com.example.StudentRecords.model.UserModel;


@Controller
public class UserController {

	@Autowired
	UserDAO userdao;
	
	@RequestMapping("index")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping("insert")
	public String insert(UserModel userModel) {
		
		userModel.setName(userModel.getName());
		userModel.setAge(userModel.getAge());
		userModel.setEmail(userModel.getEmail());
		userModel.setCity(userModel.getCity());
		
		userdao.save(userModel);
		return "index.jsp";
	}

	@RequestMapping("update")
	public String Update(UserModel userModel) {
		
		
		userModel.setId(userModel.getId());
		userModel.setName(userModel.getName());
		userModel.setAge(userModel.getAge());
		userModel.setEmail(userModel.getEmail());
		userModel.setCity(userModel.getCity());
		
		userdao.save(userModel);
		
		/*ModelAndView mav = new ModelAndView("update.jsp");
		UserModel user = userdao.getById(id);
		mav.addObject("user",user);
		//userdao.getById(id);
		*/
		
		return "update.jsp";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam int id) {
		
		userdao.deleteById(id);
		return "index.jsp";
	}
	
	@RequestMapping("select")
	public ModelAndView Select(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("select.jsp");
		UserModel user = userdao.findById(id).orElse(new UserModel());
		mav.addObject("user",user);		
		return mav;
	}
}
