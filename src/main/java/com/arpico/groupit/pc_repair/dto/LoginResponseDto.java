package com.arpico.groupit.pc_repair.dto;

import java.util.List;


public class LoginResponseDto {

	private boolean isLogin;
	private boolean isInactive;
	private boolean isFail;
	private boolean isLock;
	private boolean isExpired;
	private boolean isNeedChange;

	private String jwtToken;
	private String userName;
	private Integer failCount;
	private List<MenuDto> menuDtos;

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public boolean isInactive() {
		return isInactive;
	}

	public void setInactive(boolean isInactive) {
		this.isInactive = isInactive;
	}

	public boolean isFail() {
		return isFail;
	}

	public void setFail(boolean isFail) {
		this.isFail = isFail;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public boolean isNeedChange() {
		return isNeedChange;
	}

	public void setNeedChange(boolean isNeedChange) {
		this.isNeedChange = isNeedChange;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<MenuDto> getMenuDtos() {
		return menuDtos;
	}

	public void setMenuDtos(List<MenuDto> menuDtos) {
		this.menuDtos = menuDtos;
	}

	@Override
	public String toString() {
		return "LoginResponseDto [isLogin=" + isLogin + ", isInactive=" + isInactive + ", isFail=" + isFail
				+ ", isLock=" + isLock + ", isExpired=" + isExpired + ", isNeedChange=" + isNeedChange + ", jwtToken="
				+ jwtToken + ", userName=" + userName + ", failCount=" + failCount + ", menuDtos=" + menuDtos + "]";
	}

}
