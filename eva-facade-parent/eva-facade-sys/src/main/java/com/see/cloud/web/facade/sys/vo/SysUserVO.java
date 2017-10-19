package com.see.cloud.web.facade.sys.vo;

import java.io.Serializable;
import java.util.Date;

public class SysUserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4455994938229574618L;

	private Integer id;

	private String nickname;

	private String email;

	private String pswd;

	private Date createTime;

	private Date lastLoginTime;

	private Byte status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SysUserVO [id=" + id + ", nickname=" + nickname + ", email=" + email + ", pswd=" + pswd
				+ ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + ", status=" + status + "]";
	}

}
