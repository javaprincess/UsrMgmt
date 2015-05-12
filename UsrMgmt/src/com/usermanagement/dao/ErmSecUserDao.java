package com.usermanagement.dao;

import com.usermanagement.model.ErmSecUser;


public interface ErmSecUserDao {
	

	public ErmSecUser findUserByFullNm(String fullName);
	public boolean deleteByLoginId(Integer loginId);

}
