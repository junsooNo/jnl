package com.spring.study.dto;

public class MenuDTO {
	private int menu_num;
	private String name;
	private int parent_menu;
	private int menu_level;
	private String reg_date;
	private String reg_id;
	private String mod_date;
	private String mod_id;
	private String use_yn;
	public MenuDTO() {
		
	}
	public MenuDTO(int menu_num, String name, int parent_menu, int menu_level, String reg_date, String reg_id,
			String mod_date, String mod_id, String use_yn) {
		super();
		this.menu_num = menu_num;
		this.name = name;
		this.parent_menu = parent_menu;
		this.menu_level = menu_level;
		this.reg_date = reg_date;
		this.reg_id = reg_id;
		this.mod_date = mod_date;
		this.mod_id = mod_id;
		this.use_yn = use_yn;
	}
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_menu() {
		return parent_menu;
	}
	public void setParent_menu(int parent_menu) {
		this.parent_menu = parent_menu;
	}
	public int getMenu_level() {
		return menu_level;
	}
	public void setMenu_level(int menu_level) {
		this.menu_level = menu_level;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getMod_date() {
		return mod_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	public String getMod_id() {
		return mod_id;
	}
	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
}
