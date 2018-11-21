package com.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.manage.pojo.Accessory;


public interface AccessoryMapper {
	/**
	 * 
	 * @param t_id ��������id
	 * @param accessory_category �������
	 * @param accessory_type ��������
	 * @param file (MultipartFile fileΪ�ļ�·��)
	 * @param accessory_memo ����˵��
	 * @return
	 */
	public int addAccessory(@Param("t_id")String t_id,@Param("accessory_category")String accessory_category
							,@Param("accessory_type")String accessory_type,@Param("accessory_path")String accessory_path
							,@Param("accessory_memo")String accessory_memo);
	
	/**
	 * ���ݹ�������id�Ĳ�ѯ
	 * @param t_id
	 * @return 
	 */
	public List<Accessory> selectaccessorytid(@Param("t_id")String t_id); 
	/**
	 * ����id
	 * @param id
	 * @return 
	 */
	public Accessory selectid(@Param("t_id")String id); 
	
}
