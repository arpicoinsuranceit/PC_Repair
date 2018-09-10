package com.arpico.groupit.pc_repair.dto;

public class MenuDto {
	private String menuId;
	private String menuName;
	private String menuDescription;
	private String href;
	private String parent;
	private Integer level;
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "MenuDto [menuId=" + menuId + ", menuName=" + menuName + ", menuDescription=" + menuDescription
				+ ", href=" + href + ", parent=" + parent + ", level=" + level + "]";
	}
}