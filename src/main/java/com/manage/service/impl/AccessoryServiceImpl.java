package com.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manage.mapper.AccessoryMapper;
import com.manage.pojo.Accessory;
import com.manage.service.AccessoryService;
@Service
public class AccessoryServiceImpl implements AccessoryService {

	 @Autowired
  	 private AccessoryMapper mapper;

	public int addAccessory(String t_id, String accessory_category, String accessory_type, String accessory_path,
			String accessory_memo) {
		// TODO Auto-generated method stub
		return mapper.addAccessory(t_id, accessory_category, accessory_type, accessory_path, accessory_memo);
	}

	public List<Accessory> selectaccessorytid(String t_id) {
		// TODO Auto-generated method stub
		return mapper.selectaccessorytid(t_id);
	}

	public Accessory selectid(String id) {
		// TODO Auto-generated method stub
		return mapper.selectid(id);
	}


}
