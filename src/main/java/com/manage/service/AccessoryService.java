package com.manage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.manage.pojo.Accessory;

public interface AccessoryService {
	/**
	 * 
	 * @param t_id ��������id
	 * @param accessory_category �������
	 * @param accessory_type ��������
	 * @param file (MultipartFile fileΪ�ļ�·��)
	 * @param accessory_memo ����˵��
	 * @return
	 */
	public int addAccessory(String t_id,String accessory_category,String accessory_type,String accessory_path,String accessory_memo);
	
	/**
	 * ���ݹ�������id�Ĳ�ѯ
	 * @param t_id
	 * @return 
	 */
	public List<Accessory> selectaccessorytid(String t_id);

	
	/**
	 * ����id
	 * @param id
	 * @return 
	 */
	public Accessory selectid(@Param("t_id")String id); 
}
