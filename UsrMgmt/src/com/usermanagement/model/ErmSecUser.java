package com.usermanagement.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ERM_SEC_USER database table.
 * 
 */
@Entity
@Table(name="ERM_SEC_USER")
@NamedQuery(name="ErmSecUser.findAll", query="SELECT e FROM ErmSecUser e")
public class ErmSecUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private long userId;

	@Column(name="ADMIN_IND")
	private String adminInd;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DT")
	private Date createDt;

	@Column(name="DB_ACCS_FLG")
	private String dbAccsFlg;

	@Column(name="EMAIL_ADDR")
	private String emailAddr;

	@Column(name="FULL_NM")
	private String fullNm;

	@Column(name="LAST_UPDATE_BY")
	private String lastUpdateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE_DT")
	private Date lastUpdateDt;

	@Column(name="LOGIN_ID")
	private String loginId;

	private String notes;

	@Column(name="STATUS_CD")
	private String statusCd;

	@Column(name="USER_TYPE")
	private String userType;

	//bi-directional many-to-one association to ErmSecUserRole
	@OneToMany(mappedBy="ermSecUser")
	private List<ErmSecUserRole> ermSecUserRoles;

	public ErmSecUser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAdminInd() {
		return this.adminInd;
	}

	public void setAdminInd(String adminInd) {
		this.adminInd = adminInd;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getDbAccsFlg() {
		return this.dbAccsFlg;
	}

	public void setDbAccsFlg(String dbAccsFlg) {
		this.dbAccsFlg = dbAccsFlg;
	}

	public String getEmailAddr() {
		return this.emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getFullNm() {
		return this.fullNm;
	}

	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
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

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatusCd() {
		return this.statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<ErmSecUserRole> getErmSecUserRoles() {
		return this.ermSecUserRoles;
	}

	public void setErmSecUserRoles(List<ErmSecUserRole> ermSecUserRoles) {
		this.ermSecUserRoles = ermSecUserRoles;
	}

	public ErmSecUserRole addErmSecUserRole(ErmSecUserRole ermSecUserRole) {
		getErmSecUserRoles().add(ermSecUserRole);
		ermSecUserRole.setErmSecUser(this);

		return ermSecUserRole;
	}

	public ErmSecUserRole removeErmSecUserRole(ErmSecUserRole ermSecUserRole) {
		getErmSecUserRoles().remove(ermSecUserRole);
		ermSecUserRole.setErmSecUser(null);

		return ermSecUserRole;
	}

}