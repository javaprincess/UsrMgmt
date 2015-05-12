package com.usermanagmenet.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ERM_SEC_USER_ROLE database table.
 * 
 */
@Embeddable
public class ErmSecUserRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private long userId;

	@Column(name="ROLE_ID", insertable=false, updatable=false)
	private long roleId;

	public ErmSecUserRolePK() {
	}
	public long getUserId() {
		return this.userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return this.roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ErmSecUserRolePK)) {
			return false;
		}
		ErmSecUserRolePK castOther = (ErmSecUserRolePK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.roleId == castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.userId ^ (this.userId >>> 32)));
		hash = hash * prime + ((int) (this.roleId ^ (this.roleId >>> 32)));
		
		return hash;
	}
}