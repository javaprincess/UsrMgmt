package com.usermanagement.dao;

import com.usermanagmenet.model.ErmSecUser;

public interface ErmSecUserDao {
	

	public ErmSecUser findUserByFullNm(String fullName);

}
