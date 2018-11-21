package com.manage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.manage.pojo.Accessory;

public interface AccessoryService {
	/**
	 * 
	 * @param t_id 故障申请id
	 * @param accessory_category 附件类别
	 * @param accessory_type 附件类型
	 * @param file (MultipartFile file为文件路径)
	 * @param accessory_memo 附件说明
	 * @return
	 */
	public int addAccessory(String t_id,String accessory_category,String accessory_type,String accessory_path,String accessory_memo);
	
	/**
	 * 根据故障申请id的查询
	 * @param t_id
	 * @return 
	 */
	public List<Accessory> selectaccessorytid(String t_id);

	
	/**
	 * 根据id
	 * @param id
	 * @return 
	 */
	public Accessory selectid(@Param("t_id")String id); 
}
