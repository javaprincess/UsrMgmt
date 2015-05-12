package com.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usermanagement.dao.ErmSecUserDao;
import com.usermanagement.model.ErmSecUser;


@Controller
public class UserManagementService {

	@Autowired
	ErmSecUserDao ermSecUserDao;
	
	public UserManagementService () {
		
	}
	
	
	@RequestMapping(value="/search/byFullName", method=RequestMethod.POST)
	public @ResponseBody ErmSecUser findUserByFullName( @RequestBody String fullName) {	
	
		return ermSecUserDao.findUserByFullNm(fullName);
		
	}
	

}
