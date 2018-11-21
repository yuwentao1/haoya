package com.manage.pojo;

import java.io.Serializable;

/**
 * 附件表的实体类
 * @author 安格
 *
 */
public class Accessory implements Serializable{
	   private String  id;
	   private String t_id;//对应类型的id
	   private String accessory_category;//附件类别
	   private String  accessory_type;//附件类型
	   private String accessory_path;//附件路径
	   private String accessory_memo;//附件说明
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getAccessory_category() {
		return accessory_category;
	}
	public void setAccessory_category(String accessory_category) {
		this.accessory_category = accessory_category;
	}
	public String getAccessory_type() {
		return accessory_type;
	}
	public void setAccessory_type(String accessory_type) {
		this.accessory_type = accessory_type;
	}
	public String getAccessory_path() {
		return accessory_path;
	}
	public void setAccessory_path(String accessory_path) {
		this.accessory_path = accessory_path;
	}
	public String getAccessory_memo() {
		return accessory_memo;
	}
	public void setAccessory_memo(String accessory_memo) {
		this.accessory_memo = accessory_memo;
	}

	
	
}
