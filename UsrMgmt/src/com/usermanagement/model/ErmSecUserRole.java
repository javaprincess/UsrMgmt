package com.usermanagement.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the ERM_SEC_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="ERM_SEC_USER_ROLE")
@NamedQuery(name="ErmSecUserRole.findAll", query="SELECT e FROM ErmSecUserRole e")
public class ErmSecUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	//private ErmSecUserRolePK id;
	@Id
	@Column(name="ROLE_ID")
	private long roleId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DT")
	private Date createDt;

	@Column(name="LAST_UPDATE_BY")
	private String lastUpdateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE_DT")
	private Date lastUpdateDt;

	@Column(name="STATUS_CD")
	private String statusCd;

	//bi-directional many-to-one association to ErmSecUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private ErmSecUser ermSecUser;

	public ErmSecUserRole() {
	}
	
	public long getRoleId() {
		return this.roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	/*public ErmSecUserRolePK getId() {
		return this.id;
	}

	public void setId(ErmSecUserRolePK id) {
		this.id = id;
	} */

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getLastUpdateBy() {
		return this.lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateDt() {
		return this.lastUpdateDt;
	}

	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public ErmSecUser getErmSecUser() {
		return this.ermSecUser;
	}

	public void setErmSecUser(ErmSecUser ermSecUser) {
		this.ermSecUser = ermSecUser;
	}

}