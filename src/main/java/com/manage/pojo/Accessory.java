package com.manage.pojo;

import java.io.Serializable;

/**
 * �������ʵ����
 * @author ����
 *
 */
public class Accessory implements Serializable{
	   private String  id;
	   private String t_id;//��Ӧ���͵�id
	   private String accessory_category;//�������
	   private String  accessory_type;//��������
	   private String accessory_path;//����·��
	   private String accessory_memo;//����˵��
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
